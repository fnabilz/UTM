// TestShape3D.java 
// TEST 2 - Question 1 
// SECJ2154 - 2022/2023-2 
// Name: ??? 
// Matric No.: ??? 
 
import java.util.ArrayList; 
import java.util.Scanner; 
 
public class TestShape3D { 
  public static void main(String[] args) {  
    Boolean exit = false; 
    String choice; 
    Scanner scan = new Scanner(System.in); 
 
    ArrayList<Shape3D> objList = new ArrayList<>(); 
    Shape3D s3d = new Shape3D(); 
 
    System.out.println("Test Shape3D class"); 
 
    while (!exit) { 
      System.out.print("\nEnter your choice [cylinder | sphere |  exit ]:"); 
      choice = scan.nextLine();
      
      if (choice.equals("cylinder")) { 
        objList.add(s3d.createCylinder(scan)); 
      } 
      else if (choice.equals("sphere")) { 
        objList.add(s3d.createSphere(scan)); 
      } 
      else if (choice.equals("exit")) { 
        exit = true; 
      } 
      
    } 
 
    for (int i = 0; i < objList.size(); i++) { 
      if (objList.get(i) instanceof Cylinder) { 
        Cylinder obj = (Cylinder) objList.get(i); 
        System.out.printf("Object #%d Type: Cylinder, Volume: %.3f\n",  
        (i + 1), obj.getVolume()); 
      } 
      else { 
        Sphere obj = (Sphere) objList.get(i); 
        System.out.printf("Object #%d Type: Sphere, Volume: %.3f\n",  
        (i + 1), obj.getVolume()); 
      } 
    } 
 
    System.out.printf("TOTAL VOLUME = %.2f\n", s3d.TOTAL_VOLUME); 
  } 
} 
 
class Shape3D { 
  public final double PI = 3.14; 
 
  public double TOTAL_VOLUME = 0.0; 
 
  public Cylinder createCylinder(Scanner scn) { 
    System.out.println("Create Cylinder..."); 
    System.out.print("Radius: "); 
    Double r = scn.nextDouble(); 
     
    System.out.print("Length: "); 
    Double l = scn.nextDouble(); 
 
    // Remove \n from input buffer 
    scn.nextLine(); 
 
    // Create new Cylinder instance and sum TOTAL_VOLUME 
    Cylinder cyl = new Cylinder(r, l); 
    TOTAL_VOLUME += cyl.getVolume(); 
 
    // Return the new created Cylinder instance 
    return cyl; 
  } 
 
  public Sphere createSphere(Scanner scn) { 
    System.out.println("Create Sphere..."); 
 
    System.out.print("Radius: "); 
    double r = scn.nextDouble(); 
     
    // Remove \n from input buffer 
    scn.nextLine(); 
 
    // Create new Sphere instance and sum TOTAL_VOLUME 
    Sphere sph = new Sphere(r);
    TOTAL_VOLUME += sph.getVolume(); 
 
    // Return the new created Sphere instance 
    return sph; 
  } 
} 
 
class Cylinder extends Shape3D{ 
  private double radius, height; 
 
  // Constructor 
  public Cylinder() { } 
 
  // Constructor 
  public Cylinder(Double r, Double h) {  
    this.radius = r; 
    this.height = h; 
  } 
 
  public double getVolume() { 
    return super.PI * Math.pow(radius, 2) * height; 
  } 
} 
 
class Sphere extends Shape3D{ 
  private double radius; 
   
  // Constructor 
  public Sphere(double r) { 
    this.radius = r; 
  } 
 
  public double getVolume() { 
    return 4.0 / 3.0 * super.PI * Math.pow(radius, 3); 
  } 
}