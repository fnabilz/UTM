import java.util.List;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> nameList = List.of("mei", "azam", "ali", "siti", "ahmad", "abdul");

        // normal iteration with sysout
        System.out.println("\nusing for loop");
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }

        // sysout with stream
        System.out.println("\nusing stream");


        long totalCount = nameList
                .stream()
                .filter(name -> name.startsWith("a"))
                .sorted()
                .count(); // for each element in here will able to execute/perform an operation

        System.out.println("how many ..?: " + totalCount);

        int[] marks = {86, 69, 90, 45, 98};
        String[] names = {"mei", "azam", "ali", "siti", "ahmad", "abdul"};
        //names.stream(); (cannot do)
        Arrays.stream(names).forEach(System.out::println);
        int sum = Arrays
                    .stream(marks)
                    .sum();

        Arrays
            .stream(marks)
            .filter(num -> num%2 == 0)
            .forEach(x -> {System.out.println("Here it is :" + x);});

        List<Integer> markList = List.of(86, 69, 90, 45, 98);
        markList.stream();
        //System.out.println("Hello, World!");
    }
}
