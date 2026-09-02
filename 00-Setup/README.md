# 00 - Setup: Java + MySQL + JDBC Driver

## 1. What you need
- JDK 8+ (JDK 17/21 is a good learning choice)
- MySQL Server
- MySQL Workbench (optional)
- IntelliJ IDEA / Eclipse / VS Code
- MySQL Connector/J JDBC driver

## 2. Create a database

```sql
CREATE DATABASE jdbc_learning;
USE jdbc_learning;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE,
    age INT
);
```

## 3. Maven dependency

For Maven projects, add MySQL Connector/J in `pom.xml`:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.4.0</version>
</dependency>
```

> Version can change. In a real project, use a currently supported Connector/J version compatible with your JDK/MySQL setup.

## 4. JDBC URL

```text
jdbc:mysql://localhost:3306/jdbc_learning
```

- `jdbc:mysql://` → JDBC + MySQL
- `localhost` → database is running on your computer
- `3306` → default MySQL port
- `jdbc_learning` → database name

## 5. First connection

See `01-JDBC-Introduction/FirstConnection.java`.

### Common mistakes
- MySQL server is not running
- Wrong username/password
- Wrong database name
- JDBC driver missing
- Wrong port
