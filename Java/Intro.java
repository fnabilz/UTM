import java.util.Scanner;

class Prog001 {
    
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
        
            System.out.println("Please enter your name...");
            String name = sc.nextLine(); // read the input
            System.out.println("Please enter year born...");
            int yob = sc.nextInt(); // read the input
            
            // read weight(kg) & height(meter)
            System.out.println("Please enter your weight (kg)...");
            float weight = sc.nextFloat();
            System.out.println("Please enter your height (m)...");
            float height = sc.nextFloat();
            
            
            // process calc age
            int age = 2025 - yob;
            float bmi = weight / (height * height);
            
            System.out.println("Hello, nice meeting you: " +name);
            System.out.println("Age is: " +age +" years old");
            System.out.println("Weight: " +weight +" kg");
            System.out.println("Height: " +height +"m");
            System.out.println("BMI: " +bmi);

            sc.close();
    }
    
}