import java.util.Vector;

public class Customer extends Person {
    private String address;
    private String phone;
    private Vector<Item> item = new Vector<>();


    public Customer(String name, String ic_no, String address, String phone) {
       super(name, ic_no);
        this.address = address;
        this.phone = phone;
    }

    public void addItem(Item object) {
        item.add(object);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Address: " + this.address);
        System.out.println("Phone: " + this.phone);
        System.out.println("\nOrdered Item(s):\n................");

        double grandTotal = 0.0;
        for (int i = 0; i < item.size(); i++) {
            System.out.println("");
            item.get(i).printInfo();
            if (item.get(i) instanceof Material) {
                Material object = (Material) item.get(i);
                grandTotal += object.getTotalPrice();
            }
            else {
                Service object = (Service) item.get(i);
                grandTotal += object.getTotalPrice();
            }
        }
        System.out.printf("\nGRAND TOTAL PRICE: %.2f ", grandTotal);
        
    }
}
