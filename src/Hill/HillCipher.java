package Hill;

public class HillCipher {
  

    public static int[][] charArrayToInteger(char[][] charMatrix) {
        int[][] numMatrix = new int[charMatrix.length][charMatrix[0].length];
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[0].length; j++) {
                numMatrix[i][j] = (charMatrix[i][j] + 'A') % 26;
            }
        }
        return numMatrix;
    }

    public static char[][] intArrayToChar(int[][] intMatrix) {
        char[][] charMatrix = new char[intMatrix.length][intMatrix[0].length];
        for (int i = 0; i < charMatrix.length; i++) {
            for (int j = 0; j < charMatrix[0].length; j++) {
                if (intMatrix[i][j] >= 0) {
                    charMatrix[i][j] = (char) (intMatrix[i][j] % 26 + 'A');
                } else charMatrix[i][j] = (char) ((intMatrix[i][j] + 26) % 26 + 'A');
            }
        }
        return charMatrix;
    }

    public static int[][] matrixMultiplication(int[][] source, int[][] key) throws IllegalAccessException {

        int sourceRows = source.length;
        int sourceColumns = source[0].length;
        int keyRows = key.length;
        int keyColumns = key[0].length;

        int[][] result = new int[sourceRows][keyColumns];

        if (sourceColumns != keyRows) {
            throw new IllegalAccessException("Source:Rows: " + sourceColumns + " did not match Key:Columns" + keyRows + ".");
        }
        for (int i = 0; i < sourceRows; i++) {
            for (int j = 0; j < keyColumns; j++) {
                for (int k = 0; k < sourceColumns; k++) {
                    result[i][j] += key[i][k] * source[k][j];
                }

            }
        }
        return result;
    }

    private String hillEncoder(String input, char[][] charMatrix) {

        return "";
    }
}
