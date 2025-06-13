/*
    Name: AHMAD FIKRI NABIL BIN ZAMRI
    Matric ID: A24CS0035
 */

@FunctionalInterface
interface shape2D {
    double calculate(double a, double b, double c, double d);
}

@FunctionalInterface
interface shape3D {
    double calculate(double a, double b, double c);
}

public class App {

    public static void print2D(String text, shape2D function1, shape2D function2, double a, double b, double c, double d) {
        System.out.println(text);
        System.out.printf("> Area = %.2f\n> Perimeter = %.2f\n\n", function1.calculate(a, b, c, d), function2.calculate(a, b, c, d));
    }

    public static void print3D(String text, shape3D function1, shape3D function2, double a, double b, double c) {
        System.out.println(text);
        System.out.printf("> Surface Area = %.2f\n> Volume = %.2f\n\n", function1.calculate(a, b, c), function2.calculate(a, b, c));
    }

    public static void main(String[] args) throws Exception {
        
        shape2D squareArea = (s, x1, x2, x3) -> s * s;
        shape2D squarePerimeter = (s, x1, x2, x3) -> 4.0 * s;

        shape2D rectangleArea = (l, w, x1, x2) -> l * w;
        shape2D rectanglePerimeter = (l, w, x1, x2) -> 2.0 * (l + w);

        shape2D circleArea = (r, x1, x2, x3) -> Math.PI * Math.pow(r, 2.0);
        shape2D circlePerimeter = (r, x1, x2, x3) -> 2.0 * Math.PI * r;

        shape2D triangleArea = (b, h, x1, x2) -> 0.5 * b * h;
        shape2D trianglePerimeter = (b, h, x1, x2) -> b + h + Math.sqrt(Math.pow(b, 2.0) + Math.pow(h, 2.0));

        shape2D equiTriangleArea = (s, x1, x2, x3) -> (Math.sqrt(3.0)/4.0) * Math.pow(s, 2.0);
        shape2D equiTrianglePerimeter = (s, x1, x2, x3) -> 3.0 * s;

        shape2D parallelogramArea = (b, h, s, x1) -> b * h;
        shape2D parrallelogramPerimeter = (b, h, s , x1) -> 2.0 * (b + s);

        shape2D trapeziumArea = (a, b, h, x1) -> 0.5 * (a + b) * h;
        shape2D trapeziumPerimeter = (a, b, s1, s2) -> a + b + s1 + s2;

        shape2D ellipseArea = (a, b, x1, x2) -> Math.PI * a * b;
        shape2D ellipsePerimeter = (a, b, x1, x2) -> 2.0 * Math.PI * Math.sqrt((Math.pow(a, 2.0) + Math.pow(b, 2.0)) / 2.0);

        System.out.println("\n=====2DShape=====");
        print2D("Shape: Square (s = 5.0)", squareArea, squarePerimeter, 5.0, 0.0, 0.0, 0.0);
        print2D("Shape: Rectangle (l = 5.0, w = 10.0)", rectangleArea, rectanglePerimeter, 5.0, 10.0, 0.0, 0.0);
        print2D("Shape: Circle (r = 5.0)", circleArea, circlePerimeter, 5.0, 0.0, 0.0, 0.0);
        print2D("Shape: Triangle (b = 5.0, h = 12.0)", triangleArea, trianglePerimeter, 5.0, 12.0, 0.0, 0.0);
        print2D("Shape: Equilateral Triangle (s = 5.0)", equiTriangleArea, equiTrianglePerimeter, 5.0, 0.0, 0.0, 0.0);
        print2D("Shape: Parallelogram (b = 10.0, h = 5.0, s = 4.0)", parallelogramArea, parrallelogramPerimeter, 10.0, 5.0, 4.0, 0.0);
        print2D("Shape: Trapezium (a = 5.0, b = 6.0, h = 4.0, s1 = 4.0, s2 = 4.0)", trapeziumArea, trapeziumPerimeter, 5.0, 6.0, 4.0, 4.0);
        print2D("Shape: Ellipse (a = 5.0, b = 3.0)", ellipseArea, ellipsePerimeter, 5.0, 3.0, 0.0, 0.0);

        shape3D cubeArea = (s, x1, x2) -> 6.0 * Math.pow(s, 2.0);
        shape3D cubeVolume = (s, x1, x2) -> Math.pow(s, 3.0);

        shape3D cuboidArea = (l, w, h) -> 2.0 * ((l*w) + (l*h) + (w*h));
        shape3D cuboidVolume = (l, w, h) -> l * w * h;

        shape3D sphereArea = (r, x1, x2) -> 4.0 * Math.PI * Math.pow(r, 2.0);
        shape3D sphereVolume = (r, x1, x2) -> (4.0/3.0) * Math.PI * Math.pow(r, 3.0);

        shape3D hemisArea = (r, x1, x2) -> 3.0 * Math.PI * Math.pow(r, 2.0);
        shape3D hemisVolume = (r, x1, x2) -> (2.0/3.0) * Math.PI * Math.pow(r, 3.0);

        shape3D cylinderArea = (r, h, x1) -> 2 * Math.PI * r * (r + h);
        shape3D cylinderVolume = (r, h, x1) -> Math.PI * Math.pow(r, 2.0) * h;

        shape3D coneArea = (r, h, l) -> Math.PI * r * (r + l);
        shape3D coneVolume = (r, h, l) -> (1.0/3.0) * Math.PI * Math.pow(r, 2.0) * h;

        shape3D sqPyramidArea = (s, h, l) -> Math.pow(s, 2.0) + (2.0 * s * l);
        shape3D sqPyramidVolume = (s, h, l) -> (1.0/3.0) * Math.pow(s, 2.0) * h;
        
        shape3D tetraArea = (a, x1, x2) -> Math.sqrt(3.0) * Math.pow(a, 2.0);
        shape3D tetraVolume = (a, x1, x2) -> Math.pow(a, 3.0) / (6 * Math.sqrt(2.0));

        shape3D prismArea = (b, h, l) -> (b * h) + (3 * b * l);
        shape3D prismVolume = (b, h, l) -> 0.5 * b * h * l;

        System.out.println("=====3DShape=====");
        print3D("Shape: Cube (s = 5.0)", cubeArea, cubeVolume, 5.0, 0.0, 0.0);
        print3D("Shape: Cuboid (l = 10.0, w = 5.0, h = 5.0)", cuboidArea, cuboidVolume, 10.0, 5.0, 5.0);
        print3D("Shape: Sphere (r = 5.0)", sphereArea, sphereVolume, 5.0, 0.0, 0.0);
        print3D("Shape: Hemisphere (r = 5.0)", hemisArea, hemisVolume, 5.0, 0.0, 0.0);
        print3D("Shape: Cylinder (r = 5.0, h = 10.0)", cylinderArea, cylinderVolume, 5.0, 10.0, 0.0);
        print3D("Shape: Cone (r = 5.0, h = 10.0, l = 11.18)", coneArea, coneVolume, 5.0, 10.0, 11.18);
        print3D("Shape: Square Pyramid (s = 5.0, h = 10.0, l = 10.31)", sqPyramidArea, sqPyramidVolume, 5.0, 10.0, 10.31);
        print3D("Shape: Tetahedron (a = 5.0)", tetraArea, tetraVolume, 5.0, 0.0, 0.0);
        print3D("Shape: Prism (b = 5.0, h = 10.0, l = 8.0)", prismArea, prismVolume, 5.0, 10.0, 8.0);
    }
}
