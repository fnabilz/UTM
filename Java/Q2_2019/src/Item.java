public class Item {
    protected String name;
    protected double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("Item Name: " + this.name);
        System.out.println("Price: " + this.price);
    }
}