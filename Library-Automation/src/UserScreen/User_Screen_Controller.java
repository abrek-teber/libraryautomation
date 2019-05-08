package UserScreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class User_Screen_Controller   {

    Stage stage = new Stage();

    @FXML
    public Label lblusername;

    public void mypro (ActionEvent event) throws IOException
    {
         ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader2=new FXMLLoader(getClass().getResource("Myprofile.fxml"));
            Parent root2 = loader2.load();
            myprofile_controller thirdController = loader2.getController();
            thirdController.gotousermainscreen1(lblusername.getText());

            stage.setTitle("User Screen");
            Scene scene2 = new Scene(root2);
            stage.setScene(scene2);
            stage.show();

    }
    public void gotousermainscreen(String text){

        lblusername.setText(text);
    }
    public void logoutt(ActionEvent event) throws IOException
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent p1 = FXMLLoader.load(getClass().getResource("../Login/User_Login.fxml"));
        Scene scnSignin = new Scene(p1);

        stage.setTitle("User Login");
        stage.setScene(scnSignin);
        stage.show();
    }
    public void books (ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("Allbooks.fxml"));
        Parent root2 = loader2.load();
        allbooks_controller thirdController = loader2.getController();
        thirdController.gotousermainscreen6(lblusername.getText());

        stage.setTitle("User Screen");
        Scene scene2 = new Scene(root2);
        stage.setScene(scene2);
        stage.show();

    }




}
