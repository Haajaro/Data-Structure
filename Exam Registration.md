# University Exam Registration System



### Description
The University Exam Registration System is a simple Java application that allows students to register for examinations. It validates student information and handles invalid inputs using exception handling.

### Features
- Collects Student ID and Student Name.
- Validates student age (minimum 18 years).
- Validates examination marks (0–100).
- Allows registration for 1–5 subjects.
- Prevents empty Student IDs.
- Handles invalid inputs using `try` and `catch`.
- Uses a custom exception called `InvalidRegistrationException`.
- Demonstrates `throw` and `throws`.
- Uses `finally` to complete the registration attempt.



#

### Sample Output

```text
===== EXAM REGISTRATION SYSTEM =====

Enter Student ID: JU001
Enter Student Name: Haajaro
Enter Age: 18
Enter Exam Mark: 75
Enter Number of Subjects: 4

Registration Successful!
Student: Haajaro
Registered Subjects: 4

Registration attempt completed.
```

### Exception Handling Concepts
- **try:** Contains code that may cause an exception.
- **catch:** Handles exceptions and displays error messages.
- **finally:** Executes after the try and catch blocks.
- **throw:** Throws a custom exception when validation fails.
- **throws:** Declares an exception that a method may throw.
- **Custom Exception:** Provides meaningful registration error messages.


