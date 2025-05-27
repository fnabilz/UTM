public class TestItem {
    public static void main(String[] args) {

        // Test Material class
        System.out.println("Test 'Material' class:");
        System.out.println("----------------------");
        Material m = new Material("Engine Oil", 130.80, "Semi Synthetic 15W/40", 2);
        m.printInfo();
        System.out.println();

        // Test Service class
        System.out.println("Test 'Service' class:");
        System.out.println("---------------------");
        Service s1 = new Service("Engine Oil Service", 0.5);
        s1.printInfo();
        System.out.println();

        System.out.println("---------------------");
        Service s2 = new Service("Major Service", 2.8);
        s2.printInfo();
        System.out.println();
    }
}