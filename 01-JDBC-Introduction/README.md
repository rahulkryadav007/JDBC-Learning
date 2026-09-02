# 01 - JDBC Introduction

## What is JDBC?

**JDBC (Java Database Connectivity)** is a Java API used to communicate with relational databases.

Simple idea:

`Java Program → JDBC → Database`

Example: A student registration program needs to save a student's name and email in MySQL. JDBC provides the Java-side tools to send SQL to MySQL and read the result.

## Why JDBC?

Without a database API, Java code would need database-specific communication details. JDBC gives Java a common API such as `Connection`, `Statement`, `PreparedStatement`, and `ResultSet`.

## Important JDBC interfaces/classes

| API | Job |
|---|---|
| `DriverManager` | Helps obtain a database connection |
| `Connection` | Represents the connection/session with DB |
| `Statement` | Executes SQL strings |
| `PreparedStatement` | Executes parameterized SQL safely |
| `ResultSet` | Holds rows returned by a query |

## FirstConnection.java

```java
import java.sql.Connection;
import java.sql.DriverManager;

public class FirstConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_learning";
        String username = "root";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Agar yahan tak aa gaye, database connection successful hai.
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            // Learning ke liye error print kar rahe hain.
            e.printStackTrace();
        }
    }
}
```

## Remember

JDBC is an **API**, not a database. MySQL/PostgreSQL are databases. A JDBC driver connects the Java JDBC API to a specific database.

### Practice
1. Change the database name and observe the error.
2. Stop MySQL and run the program.
3. Explain what `Connection` represents.

### Interview
**Q: What is JDBC?**  
A: JDBC is a standard Java API for connecting to relational databases and executing SQL operations from Java applications.
