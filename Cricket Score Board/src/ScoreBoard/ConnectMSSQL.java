
package ScoreBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectMSSQL {
    
    
     public static Connection connectDB(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=SCOREBOARD;selectMethod=cursor", "sa", "6287");
            System.out.println("DATABASE NAME IS:"+ connection.getMetaData().getDatabaseProductName());
            return connection;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
}
