import java.util.Scanner;

class Person {
    // properties
    String name;
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
    }

    public void displayInfo() {
        System.out.println("Hello, nice meeting you: " +name);
        System.out.println("Age is: " +age +" years old");
        System.out.println("Weight: " +weight +" kg");
        System.out.println("Height: " +height +"m");
        System.out.println("BMI: " +bmi);
    }
}

class Prog001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person p1 = new Person("ABU BAKAR",2004,66,1.67f);
        p1.calculate();
        p1.displayInfo();

        Person p2 = new Person("SARAH",2000,55,1.55f);
        p2.calculate();
        p2.displayInfo();

        System.out.println("Enter name, year, weight, height...");
        String name = sc.nextLine();
        int yob = sc.nextInt();
        int weight = sc.nextInt();
        float height = sc.nextFloat();    

        Person p3 = new Person(name, yob, weight, height);
        p3.calculate();
        p3.displayInfo();

        Person p4 = new Person("ADAM",1995,70,1.75f);
        p4.calculate();
        p4.displayInfo();

        Person p5 = new Person("MUHAMMAD",1985,65,1.72f);
        p5.calculate();
        p5.displayInfo();

        sc.close();
    }
}