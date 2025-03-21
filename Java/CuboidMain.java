import java.util.Scanner;

public class CuboidMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length, width, height;

        // get input
        System.out.println("\nEnter length (m): ");
        length = sc.nextInt();
        System.out.println("Enter width (m): ");
        width = sc.nextInt();
        System.out.println("Enter height (m): ");
        height = sc.nextInt();

        // calculate
        int perimeter = 4 * (length + width + height);
        int area = 2 * ((length * width) + (width * height) + (height * length));
        int volume = length * width * height;

        // output
        System.out.println("\nPerimeter: " + perimeter + " m");
        System.out.println("Area: " + area + " m");
        System.out.println("Volume: " + volume + " m");

        sc.close();
    }
}