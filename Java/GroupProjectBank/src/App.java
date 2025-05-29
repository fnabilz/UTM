import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<User> userList = new ArrayList<>();
        User currentUser = null;

        User user1 = new User("fnz", "Fikri", "Zamri", "fikri@gmail.com", "12345678", "AccountHolder");

        userList.add(user1);

        System.out.println("-------[Bank System]-------");
        System.out.println("Hello! Please login to continue... ");
        while (currentUser == null) {
            System.out.println("\nID/Email: ");
            String input = scan.nextLine();
            System.out.println("Password :");
            String password = scan.nextLine();
            currentUser = User.login(userList, input, password);
        }

        System.out.println("\nHello " + currentUser.getName() + ",");
        System.out.println("-------[Menu]-------");

        scan.close();
    }
}
