public class TestCustomer {
    public static void main(String[] args) {

        // Instantiate Material instance
        Material m1 = new Material("Engine Oil", 130.80, "Semi Synthetic 15W/40", 2);
        Material m2 = new Material("Oil Filter", 18.30, "Saga OEM", 2);

        // Instantiate Service instance
        Service s1 = new Service("Engine Oil Service", 0.8);

        // Test Customer class
        System.out.println("Test 'Customer' class:");
        System.out.println("----------------------");
        Customer c1 = new Customer("Alice", "456", "No. 6, KTC UTM, Johor", "011-7123987");
        c1.addItem(m1);
        c1.addItem(m2);
        c1.addItem(s1);
        c1.printInfo();
        System.out.println();
    }
}