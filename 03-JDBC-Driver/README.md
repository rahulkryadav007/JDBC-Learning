# 03 - JDBC Driver

## What is a JDBC Driver?

A JDBC driver is software that allows the JDBC API to communicate with a particular database.

For MySQL, we commonly use **MySQL Connector/J**.

## Maven

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.4.0</version>
</dependency>
```

The exact driver version should be chosen according to your project/JDK compatibility.

## Do we always need `Class.forName()`?

Older JDBC code often used:

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

Modern JDBC drivers support automatic driver loading through the Java Service Provider mechanism, so explicit `Class.forName()` is generally unnecessary when the driver is correctly on the classpath.

### Practice
- Add Connector/J using Maven.
- Remove the dependency and observe the connection failure.
- Explain the difference between JDBC API and JDBC driver.

### Interview
**Q: Is JDBC driver database-independent?**  
A: No. The JDBC API is standardized, while drivers implement communication for specific databases.
