public class Service extends Item {
    private double man_hours;

    public Service(String name, double man_hours) {
        super(name, 15);
        this.man_hours = man_hours;
    }

    public double getTotalPrice() {
        return 15.0 + 15.0 * (this.man_hours - 0.5);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Type: SERVICE");
        System.out.println("Man Hours: " + this.man_hours);
        System.out.println("Total Price: " + getTotalPrice());
    }
}
