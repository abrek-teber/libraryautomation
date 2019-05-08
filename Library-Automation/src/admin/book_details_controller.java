package admin;

import Login.DBConnection;
import UserScreen.User_Details;
import UserScreen.bookdetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class book_details_controller {
    @FXML
    private TableView<bookdetails> booklist;
    @FXML
    private TableColumn<bookdetails,String> Bookid;
    @FXML
    private TableColumn<bookdetails,String> Bookname;
    @FXML
    private TableColumn<bookdetails,String> Bookauthor;
    @FXML
    private TableColumn<bookdetails,String> Booktype;

    @FXML
    private TableView<Authors> tableauthor;
    @FXML
    private TableColumn<Authors,String> authorid;
    @FXML
    private TableColumn<Authors,String> authorname;

    @FXML
    private TableView<Categories> tablecategory;
    @FXML
    private TableColumn<Categories,String> category_id ;
    @FXML
    private TableColumn<Categories,String> category_name;

    private DBConnection dc;
    private ObservableList<bookdetails> data;
    private ObservableList<Authors> data_authors;
    private ObservableList<Categories> data_categories;
    @FXML
    public TextField Authorid;
    @FXML
    public TextField Authorname;
    @FXML
    public TextField deleteauthorid;
    @FXML
    public TextField categoryid;
    @FXML
    public TextField categoryname;
    @FXML
    public TextField deletecategoryid;
    @FXML
    public TextField bookid;
    @FXML
    public TextField bookname;
    @FXML
    public TextField bookauthor;
    @FXML
    public TextField booktype;
    @FXML
    public TextField boook;
    Stage stage = new Stage();




    public void showbooklist(ActionEvent event)  {
        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();

        try {

            data = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery("select * from books ");

            while(rs.next())
            {
                data.add(new bookdetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        Bookid.setCellValueFactory(new PropertyValueFactory<>("Bookid"));
        Bookname.setCellValueFactory(new PropertyValueFactory<>("Bookname"));
        Bookauthor.setCellValueFactory(new PropertyValueFactory<>("Bookauthor"));
        Booktype.setCellValueFactory(new PropertyValueFactory<>("Booktype"));



        booklist.setItems(null);
        booklist.setItems(data);

    }
    public void addbook(ActionEvent event) throws SQLException, IOException {

        DBConnection connclass = new DBConnection();
        Connection conn = DBConnection.connect();
        /*
        if(User_Name.getText().isEmpty() ||First_Name.getText().isEmpty() || Last_Name.getText().isEmpty() || Password.getText().isEmpty() )
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Error occurred!");
            alert.setContentText("Please enter all necessary information!");

            alert.showAndWait();
        }*/

            String sql = "INSERT INTO books VALUES('"+bookid.getText()+"','"+bookname.getText()+"','"+bookauthor.getText()+"','"+booktype.getText()+"')";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("You have successfully added the book!");

            alert.showAndWait();
    }
    public void bookdelete(ActionEvent event) throws SQLException, IOException {

        DBConnection connclass = new DBConnection();
        Connection conn = DBConnection.connect();


        String sql = "DELETE FROM books WHERE Bookname='"+boook.getText()+"'";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("You have successfully deleted the book!");

        alert.showAndWait();
    }
    public void gogoback (ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Scene scnSignin = new Scene(p1);

        stage.setTitle("Home Page");
        stage.setScene(scnSignin);
        stage.show();
    }
    public void showauthors(ActionEvent event)
    {
        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();


        try {
            data_authors = FXCollections.observableArrayList();
            // Execute query
            ResultSet resultSet = connection.createStatement().executeQuery("select * from author ");

            while(resultSet.next())
            {
                //get string from db
                data_authors.add(new Authors(resultSet.getString(1),resultSet.getString(2)));

            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        // Set cell value factory to Table view
        // NB.PropertyValue Factory must be same with the one set in model class.
        authorid.setCellValueFactory(new PropertyValueFactory<>("authorid"));
        authorname.setCellValueFactory(new PropertyValueFactory<>("authorname"));



        tableauthor.setItems(null);
        tableauthor.setItems(data_authors);

    }
    public void showcategories(ActionEvent event)
    {
        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();


        try {
            data_categories = FXCollections.observableArrayList();
            // Execute query
            ResultSet resultSet = connection.createStatement().executeQuery("select * from categories ");

            while(resultSet.next())
            {
                //get string from db
                data_categories.add(new Categories(resultSet.getString(1),resultSet.getString(2)));

            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        // Set cell value factory to Table view
        // NB.PropertyValue Factory must be same with the one set in model class.
        category_id.setCellValueFactory(new PropertyValueFactory<>("category_id"));
        category_name.setCellValueFactory(new PropertyValueFactory<>("category_name"));



        tablecategory.setItems(null);
        tablecategory.setItems(data_categories);

    }

    public void addauthor (ActionEvent event) throws SQLException, IOException {

        DBConnection connclass = new DBConnection();
        Connection conn = DBConnection.connect();

        String sql = "INSERT INTO author VALUES('"+Authorid.getText()+"','"+Authorname.getText()+"')";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("You have successfully added the author!");

        alert.showAndWait();
    }
    public void addcategories (ActionEvent event) throws SQLException, IOException {

        DBConnection connclass = new DBConnection();
        Connection conn = DBConnection.connect();

        String sql = "INSERT INTO categories VALUES('"+categoryid.getText()+"','"+categoryname.getText()+"')";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("You have successfully added the category!");

        alert.showAndWait();
    }
    public void deleteauthorid(ActionEvent event) throws SQLException, IOException {

        DBConnection connclass = new DBConnection();
        Connection conn = DBConnection.connect();


        String sql = "DELETE FROM author WHERE authorid='"+deleteauthorid.getText()+"'";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("You have successfully deleted the author!");

        alert.showAndWait();
    }
    public void deletecategoryid(ActionEvent event) throws SQLException, IOException {

        DBConnection connclass = new DBConnection();
        Connection conn = DBConnection.connect();


        String sql = "DELETE FROM categories WHERE category_id='"+deletecategoryid.getText()+"'";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("You have successfully deleted the category!");

        alert.showAndWait();
    }







}
