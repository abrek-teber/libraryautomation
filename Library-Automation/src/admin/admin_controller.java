package admin;

import Login.DBConnection;
import UserScreen.User_Screen_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class admin_controller {
    @FXML
    public TextField adminusername;
    @FXML
    public TextField adminpassword;
    Stage stage = new Stage();


    public void adminlogin(ActionEvent event) throws IOException
    {
        DBConnection connectionClass = new DBConnection();
        Connection connection=connectionClass.connect();

        try {
            Statement statement=connection.createStatement();
            String sql="SELECT * FROM admin WHERE name = '"+adminusername.getText()+"' AND password = '"+adminpassword.getText()+"'";
            ResultSet resultSet=statement.executeQuery(sql);


            if(resultSet.next()){
                ((Node)(event.getSource())).getScene().getWindow().hide();
                Parent p1 = FXMLLoader.load(getClass().getResource("admin.fxml"));
                Scene scnSignin = new Scene(p1);

                stage.setTitle("Admin");
                stage.setScene(scnSignin);
                stage.show();

            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("");
                alert.setHeaderText("Your information is incorrect!");
                alert.setContentText("Please try again!");

                alert.showAndWait();

            }
            if(adminusername.getText().isEmpty() || adminpassword.getText().isEmpty()  )
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

    public void GoBack(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("../Login/Login.fxml"));
        Scene scnBack = new Scene(p1);

        stage.setTitle("Login");
        stage.setScene(scnBack);
        stage.show();
    }
    public void userdetailsgo(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("user_details.fxml"));
        Scene scnBack = new Scene(p1);

        stage.setTitle("User Details");
        stage.setScene(scnBack);
        stage.show();
    }
    public void bookdetailsgo(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("book_details.fxml"));
        Scene scnBack = new Scene(p1);

        stage.setTitle("Book Details");
        stage.setScene(scnBack);
        stage.show();
    }
    public void gohome(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("Admin_Login.fxml"));
        Scene scnBack = new Scene(p1);

        stage.setTitle("Home Page");
        stage.setScene(scnBack);
        stage.show();
    }


}
