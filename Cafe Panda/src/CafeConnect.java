
import java.sql.*;
import javax.swing.JOptionPane;

public class CafeConnect {

    Connection con;

    public static Connection ConnecrDb() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\shari\\OneDrive\\Desktop\\sd - Copy (2)\\sd - Copy (2)\\CafeManagmentSystem 40% - Copy\\Cafe Managment System.db");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}
