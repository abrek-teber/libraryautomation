package admin;

import UserScreen.User_Details;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class user_details_controller {
    @FXML
    private TableView<User_Details> tableuser;
    @FXML
    private TableColumn<User_Details,String> Columnid;
    @FXML
    private TableColumn<User_Details,String> Columnusername;
    @FXML
    private TableColumn<User_Details,String> Columnfirstname;
    @FXML
    private TableColumn<User_Details,String> Columnlastname;
    @FXML
    private TableColumn<User_Details,String> Columnsex;
    @FXML
    private TableColumn<User_Details,String> Columnpassword;
    @FXML
    private TableColumn<User_Details,String> Columnphone;
    @FXML
    private TableColumn<User_Details,String> Columnemail;
    @FXML
    private TableColumn<User_Details,String> Columncolor;
    private ObservableList<User_Details> data;
    @FXML
    private TableView<user_backup_details> tablebackup;
    @FXML
    private TableColumn<user_backup_details,String> username_backup;
    @FXML
    private TableColumn<user_backup_details,String> firstname_backup;
    @FXML
    private TableColumn<user_backup_details,String> lastname_backup;
    @FXML
    private TableColumn<user_backup_details,String> password_backup;
    @FXML
    private TableColumn<user_backup_details,String> phone_backup;
    @FXML
    private TableColumn<user_backup_details,String> email_backup;
    @FXML
    private TableColumn<user_backup_details,String> color_backup;
    private ObservableList<user_backup_details> data1;

    Stage stage = new Stage();


    public void showusers(ActionEvent event)  {
        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();

        try {

            data = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery("select * from users");

            while(rs.next())
            {
                data.add(new User_Details(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        Columnid.setCellValueFactory(new PropertyValueFactory<>("id"));
        Columnusername.setCellValueFactory(new PropertyValueFactory<>("Username"));
        Columnfirstname.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
        Columnlastname.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
        Columnsex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        Columnpassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        Columnphone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        Columnemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Columncolor.setCellValueFactory(new PropertyValueFactory<>("Color"));


        tableuser.setItems(null);
        tableuser.setItems(data);

    }
    public void showuserbackup(ActionEvent event)  {
        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();

        try {

            data1 = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery("select * from user_backup");

            while(rs.next())
            {
                data1.add(new user_backup_details(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        username_backup.setCellValueFactory(new PropertyValueFactory<>("username_backup"));
        firstname_backup.setCellValueFactory(new PropertyValueFactory<>("firstname_backup"));
        lastname_backup.setCellValueFactory(new PropertyValueFactory<>("lastname_backup"));
        password_backup.setCellValueFactory(new PropertyValueFactory<>("password_backup"));
        phone_backup.setCellValueFactory(new PropertyValueFactory<>("phone_backup"));
        email_backup.setCellValueFactory(new PropertyValueFactory<>("email_backup"));
        color_backup.setCellValueFactory(new PropertyValueFactory<>("color_backup"));



        tablebackup.setItems(null);
        tablebackup.setItems(data1);

    }
    public void backgo (ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Scene scnSignin = new Scene(p1);

        stage.setTitle("Home Page");
        stage.setScene(scnSignin);
        stage.show();
    }
}
