package TestType;

import java.util.HashSet;
import java.util.Set;

public class SetVsArray {
    public static void main(String[] args) {
        // Using an array
        Integer[] array = new Integer[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 2; // Adding a duplicate value - works with array because array can contain duplicate

        System.out.println("Array with duplicate value:");
        for (Integer num : array) {
            System.out.println(num);
        }

        // Using a Set
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2); // Adding a duplicate value - wont work on set, set only allows unique value

        System.out.println("\nSet without duplicate value:");
        for (Integer num : set) {
            System.out.println(num);
        }
    }
}