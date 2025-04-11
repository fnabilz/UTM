import java.util.Scanner;

class Person {
    // properties
    String name, category;
    int yob, age, weight;
    float height, bmi;

    //constructor
    public Person(String name, int yob, int weight, float height){
        this.name = name;
        this.yob = yob;
        this.weight = weight;
        this.height = height;
    }    

    // methods
    public void calculate() {
        age = 2025 - yob;
        bmi = weight / (height * height);
        if (bmi > 25) {
            this.category = "OVERWEIGHT";
        }
        else if (bmi > 20) {
            this.category = "NORMAL";
        }
        else {
            this.category = "UNDERWEIGHT";
        }
    }

    public void displayInfo() {
        System.out.println("Hello, nice meeting you: " +name);
        System.out.println("Age is: " +age +" years old");
        System.out.println("Weight: " +weight +" kg");
        System.out.println("Height: " +height +"m");
        System.out.println("BMI: " +bmi);
        System.out.println("Category: " +category);
    }
}

class Prog001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name, year, weight, height...");
        String name = sc.nextLine();
        int yob = sc.nextInt();
        int weight = sc.nextInt();
        float height = sc.nextFloat();    

        Person p1 = new Person(name, yob, weight, height);
        p1.calculate();
        p1.displayInfo();

        sc.close();
    }
}