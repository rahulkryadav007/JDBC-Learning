# 05 - Statement

`Statement` is used to execute a SQL string directly.

## Main methods
- `executeQuery(sql)` → generally for `SELECT`, returns `ResultSet`
- `executeUpdate(sql)` → generally for `INSERT`, `UPDATE`, `DELETE`, returns affected row count
- `execute(sql)` → can execute SQL when the result type may vary

## When to use?
Use `Statement` mainly for fixed SQL that has no user-supplied parameters. For dynamic/user input, prefer `PreparedStatement`.

## Example
See `StatementExample.java`.

### Practice
1. Write an `INSERT` using `executeUpdate()`.
2. Print the returned affected-row count.
3. Convert a user-input query to `PreparedStatement`.

### Interview
**Q: Why is Statement risky with user input?**  
A: Building SQL by concatenating untrusted input can allow SQL injection. Parameterized `PreparedStatement` is the safer approach.
