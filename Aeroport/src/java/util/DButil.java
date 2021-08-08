package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                
            	//String user = "postgres";// Postgres
            	String user = "root"; // MySql
                //String password = "36254458";// Postgres
                String password = ""; // MySql
                Class.forName("com.mysql.jdbc.Driver"); // MySql
                //Class.forName("org.postgresql.Driver");// Postgres
               connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sisaeroporto", user, password);// MySql
                //connection = DriverManager.getConnection("jdbc:postgresql://localhost:3625/SistAeroporto",user, password);// Postgres
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}
