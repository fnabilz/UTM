import java.util.ArrayList;
import java.util.Vector; 
 
class Coffee 
{ 
    private String coffeeId; 
    private String flavour; 
    private double pricePerUnit; 
 
    Coffee(String id, String n, double p) { 
        this.coffeeId = id; 
        this.flavour = n; 
        this.pricePerUnit = p; 
    } 
    
    public String getId() { return coffeeId; } 
 
    public String getFlavour() {  return flavour; } 
 
    public double getPrice() { return pricePerUnit; } 
 
    public void display() {     
        System.out.printf("%-15s%-15s%5.2f\n",coffeeId,flavour,pricePerUnit); 
    } 
} 
 
 
class DiscountedItem extends Coffee 
{ 
    private double discRate; 
 
    DiscountedItem(String id, String n, double p, double r){ 
        super(id, n, p); 
        this.discRate = r; 
    } 
    
    @Override
    public double getPrice() {
        return (super.getPrice()-(super.getPrice()*discRate));
    } 
} 
 
 
class Customer 
{ 
    private String customerName; 
 
    public Customer(String n) 
    { customerName = n; } 
 
    public String getName()
    {  return customerName; } 
} 
 
 
class CoffeeOrder 
{ 
    private int orderId, unit; 
    private Customer customer; 
    private Coffee item; 
 
    public CoffeeOrder(int id, Customer c, Coffee i,int u) 
    { 
        this.customer = c; 
        this.orderId = id; 
        this.item = i; 
        this.unit = u; 
    } 
 
    public double calcTotalPrice() 
    {  return item.getPrice()*unit;   } 
 
    @Override
    public String toString() 
    { return "\nOrder ID: " + orderId + "\nCustomer Name: " + customer.getName() + "\nFlavour: " + item.getFlavour() + "\nQuantity: " + unit + "\nPrice per Unit: " + item.getPrice() + "\nTotal Price: " + calcTotalPrice(); } } 
 
public class TestOrder 
{ 
    public static void main(String[] args) { 
        Coffee myCoffee = new Coffee("CC001", "Caramel", 10.00); 
        DiscountedItem yourCoffee = new DiscountedItem("CC008", "Latte", 8.00, 0.10); 
        Coffee hisCoffee= new Coffee("CC009", "Mocha", 9.00); 
 
        System.out.println("\n ITEM DESCRIPTION"); 
        System.out.println("********************"); 
        System.out.printf("%-15s%-15s%-25s\n", "Coffee ID", "Flavour", "Price"); 
        System.out.printf("%-15s%-15s%-25s\n", "*********", "********", "******"); 
 
        Vector<Coffee> menu = new Vector<Coffee>(); 
        menu.add(myCoffee); 
        menu.add(yourCoffee); 
        menu.add(hisCoffee); 
 
        for (int i = 0; i < menu.size(); i++) 
        { 
            menu.get(i).display(); 
        } 
 
    
        System.out.println("************************************"); 
        Customer [] c= new Customer[3]; 
        c[0] = new Customer("Arif"); 
        c[1] = new Customer("Hakim"); 
        c[2] = new Customer("Nuha"); 
 
        ArrayList<CoffeeOrder> order = new ArrayList<CoffeeOrder>(); 
 
        order.add(new CoffeeOrder(1, c[0],myCoffee,2)); 
        order.add(new CoffeeOrder(2, c[1],yourCoffee,3)); 
        order.add(new CoffeeOrder(3, c[2],hisCoffee,1)); 
 
        System.out.println("List of orders :"); 
 
        for (int i = 0; i < order.size(); i++) 
        {   
            System.out.println((order.get(i)).toString()); 
        } 
    }
}
