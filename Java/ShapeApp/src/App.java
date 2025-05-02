

// ------------ Superclass ------------ //
class Shapes {
    private String shapeName;

    public Shapes() {}
    public Shapes(String name) {
        this.shapeName = name;
    }

    public void displayInfo() {
        System.out.println("Shape Name: " + shapeName);
    }
}

// ------------ Subclass ------------//
class OneD extends Shapes {
    private double perimeter;
}

class TwoD extends Shapes {
    private double perimeter;
    private double area;

    public TwoD() {}

    public TwoD(String shapeName) {
        super(shapeName);
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
    }
}

class ThreeD extends Shapes {
    private double area;
    private double volume;
}

// ------------ Subclass ------------ //
class Line extends OneD {
    private double length;
}

class Arc extends OneD {
    private double radius;
    private double angle;
}

class Circle extends TwoD {
    private double radius;

    public Circle(String shapeName, double radius) {
        super(shapeName);
        this.radius = radius;
    }

    public void calculatePerimeter() {
        double perimeter = 2 * Math.PI * radius;
        super.setPerimeter(perimeter);
    }

    public void calculateArea() {
        double area = Math.PI * Math.pow(radius, 2);
        super.setArea(area);
    }
}

class Rectangle extends TwoD {
    private double length;
    private double width;
}

class Triangle extends TwoD {
    private double height;
    private double base;
    private double side;
}

class Cylinder extends ThreeD {
    private double radius;
    private double height;
}

class Sphere extends ThreeD {
    private double radius;
}

class Cuboid extends ThreeD {
    private double length;
    private double height;
    private double width;
}

class Cube extends ThreeD {
    private double length;
}



/*public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n-------------------[ My Shape App! ] -------------------");

        // Create object from class Circle
        Circle disk = new Circle("CD", 5.5);
        disk.calculatePerimeter();
        disk.calculateArea();
        disk.displayInfo();

        // Create object from class Cylinder
        // Cylinder tinCan = new Cylinder(3.0, 7.0);
    }
}*/
