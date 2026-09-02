CREATE DATABASE IF NOT EXISTS jdbc_learning; -- Create the database if it does not already exist.

USE jdbc_learning; -- Select the database so the next commands run inside it.

CREATE TABLE IF NOT EXISTS students ( -- Create the students table if it does not exist.
    id INT PRIMARY KEY AUTO_INCREMENT, -- Store a unique student ID and generate it automatically.
    name VARCHAR(100) NOT NULL, -- Store the student's name; NULL is not allowed.
    email VARCHAR(150) NOT NULL UNIQUE, -- Store a unique email address for each student.
    course VARCHAR(100) NOT NULL, -- Store the course name.
    age INT NOT NULL -- Store the student's age.
); -- Finish the table definition.

INSERT INTO students (name, email, course, age) VALUES ('Rahul', 'rahul@example.com', 'Java', 24); -- Insert one sample student for testing.
