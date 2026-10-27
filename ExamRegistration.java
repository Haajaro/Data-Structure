package company;

import java.util.Scanner;

public class ExamRegistration {

    // Custom Exception
    static class InvalidRegistrationException extends Exception {
        public InvalidRegistrationException(String message) {
            super(message);
        }
    }

    // Validate student information
    static void registerStudent(String studentID, String name,
                                int age, double mark, int subjects)
            throws InvalidRegistrationException {

        if (studentID.trim().isEmpty()) {
            throw new InvalidRegistrationException(
                    "Student ID cannot be empty.");
        }

        if (age < 18) {
            throw new InvalidRegistrationException(
                    "Student age must be at least 18.");
        }

        if (mark < 0 || mark > 100) {
            throw new InvalidRegistrationException(
                    "Exam mark must be between 0 and 100.");
        }

        if (subjects < 1 || subjects > 5) {
            throw new InvalidRegistrationException(
                    "Maximum allowed subjects is 5.");
        }

        System.out.println("\nRegistration Successful!");
        System.out.println("Student: " + name);
        System.out.println("Registered Subjects: " + subjects);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== EXAM REGISTRATION SYSTEM =====");

        try {
            // Collect student information
            System.out.print("Enter Student ID: ");
            String studentID = input.nextLine();

            System.out.print("Enter Student Name: ");
            String name = input.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(input.nextLine());

            System.out.print("Enter Exam Mark: ");
            double mark = Double.parseDouble(input.nextLine());

            System.out.print("Enter Number of Subjects: ");
            int subjects = Integer.parseInt(input.nextLine());

            // Register student
            registerStudent(studentID, name, age, mark, subjects);

        } catch (InvalidRegistrationException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: Please enter valid numbers.");

        } finally {
            System.out.println("\nRegistration attempt completed.");
         
        }
    }
}