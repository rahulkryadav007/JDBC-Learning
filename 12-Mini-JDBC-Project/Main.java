import dao.StudentDao; // Import the DAO interface for student database operations.
import dao.StudentDaoImpl; // Import the implementation that actually talks to MySQL.
import model.Student; // Import the Student model used to carry student data.
import java.util.List; // Import List to hold multiple students.
import java.util.Scanner; // Import Scanner to read input from the keyboard.

public class Main { // Define the main application class.
    public static void main(String[] args) { // Program execution starts from this method.
        Scanner scanner = new Scanner(System.in); // Create Scanner to read keyboard input.
        StudentDao studentDao = new StudentDaoImpl(); // Create DAO object so Main can perform database operations.
        boolean running = true; // Keep the menu running until the user chooses Exit.

        while (running) { // Repeat the menu while running is true.
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM ====="); // Print the application heading.
            System.out.println("1. Add Student"); // Show the Add option.
            System.out.println("2. View All Students"); // Show the View option.
            System.out.println("3. Find Student By ID"); // Show the Find option.
            System.out.println("4. Update Student"); // Show the Update option.
            System.out.println("5. Delete Student"); // Show the Delete option.
            System.out.println("6. Exit"); // Show the Exit option.
            System.out.print("Enter your choice: "); // Ask the user to choose an operation.

            int choice = readInt(scanner); // Read the menu choice safely as an integer.

            switch (choice) { // Select an operation based on the user's choice.
                case 1 -> addStudent(scanner, studentDao); // Call the method that adds a student.
                case 2 -> viewStudents(studentDao); // Call the method that displays all students.
                case 3 -> findStudent(scanner, studentDao); // Call the method that finds a student by ID.
                case 4 -> updateStudent(scanner, studentDao); // Call the method that updates a student.
                case 5 -> deleteStudent(scanner, studentDao); // Call the method that deletes a student.
                case 6 -> { // Start the Exit operation.
                    running = false; // Change running to false so the loop stops.
                    System.out.println("Thank you for using the system!"); // Display the exit message.
                } // End Exit operation.
                default -> System.out.println("Invalid choice. Please try again."); // Handle an invalid menu number.
            } // End switch statement.
        } // End menu loop.

        scanner.close(); // Close Scanner and release its input resource.
    } // End main method.

    private static void addStudent(Scanner scanner, StudentDao dao) { // Define the Add Student operation.
        System.out.print("Enter name: "); // Ask for the student's name.
        String name = scanner.nextLine(); // Read the student's name.
        System.out.print("Enter email: "); // Ask for the student's email.
        String email = scanner.nextLine(); // Read the student's email.
        System.out.print("Enter course: "); // Ask for the student's course.
        String course = scanner.nextLine(); // Read the student's course.
        System.out.print("Enter age: "); // Ask for the student's age.
        int age = readInt(scanner); // Read the student's age.

        Student student = new Student(name, email, course, age); // Create a Student object from the input values.
        dao.addStudent(student); // Send the Student object to DAO for database insertion.
    } // End addStudent method.

    private static void viewStudents(StudentDao dao) { // Define the View All Students operation.
        List<Student> students = dao.getAllStudents(); // Ask DAO to fetch all students from MySQL.
        if (students.isEmpty()) { // Check whether the database returned no students.
            System.out.println("No students found."); // Tell the user that there are no records.
            return; // Stop this method because there is nothing to display.
        } // End empty-list check.
        for (Student student : students) { // Loop through every Student object.
            System.out.println(student); // Print each student's details using toString().
        } // End student loop.
    } // End viewStudents method.

    private static void findStudent(Scanner scanner, StudentDao dao) { // Define the Find Student operation.
        System.out.print("Enter student ID: "); // Ask for the ID to search.
        int id = readInt(scanner); // Read the ID as an integer.
        Student student = dao.getStudentById(id); // Ask DAO to find the student in the database.
        if (student == null) { // Check whether DAO found no matching student.
            System.out.println("Student not found."); // Tell the user that the record does not exist.
        } else { // Execute this block when a student is found.
            System.out.println(student); // Display the found student's details.
        } // End if-else.
    } // End findStudent method.

    private static void updateStudent(Scanner scanner, StudentDao dao) { // Define the Update Student operation.
        System.out.print("Enter student ID to update: "); // Ask which student should be updated.
        int id = readInt(scanner); // Read the student's ID.
        Student existing = dao.getStudentById(id); // First check whether the student exists.
        if (existing == null) { // Check the search result.
            System.out.println("Student not found."); // Tell the user that no matching record exists.
            return; // Stop the update operation.
        } // End existence check.

        System.out.print("Enter new name: "); // Ask for the updated name.
        String name = scanner.nextLine(); // Read the new name.
        System.out.print("Enter new email: "); // Ask for the updated email.
        String email = scanner.nextLine(); // Read the new email.
        System.out.print("Enter new course: "); // Ask for the updated course.
        String course = scanner.nextLine(); // Read the new course.
        System.out.print("Enter new age: "); // Ask for the updated age.
        int age = readInt(scanner); // Read the new age.

        Student student = new Student(id, name, email, course, age); // Create a Student object containing the ID and new values.
        dao.updateStudent(student); // Send the updated object to DAO for database update.
    } // End updateStudent method.

    private static void deleteStudent(Scanner scanner, StudentDao dao) { // Define the Delete Student operation.
        System.out.print("Enter student ID to delete: "); // Ask for the ID to delete.
        int id = readInt(scanner); // Read the ID.
        dao.deleteStudent(id); // Ask DAO to delete the matching database record.
    } // End deleteStudent method.

    private static int readInt(Scanner scanner) { // Define a helper method for reading integers.
        while (true) { // Keep asking until valid integer input is provided.
            try { // Start exception handling for invalid numeric input.
                return Integer.parseInt(scanner.nextLine().trim()); // Convert the entered text into an integer and return it.
            } catch (NumberFormatException e) { // Catch the error when the input is not a valid integer.
                System.out.print("Please enter a valid number: "); // Ask the user to enter a correct number.
            } // End exception handling.
        } // End validation loop.
    } // End readInt method.
} // End Main class.
