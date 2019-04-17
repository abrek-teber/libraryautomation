package Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Controller {
    public TextField username;
    public TextField password;
    public Label isConnected;
    Stage stage= new Stage();

    public void GoUserLoginPage(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("User_Login.fxml"));
        Scene scnUserLogin = new Scene(p1);

        stage.setTitle("User Login");
        stage.setScene(scnUserLogin);
        stage.show();
    }
    public void GoAdminLoginPage(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("Admin_Login.fxml"));
        Scene scnAdminLogin = new Scene(p1);

        stage.setTitle("Admin Login");
        stage.setScene(scnAdminLogin);
        stage.show();
    }
    public void GoBack(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scnBack = new Scene(p1);

        stage.setTitle("Login");
        stage.setScene(scnBack);
        stage.show();
    }
    public void GoForgot(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("Forgot_Password.fxml"));
        Scene scnForgot = new Scene(p1);

        stage.setTitle("Password Recovery");
        stage.setScene(scnForgot);
        stage.show();
    }

    public void GoSignin(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("User_Signin.fxml"));
        Scene scnSignin = new Scene(p1);

        stage.setTitle("User Registration");
        stage.setScene(scnSignin);
        stage.show();
    }
    public void login(ActionEvent event){
        DBConnection connectionClass = new DBConnection();
        Connection connection=connectionClass.connect();
        try {
            Statement statement=connection.createStatement();
            String sql="SELECT * FROM users WHERE Username = '"+username.getText()+"' AND Password = '"+password.getText()+"'";
            ResultSet resultSet=statement.executeQuery(sql);

            if(resultSet.next()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("");
                alert.setHeaderText("You have successfully loged in!");
                alert.setContentText("You will be redirected to home page.");

                alert.showAndWait();



            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("");
                alert.setHeaderText("Your information is incorrect!");
                alert.setContentText("Please try again!");

                alert.showAndWait();

            }
            if(username.getText().isEmpty() || password.getText().isEmpty()  )
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("Error occurred!");
                alert.setContentText("Please fill all the fields!");

                alert.showAndWait();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }




}