package sample;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/projedenemesi";
            String user = "root";
            String password = "12345678";


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null, ex);
        }

        return null;
    }
}
