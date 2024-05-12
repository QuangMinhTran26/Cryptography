package TestType;

public class FlattenArray {
    public static void main(String[] args) {
        int[][] originalArray = {
                {0, 2, 4, 6},
                {1, 3, 5, 7}
        };

        // Calculate the total number of elements in the original array
        int totalElements = originalArray.length * originalArray[0].length;

        // Create a new single-dimensional array to store flattened elements
        int[] flattenedArray = new int[totalElements];

        // Flatten the original array
        int index = 0;
        for (int i = 0; i < originalArray[0].length; i++) {
            for (int j = 0; j < originalArray.length; j++) {
                flattenedArray[index++] = originalArray[j][i];
            }
        }

        // Print the flattened array
        System.out.println("Flattened Array:");
        for (int element : flattenedArray) {
            System.out.print(element + " ");
        }
    }
}
