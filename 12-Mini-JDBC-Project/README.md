# 12 - Mini JDBC Project: Student Management System

A beginner-friendly console project using Core Java + JDBC + MySQL.

## Features

- Add Student
- View All Students
- Find Student By ID
- Update Student
- Delete Student
- Menu-driven application

## JDBC Flow

```text
User -> Main.java -> StudentDao -> StudentDaoImpl -> DBConnection -> MySQL
```

## Important JDBC Line

```java
Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
```

- `Connection` is a `java.sql` interface. It represents the connection/session between Java and the database.
- `con` is the variable that stores that Connection object.
- `DriverManager` manages JDBC drivers.
- `getConnection()` asks the JDBC driver to establish a database connection using URL, username and password.

**English:** Create a database connection and store it in `con`.

**Hinglish:** Database se connection banao aur jo connection object mile, usko `con` variable mein store karo.

### Why inside try-with-resources?

```java
try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
    // JDBC work
}
```

`Connection`, `PreparedStatement` and `ResultSet` are resources. Try-with-resources automatically closes them after the block finishes, even when an exception occurs.

**English:** Create the resource, use it, and close it automatically.

**Hinglish:** Resource banao, use karo, aur kaam complete hone par automatically close kar do.

## Project Structure

```text
12-Mini-JDBC-Project/
├── database.sql
├── model/Student.java
├── dao/StudentDao.java
├── dao/StudentDaoImpl.java
├── util/DBConnection.java
└── Main.java
```

## Run

1. Run `database.sql` in MySQL.
2. Add MySQL Connector/J to your Java project.
3. Set your database username/password in `DBConnection.java`.
4. Run `Main.java`.
5. Test all CRUD operations.

> Never commit your real database password to GitHub. Use an environment variable or local configuration for real projects.
