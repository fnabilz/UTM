import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("\nEnter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter Bonus Percentage (%): ");
        double bonusPercent = sc.nextDouble();

        Employee Employee1 = new Employee(name, salary, bonusPercent);
        Employee1.calcTotalSalary();
        Employee1.displayInfo();

        sc.close();
    }
}

class Employee {
    // properties
    String name;
    double bonus, bonusPercent, salary, totalSalary;

    // constructor
    public Employee (String name, double salary, double bonusPercent) {
        this.name = name;
        this.salary = salary;
        this.bonusPercent = bonusPercent;
    }

    // methods
    public void calcTotalSalary() {
        bonus = (bonusPercent / 100) * salary;
        totalSalary = bonus + salary;
    }

    public void displayInfo() {
        System.out.println("\nEmployee: " + name);
        System.out.println("Total Salary: $" + totalSalary + "\n");
    }
}

