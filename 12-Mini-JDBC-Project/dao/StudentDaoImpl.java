package dao; // Put the implementation inside the dao package.

import model.Student; // Import the Student model.
import util.DBConnection; // Import the utility that creates database connections.
import java.sql.Connection; // Import Connection to represent the database session.
import java.sql.PreparedStatement; // Import PreparedStatement for parameterized SQL.
import java.sql.ResultSet; // Import ResultSet to read SELECT results.
import java.sql.SQLException; // Import SQLException for JDBC errors.
import java.util.ArrayList; // Import ArrayList to store multiple students.
import java.util.List; // Import List as the return type.

public class StudentDaoImpl implements StudentDao { // Implement all database operations declared in StudentDao.

    @Override // Indicate that this method implements StudentDao.addStudent().
    public void addStudent(Student student) { // Insert one Student object into the database.
        String sql = "INSERT INTO students(name, email, course, age) VALUES (?, ?, ?, ?)"; // Define an SQL INSERT query with placeholders.

        try (Connection con = DBConnection.getConnection(); // Open a database connection and automatically close it later.
             PreparedStatement ps = con.prepareStatement(sql)) { // Create a PreparedStatement for the SQL query.

            ps.setString(1, student.getName()); // Put the student's name into the first ? placeholder.
            ps.setString(2, student.getEmail()); // Put the student's email into the second ? placeholder.
            ps.setString(3, student.getCourse()); // Put the student's course into the third ? placeholder.
            ps.setInt(4, student.getAge()); // Put the student's age into the fourth ? placeholder.

            int rows = ps.executeUpdate(); // Execute INSERT and receive the number of affected rows.
            System.out.println(rows + " student(s) added successfully."); // Tell the user whether the insert was successful.
        } catch (SQLException e) { // Catch database-related errors.
            System.out.println("Error while adding student: " + e.getMessage()); // Display a readable error message.
        } // End exception handling.
    } // End addStudent method.

    @Override // Indicate that this method implements StudentDao.getAllStudents().
    public List<Student> getAllStudents() { // Read every student from the database.
        List<Student> students = new ArrayList<>(); // Create an empty list to store database records.
        String sql = "SELECT id, name, email, course, age FROM students"; // Define the SELECT query.

        try (Connection con = DBConnection.getConnection(); // Open the database connection.
             PreparedStatement ps = con.prepareStatement(sql); // Prepare the SELECT query.
             ResultSet rs = ps.executeQuery()) { // Execute the query and store the returned rows in ResultSet.

            while (rs.next()) { // Move the ResultSet cursor to the next row until no rows remain.
                Student student = new Student( // Create a Student object from the current database row.
                    rs.getInt("id"), // Read the id column as an int.
                    rs.getString("name"), // Read the name column as a String.
                    rs.getString("email"), // Read the email column as a String.
                    rs.getString("course"), // Read the course column as a String.
                    rs.getInt("age") // Read the age column as an int.
                ); // Finish creating the Student object.
                students.add(student); // Add the object to the list.
            } // End ResultSet loop.
        } catch (SQLException e) { // Catch database-related errors.
            System.out.println("Error while fetching students: " + e.getMessage()); // Display the error.
        } // End exception handling.
        return students; // Return the complete student list to the caller.
    } // End getAllStudents method.

    @Override // Indicate that this method implements StudentDao.getStudentById().
    public Student getStudentById(int id) { // Find one student using the primary key ID.
        String sql = "SELECT id, name, email, course, age FROM students WHERE id = ?"; // Define a parameterized SELECT query.

        try (Connection con = DBConnection.getConnection(); // Open a database connection.
             PreparedStatement ps = con.prepareStatement(sql)) { // Create a PreparedStatement.

            ps.setInt(1, id); // Put the requested ID into the ? placeholder.

            try (ResultSet rs = ps.executeQuery()) { // Execute the SELECT query and obtain the result rows.
                if (rs.next()) { // Check whether a matching student exists.
                    return new Student( // Create and return a Student object from the matching row.
                        rs.getInt("id"), // Read the ID column.
                        rs.getString("name"), // Read the name column.
                        rs.getString("email"), // Read the email column.
                        rs.getString("course"), // Read the course column.
                        rs.getInt("age") // Read the age column.
                    ); // Finish creating the Student object.
                } // End matching-row check.
            } // ResultSet is automatically closed here.
        } catch (SQLException e) { // Catch database errors.
            System.out.println("Error while finding student: " + e.getMessage()); // Display the error.
        } // End exception handling.
        return null; // Return null when no student is found or an error occurs.
    } // End getStudentById method.

    @Override // Indicate that this method implements StudentDao.updateStudent().
    public void updateStudent(Student student) { // Update an existing student's details.
        String sql = "UPDATE students SET name = ?, email = ?, course = ?, age = ? WHERE id = ?"; // Define a parameterized UPDATE query.

        try (Connection con = DBConnection.getConnection(); // Open a database connection.
             PreparedStatement ps = con.prepareStatement(sql)) { // Create the PreparedStatement.

            ps.setString(1, student.getName()); // Set the new name.
            ps.setString(2, student.getEmail()); // Set the new email.
            ps.setString(3, student.getCourse()); // Set the new course.
            ps.setInt(4, student.getAge()); // Set the new age.
            ps.setInt(5, student.getId()); // Set the ID that identifies which row must be updated.

            int rows = ps.executeUpdate(); // Execute the UPDATE query.
            System.out.println(rows == 1 ? "Student updated successfully." : "Student not found."); // Print the result based on affected rows.
        } catch (SQLException e) { // Catch database errors.
            System.out.println("Error while updating student: " + e.getMessage()); // Display the error.
        } // End exception handling.
    } // End updateStudent method.

    @Override // Indicate that this method implements StudentDao.deleteStudent().
    public void deleteStudent(int id) { // Delete a student using the ID.
        String sql = "DELETE FROM students WHERE id = ?"; // Define a parameterized DELETE query.

        try (Connection con = DBConnection.getConnection(); // Open a database connection.
             PreparedStatement ps = con.prepareStatement(sql)) { // Prepare the DELETE query.

            ps.setInt(1, id); // Put the student ID into the ? placeholder.
            int rows = ps.executeUpdate(); // Execute DELETE and get the number of affected rows.
            System.out.println(rows == 1 ? "Student deleted successfully." : "Student not found."); // Tell the user the operation result.
        } catch (SQLException e) { // Catch database errors.
            System.out.println("Error while deleting student: " + e.getMessage()); // Display the error.
        } // End exception handling.
    } // End deleteStudent method.
} // End StudentDaoImpl class.
