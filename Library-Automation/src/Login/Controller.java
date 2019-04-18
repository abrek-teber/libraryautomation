package Login;

import UserScreen.User_Screen_Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Controller  {
    @FXML
    public TextField username;
    public TextField password;
    public TextField favcolor;
    public Label lblPassword;
    @FXML
    public Button loginn;

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

    public void loginn(ActionEvent event) throws IOException
    {
        DBConnection connectionClass = new DBConnection();
        Connection connection=connectionClass.connect();






        try {
            Statement statement=connection.createStatement();
            String sql="SELECT * FROM users WHERE Username = '"+username.getText()+"' AND Password = '"+password.getText()+"'";
            ResultSet resultSet=statement.executeQuery(sql);


            if(resultSet.next()){
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("../UserScreen/UserMainScreen.fxml"));
                Parent root2 = loader.load();
                User_Screen_Controller thirdController = loader.getController();
                thirdController.gotousermainscreen(username.getText());

                stage.setTitle("User Screen");
                Scene scene2 = new Scene(root2);
                stage.setScene(scene2);
                stage.show();

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


    public void colorsubmit(ActionEvent event) throws IOException
    {
        DBConnection connectionClass = new DBConnection();
        Connection connection=connectionClass.connect();
        try {
            Statement statement=connection.createStatement();
            String sql="SELECT * FROM users WHERE Color = '"+favcolor.getText()+"'";
            ResultSet resultSet=statement.executeQuery(sql);
            if (resultSet.next()) {

                Statement statementPassword = connection.createStatement();
                String sqlPassword = "SELECT Password FROM users WHERE Color = '" + favcolor.getText() + "'";
                ResultSet resultSetPassword = statementPassword.executeQuery(sqlPassword);

                if (resultSetPassword.next()) {
                    String sqlPass = resultSetPassword.getString("Password");
                    lblPassword.setText(sqlPass);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setHeaderText("Recovery password is correct!");
                    alert.setContentText("Your password is:" + lblPassword.getText());

                    alert.showAndWait();

                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    Parent p1 = FXMLLoader.load(getClass().getResource("User_Login.fxml"));
                    Scene scnUserLogin = new Scene(p1);

                    stage.setTitle("User Login");
                    stage.setScene(scnUserLogin);
                    stage.show();
                }
            }
            else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("Error occurred!");
                alert.setContentText("E-Mail or Recovery Answer is not correct!");

                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    }








