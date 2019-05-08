package UserScreen;

import Login.DBConnection;
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
import java.sql.*;

public class allbooks_controller {
    @FXML
    private TableView<bookdetails> tablebooks;
    @FXML
    private TableColumn<bookdetails,String> Columnbookid;
    @FXML
    private TableColumn<bookdetails,String> Columnbookname;
    @FXML
    private TableColumn<bookdetails,String> Columnauthor;
    @FXML
    private TableColumn<bookdetails,String> Columnbooktype;

    private DBConnection dc;
    @FXML
    public TextField textfield1;
    @FXML
    public TextField textfield2;
    @FXML
    public TextField search;
    @FXML
    public Label lblBookTitle;
    @FXML
    public Label lblBookID;
    @FXML
    public Label lblusername5;
    @FXML
    public TextField book1;
    Stage stage = new Stage();
    public void gotousermainscreen6(String text){

        lblusername5.setText(text);
    }
    private ObservableList<bookdetails> data;
    public void booklist(ActionEvent event)  {
        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();

        try {

            data = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery("select * from viewallbooks ");

            while(rs.next())
            {
                data.add(new bookdetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        Columnbookid.setCellValueFactory(new PropertyValueFactory<>("Bookid"));
        Columnbookname.setCellValueFactory(new PropertyValueFactory<>("Bookname"));
        Columnauthor.setCellValueFactory(new PropertyValueFactory<>("Bookauthor"));
        Columnbooktype.setCellValueFactory(new PropertyValueFactory<>("Booktype"));



        tablebooks.setItems(null);
        tablebooks.setItems(data);

    }
    public void goback2(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("UserMainScreen.fxml"));
        Parent root2 = loader2.load();
        User_Screen_Controller thirdController = loader2.getController();
        thirdController.gotousermainscreen(lblusername5.getText());

        stage.setTitle("User Screen");
        Scene scene2 = new Scene(root2);
        stage.setScene(scene2);
        stage.show();
    }
    public void Searchbook(ActionEvent event)
    {
        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();


        try {
            data = FXCollections.observableArrayList();
            // Execute query
            ResultSet resultSet = connection.createStatement().executeQuery("select * from books where Bookname='"+search.getText()+"'");

            while(resultSet.next())
            {
                //get string from db
                data.add(new bookdetails(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));

            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        // Set cell value factory to Table view
        // NB.PropertyValue Factory must be same with the one set in model class.
        Columnbookid.setCellValueFactory(new PropertyValueFactory<>("Bookid"));
        Columnbookname.setCellValueFactory(new PropertyValueFactory<>("Bookname"));
        Columnauthor.setCellValueFactory(new PropertyValueFactory<>("Bookauthor"));
        Columnbooktype.setCellValueFactory(new PropertyValueFactory<>("Booktype"));



        tablebooks.setItems(null);
        tablebooks.setItems(data);
    }

    public void displaySelected(MouseEvent event)
    {

        lblBookID.setVisible(false);
        lblBookTitle.setVisible(false);
        bookdetails getRow = tablebooks.getSelectionModel().getSelectedItem();

        String book_id = getRow.getBookid();
        String book_title = getRow.getBookname();
        lblBookID.setText(book_id);
        lblBookTitle.setText(book_title);
    }

    public void RentBook(ActionEvent event)throws SQLException
    {
        Connection conn = dc.connect();


        String queryCount="{call CountRentedBooks(?,?)}";

        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();

        CallableStatement stmt=connection.prepareCall(queryCount);
        stmt.setString(1,lblBookTitle.getText());
        stmt.setString(2,textfield1.getText());

        ResultSet rsCount=stmt.executeQuery();


        while(rsCount.next())
        {
            int counter = rsCount.getInt(1);
            int counter2 = rsCount.getInt(1);

            if(counter < 1)
            {
                String sql = "INSERT INTO taken_books VALUES('"+textfield1.getText()+"','"+lblusername5.getText()+"','"+lblBookID.getText()+"','"+lblBookTitle.getText()+"')";
                Statement statement = conn.createStatement();
                statement.execute(sql);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("");
                alert.setHeaderText("You have successfully took the book!");
                alert.showAndWait();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("Error occurred!");
                alert.setContentText("You already have that book!");

                alert.showAndWait();
            }
        }
    }





}
