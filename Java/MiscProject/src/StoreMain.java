

class ArrayHandler {

    // methods
    public int countOdd(int[] array) {
        int odd = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i]%2 != 0) {
                ++odd;
            }
        }

        return odd;
    }

    public int countEven(int[] array) {
        int even = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i]%2 == 0) {
                ++even;
            }
        }

        return even;
    }

    public int findHighest(int[] array) {
        int highest = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > highest) {
                highest = array[i];
            }
        }

        return highest;
    }

    public int findLowest(int[] array) {
        int lowest = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < lowest) {
                lowest = array[i];
            }
        }

        return lowest;
    }

    public int calcTotal(int[] array) {
        int total = 0;

        for (int i = 0; i < array.length; i++) {
            total = total + array[i];
        }

        return total;
    }

    public int calcAverage(int[] array) {
        int total = calcTotal(array);
        int average = total / array.length;

        return average;
    }
}

public class StoreMain {
   public static void main(String[] args) {

        // declaration
        int[] array = {11, 20, 33, 40, 55, 60, 77, 80, 99, 100};
        ArrayHandler myAH = new ArrayHandler();

        // input
        int odd = myAH.countOdd(array);
        int even = myAH.countEven(array);
        int highest = myAH.findHighest(array);
        int lowest = myAH.findLowest(array);
        int total = myAH.calcTotal(array);
        int average = myAH.calcAverage(array);

        // output
        System.out.println("\nOdd: " + odd);
        System.out.println("Even: " + even);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("");
   }
}

