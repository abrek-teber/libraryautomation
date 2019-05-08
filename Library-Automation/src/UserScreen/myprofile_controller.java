package UserScreen;

import Login.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
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

    Stage stage = new Stage();
    Stage stage2 = new Stage();
    Stage stage3 = new Stage();


    public void gotomyprofilecontroller(String text){

        lblusername1.setText(text);
    }
    public void load(ActionEvent event)  {
        Login.DBConnection connectionClass = new Login.DBConnection();
        Connection connection = connectionClass.connect();

        try {

            data = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery("select * from users where Username='"+lblusername1.getText()+"'");

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
    public void goback(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("UserMainScreen.fxml"));
        Parent root2 = loader2.load();
        User_Screen_Controller thirdController = loader2.getController();
        thirdController.gotousermainscreen(lblusername1.getText());

        stage.setTitle("User Screen");
        Scene scene2 = new Scene(root2);
        stage.setScene(scene2);
        stage.show();
    }
    public void logoutum1(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("../Login/User_Login.fxml"));
        Scene scnSignin = new Scene(p1);

        stage.setTitle("Home Page");
        stage.setScene(scnSignin);
        stage.show();
    }
    public void update (ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("UpdateProfile.fxml"));
        Parent root3 = loader2.load();
        Update_Profile_Controller fourthController = loader2.getController();
        fourthController.gotousermainscreen2(lblusername1.getText());

        stage2.setTitle("User Screen");
        Scene scene2 = new Scene(root3);
        stage2.setScene(scene2);
        stage2.show();
    }


    public void gotomybooks (ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("../UserScreen/Mybooks.fxml"));
        Parent root4 = loader2.load();
        Mybooks_controller fourthController = loader2.getController();
        fourthController.gotousermainscreen4(lblusername1.getText());

        stage3.setTitle("User Screen");
        Scene scene2 = new Scene(root4);
        stage3.setScene(scene2);
        stage3.show();
    }


}
