# 02 - JDBC Architecture

## Big Picture

```text
Java Application
       ↓
   JDBC API
       ↓
DriverManager / DataSource
       ↓
 JDBC Driver
       ↓
 MySQL Database
```

### Easy real-life analogy
Think of a restaurant:
- Java application = customer
- JDBC API = common ordering language
- JDBC Driver = waiter who understands the kitchen
- Database = kitchen
- SQL = order

The Java program does not need to know MySQL's internal protocol. The MySQL JDBC driver handles database-specific communication.

## Main flow

1. Java code requests a connection.
2. JDBC identifies/uses the suitable driver.
3. A `Connection` is created.
4. Java sends SQL through a statement object.
5. Database executes SQL.
6. Results/status come back to Java.

## Key idea
JDBC separates your Java code from many database-specific communication details, while the driver provides the database-specific implementation.

### Practice
Draw the architecture from memory and explain each layer in your own words.
