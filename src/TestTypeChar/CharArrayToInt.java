package TestTypeChar;

public class CharArrayToInt {
    public static int[][] charArrayConverter(char charMatrix[][]) {
        int[][] numMatrix = new int[charMatrix.length][charMatrix[0].length];
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[0].length; j++) {
                numMatrix[i][j] = (charMatrix[i][j] + 'A') % 26;
            }
        }
        return numMatrix;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'H', 'I'}, {'L', 'L'}};
        int[][] numMatrix = charArrayConverter(matrix);
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[0].length; j++) {
                System.out.print(numMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
