/*
 * Name: AHMAD FIKRI NABIL BIN ZAMRI
 * Matric ID: A24CS0035
 */


import java.util.Scanner;
import java.time.Year;

public class PatientParallelArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currentYear = Year.now().getValue();

        System.out.print("How many patients? ");
        int n = Integer.parseInt(sc.nextLine());

        String[] name = new String[n];
        int[] yob = new int[n];
        double[] height = new double[n];
        double[] weight = new double[n];
        int[] age = new int[n];
        double[] bmi = new double[n];
        String[] category = new String[n];

        // Input, calculation, output will go here

        // Task A
        for (int i = 0; i < n; i++) {
            System.out.println("\nPatient #" + (i+1));

            System.out.print("Name: ");
            name[i] = sc.nextLine();

            System.out.print("Year of Birth: ");
            yob[i] = sc.nextInt();
            sc.nextLine();

            System.out.print("Height (m): ");
            height[i] = sc.nextDouble();
            sc.nextLine();

            System.out.print("Weight (kg): ");
            weight[i] = sc.nextDouble();
            sc.nextLine();

            // Task B
            age[i] = currentYear - yob[i];
            bmi[i] = weight[i] / Math.pow(height[i], 2.0);


            //System.out.printf("Age: %d", age[i]);
            //System.out.printf("\nBMI: %.2f", bmi[i]);

            // Task C
            if (bmi[i] < 18.5) {
                category[i] = "Underweight";
            }
            else if (bmi[i] >= 18.5 && bmi[i] < 25) {
                category[i] = "Normal";
            }
            else if (bmi[i] >= 25 && bmi[i] < 30) {
                category[i] = "Overweight";
            }
            else {
                category[i] = "Obese";
            }
        }

        // Task D
        System.out.println("\n\n--- PATIENT RECORDS ---");
        System.out.printf("%s%15s  %s%7s%7s%7s%9s", "Name", "YOB", "Age", "Ht(m)", "Wt(kg)", "BMI", "Category");
        System.out.println("\n----------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-4s%15d  %d %7.2f%7.2f%7.2f %-9s\n", name[i], yob[i], age[i], height[i], weight[i], bmi[i], category[i]);
        }

        sc.close();
    }
}

// Reflections
/*
    1.  In my opinion, the challenges of using parallel arrays for related data is making sure the index number is being used correctly to access
        each array.

    2.  Using a class like Patient can improve the structure by implementing all the parallel arrays as a properties of the class. This eliminate
        the uses of parallel arrays to store datas.

    3.  I would sort the data by ascendant order of the BMI.

 */