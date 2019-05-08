package UserScreen;

import Login.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class Update_Profile_Controller {
    public void gotousermainscreen2(String text){

        lbluserupdate.setText(text);
    }
    private DBConnection dc;
    Stage stage = new Stage();
    public Label lbluserupdate;

    Connection conn = dc.connect();

    public TextField text1;
    public TextField text2;
    public TextField text3;
    public TextField text4;
    PreparedStatement pst=null;
    ResultSet rs=null;
    public void goobackk (ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("Myprofile.fxml"));
        Parent root2 = loader2.load();
        myprofile_controller thirdController = loader2.getController();
        thirdController.gotousermainscreen1(lbluserupdate.getText());

        stage.setTitle("User Screen");
        Scene scene2 = new Scene(root2);
        stage.setScene(scene2);
        stage.show();
    }
    public void showmyinfo (ActionEvent event) {
        try {
            String sql = "SELECT Username,Password,Phone,Email FROM users WHERE Username ='"+lbluserupdate.getText()+"'";
            pst=conn.prepareStatement(sql);

            rs = pst.executeQuery();
            if(rs.next()) {
                String Username = rs.getString("Username");
                text1.setText(Username);

                String Password = rs.getString("Password");
                text2.setText(Password);

                String Phone = rs.getString("Phone");
                text3.setText(Phone);

                String Email = rs.getString("Email");
                text4.setText(Email);


            }
        } catch (SQLException e ) {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    public void updatemyinfo(ActionEvent event)throws SQLException
    {


        if(text1.getText().isEmpty() || text2.getText().isEmpty() || text3.getText().isEmpty() )
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText("Error occurred!");
            alert.setContentText("Please enter all necessary information!");

            alert.showAndWait();
        }
        else
        {


            Statement statement = conn.createStatement();
            String sql = "UPDATE users SET Username='"+text1.getText()+"', Password='"+text2.getText()+"', Phone='"+text3.getText()+"', Email='"+text4.getText()+"' WHERE Username='"+lbluserupdate.getText()+"'";
            statement.executeUpdate(sql);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Your information has been updated!");
            alert.showAndWait();

        }


    }






}
