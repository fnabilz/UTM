import java.util.Scanner;

class PersonBmi {
    String name;
    String gender;
    int yearOfBirth;
    double weight;
    double height;
    double bmi;
    String category;

    public PersonBmi(String name, String gender, int yearOfBirth, double weight, double height) {
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.weight = weight;
        this.height = height;
        this.bmi = calculateBMI();
        this.category = determineCategory();
    }

    private double calculateBMI() {
        return weight / (height * height);
    }

    private String determineCategory() {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }

    public int getAge() {
        return 2025 - yearOfBirth;
    }

    public void displayInfo() {
        System.out.println(name + " (" + gender + "), Age: " + getAge());
        System.out.println("Your BMI is: " + bmi + " (" + category + ")");
    }
}

class Stud {
    String name;
    String matricNo;
    int marks;
    String grade;

    public Stud(String name, String matricNo, int marks) {
        this.name = name;
        this.matricNo = matricNo;
        this.marks = marks;
        this.grade = determineGrade();
    }

    private String determineGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F (Fail)";
    }

    public void displayInfo() {
        System.out.println("Student: " + name + " | Matric Num: " + matricNo);
        System.out.println("Grade: " + grade);
    }
}

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        System.out.print("\nEnter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter your matricNo: ");
        String matricNo = sc.nextLine();
        System.out.print("Enter your birth year: ");
        int yearOfBirth = sc.nextInt();

        while (loop == true) {
            System.out.println("\n=== Student Helper App ===");
            System.out.println("1. Check BMI");
            System.out.println("2. Check Grade");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("BMI Checker selected.");

                    System.out.print("\nEnter your weight(kg): ");
                    double weight = sc.nextDouble();
                    System.out.print("Enter your height(m): ");
                    double height = sc.nextDouble();

                    PersonBmi personInfo = new PersonBmi(name, gender, yearOfBirth, weight, height);
                    personInfo.displayInfo();

                    break;
                case 2:
                    System.out.println("Grade Checker selected.");
                    
                    System.out.print("\nEnter your exam marks (0-100): ");
                    int marks = sc.nextInt();
                    
                    Stud studentInfo = new Stud(name, matricNo, marks);
                    studentInfo.displayInfo();
                     
                    break;
                case 3:
                    loop = false;
                    System.out.println("Thank you for using Student Helper App!\n");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}



