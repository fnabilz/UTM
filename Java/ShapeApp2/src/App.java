/*
 * Name: Ahmad Fikri Nabil bin Zamri
 * Matric ID: A24CS0035
 */

import java.util.ArrayList;
import java.util.Scanner;


class Shape {
    private String name;


    public Shape(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    // General displayInfo method in the base class
    public void displayInfo() {
        System.out.println("=======================");
        System.out.println("Shape Name: " + name);
    }
}

interface Shape2DInterface {
    public void calculateArea();
    public void calculatePerimeter();
}

interface Shape3DInterface {
    public void calculateVolume();
   
}


// Shape2D is the parent class for all 2D shapes
class Shape2D extends Shape {
    protected double perimeter;
    protected double area;


    public Shape2D(String name) {
        super(name);
    }

    //abstract public void calculateArea();

    //abstract public void calculatePerimeter();


    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo() method of Shape class
        // System.out.println(String.format("Area: %.2f,Perimeter:
        // %.2f",area,perimeter));
        System.out.println("Area : " + area + ", Perimeter : " + perimeter);
    }
}


// Shape3D is the parent class for all 3D shapes
class Shape3D extends Shape {
    protected double volume;


    public Shape3D(String name) {
        super(name);
    }


    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo() method of Shape class
        // System.out.println(String.format("Volume: %.2f", volume));
        System.out.println("Volume: " + volume);
    }
}


// Circle class (2D shape)
class Circle extends Shape2D implements Shape2DInterface {
    private double radius;


    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
        // calculateArea();
        // calculatePerimeter();
    }


    // Calculate area of the circle
    public void calculateArea() {
        area = Math.PI * radius * radius;
    }


    // Calculate perimeter (circumference) of the circle
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }


    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo() method of Shape2D class
        System.out.println("Radius: " + radius);
    }
}


// Rectangle class (2D shape)
class Rectangle extends Shape2D implements Shape2DInterface  {
    private double length;
    private double width;


    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
        // calculateArea();
        // calculatePerimeter();
    }


    // Calculate area of the rectangle
    public void calculateArea() {
        area = length * width;
    }


    // Calculate perimeter of the rectangle
    public void calculatePerimeter() {
        perimeter = 2 * (length + width);
    }


    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo() method of Shape2D class
        System.out.println("Length: " + length + ", Width: " + width);
    }
}


// Sphere class (3D shape)
class Sphere extends Shape3D implements Shape3DInterface {
    private double radius;


    public Sphere(double radius) {
        super("Sphere");
        this.radius = radius;
        // calculateVolume();
    }


    // Calculate volume of the sphere
    public void calculateVolume() {
        volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }


    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo() method of Shape3D class
        System.out.println("Radius: " + radius);
    }
}


// Cylinder class (3D shape)
class Cylinder extends Shape3D implements Shape3DInterface {
    private double radius;
    private double height;


    public Cylinder(double radius, double height) {
        super("Cylinder");
        this.radius = radius;
        this.height = height;
        // calculateVolume();
    }


    // Calculate volume of the cylinder
    public void calculateVolume() {
        volume = Math.PI * Math.pow(radius, 2) * height;
    }


    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo() method of Shape3D class
        System.out.println("Radius: " + radius + ", Height: " + height);
    }
}



// Main application to create objects and display their properties
public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Shape> shapesList = new ArrayList<>(); // ArrayList to store shape
    // objects
    
    while (true) {
        // Menu options
        System.out.println("\nMenu:");
        System.out.println("1. Create Circle");
        System.out.println("2. Create Rectangle");
        System.out.println("3. Create Sphere");
        System.out.println("4. Create Cylinder");
        System.out.println("5. Display All Shapes Info");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            // Create Circle
            System.out.print("Enter the radius for the Circle: ");
            double radius = scanner.nextDouble();
            Circle circle = new Circle(radius);
            circle.calculateArea();
            circle.calculatePerimeter();
            shapesList.add(circle);
            System.out.println("Circle created.");
        } 
        else if (choice == 2) {
            // Create Rectangle
            System.out.print("Enter the length for the Rectangle: ");
            double length = scanner.nextDouble();
            System.out.print("Enter the width for the Rectangle: ");
            double width = scanner.nextDouble();
            Rectangle rectangle = new Rectangle(length, width);
            rectangle.calculateArea();
            rectangle.calculatePerimeter();
            shapesList.add(rectangle);
            System.out.println("Rectangle created.");
        } 
        else if (choice == 3) {
            // Create Sphere
            System.out.print("Enter the radius for the Sphere: ");
            double radius = scanner.nextDouble();
            Sphere sphere = new Sphere(radius);
            sphere.calculateVolume();
            shapesList.add(sphere);
            System.out.println("Sphere created.");
        } 
        else if (choice == 4) {
            // Create Cylinder
            System.out.print("Enter the radius for the Cylinder: ");
            double radius = scanner.nextDouble();
            System.out.print("Enter the height for the Cylinder: ");
            double height = scanner.nextDouble();
            Cylinder cylinder = new Cylinder(radius, height);
            cylinder.calculateVolume();
            shapesList.add(cylinder);
            System.out.println("Cylinder created.");
        } 
        else if (choice == 5) {
            // Display all shapes info
            if (shapesList.isEmpty()) {
                System.out.println("No shapes created yet.");
            } 
            else {
                for (Shape shape : shapesList) {
                    shape.displayInfo();
                }
            }
        } 
        else if (choice == 6) {
            // Exit
            System.out.println("Exiting...");
            break;
        } 
        else {
            System.out.println("Invalid option. Please try again.");
        }
    }
    
    scanner.close();

    }
}


