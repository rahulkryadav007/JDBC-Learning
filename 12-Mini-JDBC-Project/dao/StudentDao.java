package dao; // Put the DAO interface inside the dao package.

import model.Student; // Import Student because DAO methods work with Student objects.
import java.util.List; // Import List to return multiple students.

public interface StudentDao { // Define the contract for all student database operations.
    void addStudent(Student student); // Define a method for inserting a student into the database.
    List<Student> getAllStudents(); // Define a method for reading all students from the database.
    Student getStudentById(int id); // Define a method for finding one student by ID.
    void updateStudent(Student student); // Define a method for updating an existing student.
    void deleteStudent(int id); // Define a method for deleting a student by ID.
} // End StudentDao interface.
