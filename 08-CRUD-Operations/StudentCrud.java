import java.sql.*;

public class StudentCrud {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_learning";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        // Learning purpose: saare CRUD methods ko ek jagah practice kar rahe hain.
        insertStudent("Aman", "aman@example.com", 20);
        readStudents();
        updateStudentAge(1, 21);
        deleteStudent(1);
    }

    static void insertStudent(String name, String email, int age) {
        String sql = "INSERT INTO students(name, email, age) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, age);
            System.out.println("Inserted rows: " + ps.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void readStudents() {
        String sql = "SELECT id, name, email, age FROM students";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %d%n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void updateStudentAge(int id, int newAge) {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, newAge);
            ps.setInt(2, id);
            System.out.println("Updated rows: " + ps.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            System.out.println("Deleted rows: " + ps.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
