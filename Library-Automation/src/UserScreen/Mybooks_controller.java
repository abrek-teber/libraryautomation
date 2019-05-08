package UserScreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mybooks_controller {

    @FXML
    public Label lblusername6;
    @FXML
    public Label lblBookTitle;
    private ObservableList<TakenBooks> data;
    @FXML
    private TableView<TakenBooks> MyBooksTable;
    @FXML
    private TableColumn<TakenBooks,String> books_userid;
    @FXML
    private TableColumn<TakenBooks,String> books_username;
    @FXML
    private TableColumn<TakenBooks,String> books_bookid;
    @FXML
    private TableColumn<TakenBooks,String> books_bookname;

    Stage stage = new Stage();

    public void gotousermainscreen4(String text){

        lblusername6.setText(text);
    }
    public void goback(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("Myprofile.fxml"));
        Parent root2 = loader2.load();
        myprofile_controller thirdController = loader2.getController();
        thirdController.gotomyprofilecontroller(lblusername6.getText());

        stage.setTitle("User Screen");
        Scene scene2 = new Scene(root2);
        stage.setScene(scene2);
        stage.show();
    }
    public void ShowMyBooks(ActionEvent event)  {
        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();

        try {

            data = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery("select * from taken_books where Username='"+lblusername6.getText()+"'");

            while(rs.next())
            {
                data.add(new TakenBooks(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        books_userid.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        books_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        books_bookid.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        books_bookname.setCellValueFactory(new PropertyValueFactory<>("bookname"));



        MyBooksTable.setItems(null);
        MyBooksTable.setItems(data);

    }

    public void displaySelected(MouseEvent event)
    {
        lblBookTitle.setVisible(false);

        TakenBooks getRow = MyBooksTable.getSelectionModel().getSelectedItem();
        String bookname = getRow.getbookname();
        lblBookTitle.setText(bookname);
    }

    public void ReturnRentedBook(ActionEvent event)throws SQLException
    {
        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();

        String sql = "DELETE FROM taken_books WHERE bookname='"+lblBookTitle.getText()+"'";
        Statement statement = connection.createStatement();
        statement.execute(sql);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("You have successfully returned your book!");

        alert.showAndWait();

    }


}
