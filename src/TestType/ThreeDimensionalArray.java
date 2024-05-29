package TestType;

public class ThreeDimensionalArray {

    public static void main(String[] args) {
        int[][][] array = new int[3][4][5]; // 3 layers, each with 4 rows and 5 columns
        int count = 1;
        int[][][] altDisplay = {
                {
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20}
                },
                {
                        {21, 22, 23, 24, 25},
                        {26, 27, 28, 29, 30},
                        {31, 32, 33, 34, 35},
                        {36, 37, 38, 39, 40}
                },
                {
                        {41, 42, 43, 44, 45},
                        {46, 47, 48, 49, 50},
                        {51, 52, 53, 54, 55},
                        {56, 57, 58, 59, 60}
                }
        };

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    array[i][j][k] = count;
                    System.out.println("Element at [" + i + "][" + j + "][" + k + "] = " + array[i][j][k]);
                    count++;
                }
            }
        }
    }
}
