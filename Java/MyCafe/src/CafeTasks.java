import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CafeTasks {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Async Cafe 🍽️");
        System.out.println("Simulating cafe tasks (synchronously)...");

        // Start time
        long start = System.nanoTime();

        Callable<String> BaristaTask = () -> {
            try {
                System.out.println("\n[1] Barista starts making drinks...");
                Thread.sleep(2000);
                return "🥤 Drinks ready!";
            } 
            catch (Exception error) {
                error.printStackTrace();
                return "";
            }

        };

        //Thread Barista =  new Thread(() -> {});
        //Thread Barista = new Thread(BaristaTask);
        //Barista.start();

        Callable<String> ChefTask = () -> {
            try {
                System.out.println("\n[2] Chef starts cooking Chinese fried rice...");
                Thread.sleep(2000);
                return  "🍛 Fried rice served!";
            } 
            catch (Exception error) {
                error.printStackTrace();
                return "";
            }
        };

        //Thread Chef = new Thread(() -> {});
        //new Thread(ChefTask).start();

        Runnable BuskerTask = () -> {
             try {
                System.out.println("\n[3] Busker performs live music for customers...");
                Thread.sleep(1000);
                System.out.println("🎶 Customers enjoyed the music!");
            } 
            catch (Exception error) {
                error.printStackTrace();
            }
        };

        //Thread Busker = new Thread(() -> {});
        new Thread(BuskerTask).start();

        Runnable WaiterTask = () -> {
            try {
                System.out.println("\n[4] Waiter prepares tables for new guests...");
                Thread.sleep(1000);
                System.out.println("🍽️ Tables are clean and ready!");
            }
            catch (Exception error) {
                error.printStackTrace();
            }
        };

        //Thread Waiter = new Thread(() -> {});

        new Thread(WaiterTask).start();

        //Barista.join();
        //Chef.join();
        //Waiter.join();
        //Busker.join();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> drink = executorService.submit(BaristaTask);
        Future<String> food = executorService.submit(ChefTask);
        executorService.submit(WaiterTask);
        executorService.submit(BuskerTask);
        
        System.out.println(drink.get() + "\n" + food.get());

        // End time
        long end = System.nanoTime();
        double seconds = (end - start) / 1_000_000_000.0;

        System.out.printf("\n✅ All tasks completed in %.2f seconds.\n", seconds);
        System.out.println("Thank you for visiting Async Cafe!");

        executorService.shutdown();
    }
}
