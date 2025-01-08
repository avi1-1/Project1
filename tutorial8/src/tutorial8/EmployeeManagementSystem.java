package tutorial8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;

    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Position=" + position + ", Salary=" + salary + "]";
    }
}

class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    public void removeEmployee(int id) {
        boolean removed = employees.removeIf(emp -> emp.getId() == id);
        if (removed) {
            System.out.println("Employee with ID " + id + " removed.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void updateEmployee(int id, String name, String position, double salary) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(name);
                emp.setPosition(position);
                emp.setSalary(salary);
                System.out.println("Employee updated: " + emp);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. List Employees");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    manager.addEmployee(new Employee(id, name, position, salary));
                    break;

                case 2:
                    System.out.print("Enter ID of employee to remove: ");
                    int removeId = scanner.nextInt();
                    manager.removeEmployee(removeId);
                    break;

                case 3:
                    System.out.print("Enter ID of employee to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Position: ");
                    String newPosition = scanner.nextLine();
                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();
                    manager.updateEmployee(updateId, newName, newPosition, newSalary);
                    break;

                case 4:
                    manager.listEmployees();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
