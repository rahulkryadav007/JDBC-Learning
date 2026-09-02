# 07 - ResultSet

`ResultSet` represents tabular data returned by a query such as `SELECT`.

## Cursor concept

Initially, the cursor is **before the first row**.

```java
while (rs.next()) {
    int id = rs.getInt("id");
    String name = rs.getString("name");
    System.out.println(id + " - " + name);
}
```

`next()` moves the cursor to the next row and returns `false` when there is no next row.

## Common getters
- `getInt("id")`
- `getString("name")`
- `getDouble("salary")`
- `getBoolean("active")`

### Practice
1. Print every column from `students`.
2. Search for one student and print a message if no row exists.
3. Explain why `rs.next()` is required before reading a row.
