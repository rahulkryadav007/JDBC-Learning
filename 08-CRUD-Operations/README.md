# 08 - CRUD Operations

CRUD = **Create, Read, Update, Delete**.

| Operation | SQL | JDBC method |
|---|---|---|
| Create | `INSERT` | `executeUpdate()` |
| Read | `SELECT` | `executeQuery()` |
| Update | `UPDATE` | `executeUpdate()` |
| Delete | `DELETE` | `executeUpdate()` |

See `StudentCrud.java` for a complete example using `PreparedStatement`.

## Database table

```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE,
    age INT
);
```

### Practice
Build methods for:
- `findStudentById(int id)`
- `findStudentByEmail(String email)`
- `updateStudentName(int id, String name)`
- `deleteStudentByEmail(String email)`
