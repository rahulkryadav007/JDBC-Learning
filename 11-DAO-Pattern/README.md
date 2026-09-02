# 11 - DAO Pattern

**DAO = Data Access Object**.

The DAO pattern keeps database access code separate from business/application code.

## Simple structure

```text
model/
  Student.java

dao/
  StudentDao.java
  StudentDaoImpl.java

service/
  StudentService.java

Main.java
```

### Why?
If SQL is mixed everywhere in the application, maintenance becomes difficult. DAO gives database operations a clear home.

## Example interface

```java
public interface StudentDao {
    void save(Student student);
    Student findById(int id);
    void update(Student student);
    void delete(int id);
}
```

Implementation contains JDBC code.

### Practice
Create `Student`, `StudentDao`, and `StudentDaoImpl`. Implement CRUD using `PreparedStatement`.

### Interview
**Q: Why use DAO?**  
A: It separates data-access logic from the rest of the application, improving organization, maintainability, and testability.
