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
        Person p1 = new Person("ABU BAKAR",2004,66,1.67f);
        p1.calculate();
        p1.displayInfo();

        Person p2 = new Person("SARAH",2000,55,1.55f);
        p2.calculate();
        p2.displayInfo();
    }
}