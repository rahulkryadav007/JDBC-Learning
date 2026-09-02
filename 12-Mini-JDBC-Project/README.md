# 12 - Mini JDBC Project: Student Management System

Build a console-based **Student Management System** using Core Java + JDBC + MySQL.

## Features
1. Add student
2. View all students
3. Find student by ID
4. Update student
5. Delete student
6. Exit

## Suggested structure

```text
12-Mini-JDBC-Project/
├── model/Student.java
├── dao/StudentDao.java
├── dao/StudentDaoImpl.java
├── util/DBConnection.java
└── Main.java
```

## Requirements
- Use `PreparedStatement` for all user-input SQL.
- Use try-with-resources.
- Keep connection code in one utility/class.
- Return meaningful messages when a record is not found.
- Validate basic input in Java.

## Bonus
- Add search by email.
- Add pagination.
- Add a transaction for a multi-step operation.
- Add a menu loop with `Scanner`.

### Expected learning
After this project, you should be able to build a small database-backed Java console application without copying a framework.
