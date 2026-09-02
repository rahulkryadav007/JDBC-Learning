import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_learning";
        String user = "root";
        String password = "your_password";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Connection object database ke saath active session ko represent karta hai.
            System.out.println("Connected: " + !con.isClosed());
        } catch (SQLException e) {
            // SQLException database/JDBC related error ko represent karta hai.
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
