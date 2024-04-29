package Hill;

public class HillCipher {
    private char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private String hillEncoder(String input, char charMatrix[][]) {
        int[][] numMatrix = new int[charMatrix.length][charMatrix[0].length];
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[0].length; j++) {
                numMatrix[i][j] = (charMatrix[i][j] + 'A') % 26;
            }
        }

        return "";
    }
}
