package UserScreen;

import Login.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class myprofile_controller  {
    @FXML
    private TableView<UserScreen.User_Details> tableUser;
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
    public Label lblusername1;


    public void load(ActionEvent event) {
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


        tableUser.setItems(null);
        tableUser.setItems(data);

    }
    public void gotousermainscreen1(String text){

        lblusername1.setText(text);
    }





}
