package StudentHelperApp.src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

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

                    double bmi = weight/(height * height);
                    System.out.println("BMI: " + bmi);

                    if (bmi < 18.5)
                        System.out.println("Underweight");
                    else if (bmi < 24.9)
                        System.out.println("Normal");
                    else if (bmi < 29.9)
                        System.out.println("Overweight");
                    else
                        System.out.println("Obese");

                    break;
                case 2:
                    System.out.println("Grade Checker selected.");
                    break;
                case 3:
                    loop = false;
                    System.out.println("Thank you for using Student Helper App!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}

