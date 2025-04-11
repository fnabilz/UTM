import java.util.Scanner;

public class ArrayMain {
  public static void main(String[] args) {


    // declare an array variable
    //double[] courseMarks = new double[10];
    double[] courseMarks = {78.5, 90.0, 88.5, 99.0, 100.0};
    String[] names = {"Fikri", "Nabil", "Husna", "Sofia", "Amirul"};

    // assign value
    //courseMarks[0] = 70;
    //courseMarks[1] = 50;

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter student number: ");
    int index = sc.nextInt();
    System.out.println("Enter student course mark: ");
    courseMarks[index] = sc.nextDouble();

    for (int i = 0; i < courseMarks.length; i++) {
        System.out.println("Mark " + i +" : " + courseMarks[i]);
    }

    for (int i = 0; i < names.length; i++) {
        System.out.println("Name " + i + " : " + names[i]);
    }

    sc.close();
  }
}