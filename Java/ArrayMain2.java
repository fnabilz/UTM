import java.util.ArrayList;

class ArrayHandler2 {

    // methods
    public int countOdd(ArrayList<Integer> array) {
        int odd = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i)%2 != 0) {
                ++odd;
            }
        }

        return odd;
    }

    public int countEven(ArrayList<Integer> array) {
        int even = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i)%2 == 0) {
                ++even;
            }
        }

        return even;
    }

    public int findHighest(ArrayList<Integer> array) {
        int highest = array.get(0);

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > highest) {
                highest = array.get(i);
            }
        }

        return highest;
    }

    public int findLowest(ArrayList<Integer> array) {
        int lowest = array.get(0);

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < lowest) {
                lowest = array.get(i);
            }
        }

        return lowest;
    }

    public int calcTotal(ArrayList<Integer> array) {
        int total = 0;

        for (int i = 0; i < array.size(); i++) {
            total = total + array.get(i);
        }

        return total;
    }

    public int calcAverage(ArrayList<Integer> array) {
        int total = calcTotal(array);
        int average = total / array.size();

        return average;
    }
}

public class ArrayMain2 {
   public static void main(String[] args) {

        // declaration
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(11);
        array.add(20);
        array.add(33);
        array.add(40);
        array.add(55);
        array.add(60);
        array.add(77);
        array.add(80);
        array.add(90);
        array.add(100);
        ArrayHandler2 myAH = new ArrayHandler2();

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


