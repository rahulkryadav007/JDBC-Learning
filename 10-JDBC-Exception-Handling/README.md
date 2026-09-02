# 10 - JDBC Exception Handling

Most JDBC operations can throw `SQLException`.

## Basic pattern

```java
try {
    // JDBC code
} catch (SQLException e) {
    System.out.println("Database error: " + e.getMessage());
}
```

## Useful information

```java
catch (SQLException e) {
    System.out.println(e.getMessage());
    System.out.println(e.getSQLState());
    System.out.println(e.getErrorCode());
}
```

- `getMessage()` → human-readable error message
- `getSQLState()` → standardized SQL state information
- `getErrorCode()` → vendor/database-specific error code

## Best practices
- Catch `SQLException` around database operations.
- Do not expose raw database details to end users in production.
- Log enough information for debugging without logging passwords/secrets.
- Use try-with-resources so JDBC resources close automatically.
- Use transactions and rollback when multiple writes must succeed together.

### Practice
Cause a wrong-table error and inspect the exception details.
