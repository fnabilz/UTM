public class Material extends Item {
    private String spec;
    private int qty;

    public Material(String name, double price, String spec, int qty) {
        super(name, price);
        this.spec = spec;
        this.qty = qty;
    }

    public double getTotalPrice() {
        return super.price * this.qty;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Type: MATERIAL");
        System.out.println("Spec.: " + this.spec);
        System.out.println("Quantity: " + this.qty);
        System.out.println("Total Price: " + getTotalPrice());
    }
}
