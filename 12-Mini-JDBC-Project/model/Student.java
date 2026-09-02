package model; // Put this class inside the model package.

public class Student { // Define the Student model class.
    private int id; // Store the student's unique ID.
    private String name; // Store the student's name.
    private String email; // Store the student's email.
    private String course; // Store the student's course.
    private int age; // Store the student's age.

    public Student() { // Create an empty constructor for flexible object creation.
    } // End the empty constructor.

    public Student(String name, String email, String course, int age) { // Create a constructor for new students.
        this.name = name; // Copy the given name into the current object's name field.
        this.email = email; // Copy the given email into the current object's email field.
        this.course = course; // Copy the given course into the current object's course field.
        this.age = age; // Copy the given age into the current object's age field.
    } // End the constructor.

    public Student(int id, String name, String email, String course, int age) { // Create a constructor for database records that already have an ID.
        this.id = id; // Store the database ID in the object.
        this.name = name; // Store the student's name.
        this.email = email; // Store the student's email.
        this.course = course; // Store the student's course.
        this.age = age; // Store the student's age.
    } // End the constructor.

    public int getId() { return id; } // Return the student's ID.
    public String getName() { return name; } // Return the student's name.
    public String getEmail() { return email; } // Return the student's email.
    public String getCourse() { return course; } // Return the student's course.
    public int getAge() { return age; } // Return the student's age.

    public void setName(String name) { this.name = name; } // Update the student's name.
    public void setEmail(String email) { this.email = email; } // Update the student's email.
    public void setCourse(String course) { this.course = course; } // Update the student's course.
    public void setAge(int age) { this.age = age; } // Update the student's age.

    @Override // Tell Java that we are overriding Object's toString method.
    public String toString() { // Convert the Student object into readable text.
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', course='" + course + "', age=" + age + "}"; // Return student details as text.
    } // End toString method.
} // End Student class.
