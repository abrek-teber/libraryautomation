package Login;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class RegisterController {

    @FXML
    private DBConnection dc;
    @FXML
    private Stage stage = new Stage();
    @FXML
    public TextField First_Name;
    @FXML
    public TextField User_Name;
    @FXML
    public TextField Last_Name;
    @FXML
    public TextField Password;
    @FXML
    public TextField Phone;
   /* @FXML
    public Label Sex;
    @FXML
    public Label Password;
    @FXML
    public Label Phone;
    @FXML
    public Label Email;
    @FXML
    public Label Recovery;
    @FXML
    public Label Color; */
    @FXML
    public RadioButton Male;
    @FXML
    public RadioButton Female;
    @FXML
    public TextField E_Mail;
    @FXML
    public TextField Color_Question;



    public void GoBack(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scnLogin = new Scene(p1);

        stage.setTitle("Library Automation");
        stage.setScene(scnLogin);
        stage.show();
    }

    public void submit(ActionEvent event) throws SQLException,IOException {

        DBConnection connclass = new DBConnection();
        Connection conn = DBConnection.connect();
        Random rand = new Random();

        int id = rand.nextInt(10000);
        if(User_Name.getText().isEmpty() ||First_Name.getText().isEmpty() || Last_Name.getText().isEmpty() || Password.getText().isEmpty() )
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Error occurred!");
            alert.setContentText("Please enter all necessary information!");

            alert.showAndWait();
        }
        if(Male.isSelected() == true)
        {
            String sql = "INSERT INTO users VALUES('"+id+"','"+User_Name.getText()+"','"+First_Name.getText()+"','"+Last_Name.getText()+"'," +
                    "'"+Male.getText()+"','"+Password.getText()+"','"+Phone.getText()+"','"+E_Mail.getText()+"',"+
                    "'"+Color_Question.getText()+"')";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("You have successfully signed in!");
            alert.setContentText("You will be redirected to Login screen.");

            alert.showAndWait();


            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent p1 = FXMLLoader.load(getClass().getResource("User_Login.fxml"));
            Scene scnLogin = new Scene(p1);

            stage.setTitle("Library Automation");
            stage.setScene(scnLogin);
            stage.show();

        }
        else if(Female.isSelected() == true)
        {
            String sql = "INSERT INTO users VALUES('"+id+"','"+User_Name.getText()+"','"+First_Name.getText()+"','"+Last_Name.getText()+"'," +
                    "'"+Female.getText()+"','"+Password.getText()+"','"+Phone.getText()+"','"+E_Mail.getText()+"',"+
                    "'"+Color_Question.getText()+"')";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("You have successfully signed in!");
            alert.setContentText("You will be redirected to Login screen.");

            alert.showAndWait();


            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent p1 = FXMLLoader.load(getClass().getResource("User_Login.fxml"));
            Scene scnLogin = new Scene(p1);

            stage.setTitle("Library Automation");
            stage.setScene(scnLogin);
            stage.show();
        }

    }
}

