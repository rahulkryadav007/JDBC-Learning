# 13 - JDBC → Spring JdbcTemplate → JPA/Hibernate

This final module connects what you learned in JDBC to modern Java backend development.

## 1. Plain JDBC

You manually manage:
- `Connection`
- `PreparedStatement`
- `ResultSet`
- SQL
- exception/resource handling

Example idea:

```java
PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE id = ?");
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
```

## 2. Spring JdbcTemplate

Spring's `JdbcTemplate` reduces repetitive JDBC boilerplate while still allowing you to write SQL.

Conceptually:

```java
String sql = "SELECT name FROM students WHERE id = ?";
String name = jdbcTemplate.queryForObject(
    sql,
    String.class,
    id
);
```

You still think in SQL, but connection/resource/error-handling boilerplate is largely handled by Spring.

## 3. JPA/Hibernate

JPA is a Java persistence specification. Hibernate is a popular JPA implementation.

Instead of writing SQL for every basic CRUD operation, you work mainly with Java entities and repository/persistence abstractions.

Conceptually:

```java
Student student = studentRepository.findById(id).orElse(null);
```

## What should a fresher learn?

Do **not** think: "JDBC is useless because Spring Boot exists."

Think:

```text
JDBC fundamentals
      ↓
Understand SQL + connections + transactions
      ↓
Spring JdbcTemplate
      ↓
JPA/Hibernate
      ↓
Spring Data JPA
```

Knowing JDBC helps you understand what higher-level database abstractions are doing underneath.

### Interview questions
1. JDBC vs JdbcTemplate?
2. JdbcTemplate vs JPA/Hibernate?
3. What problem does an ORM solve?
4. Why are transactions important even when using Spring?
5. When might writing SQL explicitly be useful?
