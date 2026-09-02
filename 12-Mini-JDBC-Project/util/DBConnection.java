package util; // Put this class inside the utility package.

import java.sql.Connection; // Import Connection to represent the Java-to-database connection.
import java.sql.DriverManager; // Import DriverManager to obtain a JDBC database connection.
import java.sql.SQLException; // Import SQLException because database operations can fail.

public class DBConnection { // Create a utility class responsible for database connections.
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_learning"; // Store the JDBC URL containing driver type, host, port and database name.
    private static final String USER = "root"; // Store the MySQL username.
    private static final String PASSWORD = "your_password"; // Store your local MySQL password; change this value locally.

    public static Connection getConnection() throws SQLException { // Define a method that returns a Connection object to the caller.
        return DriverManager.getConnection(URL, USER, PASSWORD); // Ask DriverManager to establish the database connection and return it.
    } // End getConnection method.
} // End DBConnection class.
