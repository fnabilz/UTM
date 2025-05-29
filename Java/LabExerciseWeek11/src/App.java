// Name: AHMAD FIKRI NABIL BIN ZAMRI
// Matric ID: A24CS0035

import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> names = List.of("Ali", "Siti", "Ahmad", "Zain", "Anis", "Bakar", "Sara", "Azman");
        List<Integer> marks = List.of(45, 78, 62, 88, 90, 55, 39, 73, 60);
        List<Double> temps = List.of(36.5, 37.0, 36.8, 39.1, 40.0, 38.3, 36.9);

        // Task 1
        System.out.println("\n1. using for loop :");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // Task 2
        System.out.println("\n2. using stream :");
        names.stream().
        forEach(System.out::println);

        System.out.println("\n3. Filter 'A' :");
        names.stream().
        filter(name -> name.startsWith("A"))
        .forEach(System.out::println);

        System.out.println("\n4. All uppercase :");
        names.stream()
        .map(name -> name.toUpperCase());

        System.out.println("\n5. Filter 'A' and all uppercase :");
        names.stream()
        .filter(name -> name.startsWith("A"))
        .map(name -> name.toUpperCase());

        System.out.println("\n6. Count name start with 'S' :");
        System.out.println("Count : " + names.stream().filter(name -> name.startsWith("S")).count());

        System.out.println("\n7. Sort in alphabetical order");
        names.stream()
        .sorted()
        .forEach(System.out::println);

        System.out.println("\n8. Compare execution time print and stream");
        long printStart = System.nanoTime();
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        long printStop = System.nanoTime();
        long printDuration = printStop - printStart;
        printStart = System.nanoTime();
        names.stream()
        .forEach(System.out::println);
        printStop = System.nanoTime();
        long streamDuration = printStop - printStart;
        System.out.printf("Print Time: %f, Stream Time: %f", printDuration/1000000000.0, streamDuration/1000000000.0);


        System.out.println("\n9. marks using stream");
        marks.stream()
        .forEach(System.out::println);

        System.out.println("\n10. filter mark >= 50");
        marks.stream()
        .filter(mark -> mark >= 50).forEach(System.out::println);

        System.out.println("\n11. convert mark to grade");
        marks.stream().map(mark -> {
            if (mark >= 80) return 'A';
            else if (mark >= 70) return 'B';
            else if (mark >= 60) return 'C';
            else return 'D';
        }).forEach(System.out::println);

        System.out.println("\n12. average mark");
        System.out.println("Average: " + marks.stream().mapToInt(x -> x).average().getAsDouble());

        System.out.println("\n13. count how many with A");
        System.out.println("Count: " + marks.stream().filter(mark -> mark >= 80).count());

        System.out.println("\n14. sort in descending");
        marks.stream()
        .sorted(Comparator.reverseOrder())
        .forEach(System.out::println);

        System.out.println("\n15. print temp");
        for (int i = 0; i < temps.size(); i++) {
            System.out.println(temps.get(i));
        }

        System.out.println("\n16. filter above 37.5");
        temps.stream()
        .filter(read -> read > 37.5)
        .forEach(System.out::println);

        System.out.println("\n17. celsius to fahrenheit");
        temps.stream()
        .map(read -> (read * 9.0/5.0) + 32.0)
        .forEach(System.out::println);

        System.out.println("\n18. max and min");
        System.out.printf("Max: %f, Min: %f", temps.stream().mapToDouble(x -> x).max().getAsDouble(), temps.stream().mapToDouble(x -> x).min().getAsDouble());

        System.out.println("\n19. count range 36.5 - 37.4");
        System.out.println("Count: " + temps.stream().filter(read -> read >= 36.5 && read <= 37.4).count());

    }
}
