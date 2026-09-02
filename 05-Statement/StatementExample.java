import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_learning";
        String user = "root";
        String password = "your_password";

        String sql = "SELECT id, name, email, age FROM students";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // ResultSet mein database se aayi rows hoti hain.
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getInt("age")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// IMPORTANT: User input ko string concatenation se SQL mein mat jodo.
// Example: "SELECT ... WHERE name = '" + userInput + "'"
// Isse SQL injection ka risk hota hai. User input ke liye PreparedStatement use karo.
