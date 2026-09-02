# 06 - PreparedStatement ⭐

`PreparedStatement` is one of the most important JDBC topics.

## Why use it?
1. Accepts parameters using `?` placeholders.
2. Helps prevent SQL injection when used correctly.
3. Makes repeated parameterized SQL convenient.
4. Improves readability compared with manual string concatenation.

## Example

```java
String sql = "INSERT INTO students(name, email, age) VALUES (?, ?, ?)";
PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1, "Rahul");
ps.setString(2, "rahul@example.com");
ps.setInt(3, 22);

int rows = ps.executeUpdate();
```

### `?` ka logic
`?` ka matlab: **value yahan baad mein provide karenge**.

`setString(1, ...)` → first `?`  
`setString(2, ...)` → second `?`  
`setInt(3, ...)` → third `?`

## Practice
- Insert a student.
- Search by email.
- Update age by id.
- Delete by id.

## Interview
**Statement vs PreparedStatement?**  
`Statement` executes a SQL string directly. `PreparedStatement` represents parameterized SQL and is preferred for queries involving values from users or variables.
