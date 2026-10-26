
package company;

public class EmployeeSalaryManagementSystem {

    // Parent class that stores common employee information
    static class Employee {
        protected String id;
        protected String name;
        protected String department;
        protected double basicSalary;

        // Constructor to initialize employee details
        Employee(String id, String name, String department,
                 double basicSalary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.basicSalary = basicSalary;
        }

        // Calculates the basic salary
        double calculateSalary() {
            return basicSalary;
        }

        // Displays employee information
        void displayInfo() {
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Monthly Salary: $" +
                    String.format("%.2f", calculateSalary()));
        }
    }

    // Subclass for full-time employees
    static class FullTimeEmployee extends Employee {
        double allowance;

        // Calls the parent constructor using super()
        FullTimeEmployee(String id, String name, String department,
                         double basicSalary, double allowance) {
            super(id, name, department, basicSalary);
            this.allowance = allowance;
        }

        // Overrides the parent method to calculate salary with allowance
        @Override
        double calculateSalary() {
            return basicSalary + allowance;
        }

        // Displays full-time employee details
        @Override
        void displayInfo() {
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Category: Full-Time Employee");
            System.out.printf("Monthly Salary: $%.2f%n",
                    calculateSalary());
        }
    }

    // Subclass for part-time employees
    static class PartTimeEmployee extends Employee {
        int hoursWorked;
        double hourlyRate;

        // Initializes working hours and hourly rate
        PartTimeEmployee(String id, String name, String department,
                         int hoursWorked, double hourlyRate) {
            super(id, name, department, 0);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        // Calculates salary using hours worked multiplied by hourly rate
        @Override
        double calculateSalary() {
            return hoursWorked * hourlyRate;
        }

        // Displays part-time employee details
        @Override
        void displayInfo() {
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Category: Part-Time Employee");
            System.out.printf("Monthly Salary: $%.2f%n",
                    calculateSalary());
        }
    }

    // Subclass for managers
    static class Manager extends Employee {
        double bonus;

        // Initializes manager details and bonus
        Manager(String id, String name, String department,
                double basicSalary, double bonus) {
            super(id, name, department, basicSalary);
            this.bonus = bonus;
        }

        // Calculates manager salary by adding bonus
        @Override
        double calculateSalary() {
            return basicSalary + bonus;
        }

        // Displays manager details
        @Override
        void displayInfo() {
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Category: Manager");
            System.out.printf("Monthly Salary: $%.2f%n",
                    calculateSalary());
        }
    }

    // Main method: program execution starts here
    public static void main(String[] args) {

        // Polymorphism: stores different employee objects in one array
        Employee[] employees = {
                new FullTimeEmployee(
                        "EMP001", "Ahmed Ali", "IT", 600, 50),

                new PartTimeEmployee(
                        "EMP002", "Fatima Hassan", "HR", 30, 8),

                new Manager(
                        "EMP003", "Mohamed Omar", "Management",
                        1000, 200)
        };

        // Prints the report heading
        System.out.println("===== EMPLOYEE SALARY REPORT =====");

        // Loops through employees and displays their information
        for (Employee e : employees) {
            System.out.println();
            e.displayInfo();
        }
    }
}
