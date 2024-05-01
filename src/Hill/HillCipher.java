package Hill;

public class HillCipher {


    public int[][] charArrayToInteger(char[][] charMat) {
        int[][] numMat = new int[charMat.length][charMat[0].length];
        for (int i = 0; i < numMat.length; i++) {
            for (int j = 0; j < numMat[0].length; j++) {
                numMat[i][j] = (charMat[i][j] + 'A') % 26;
            }
        }
        return numMat;
    }

    public char[][] intArrayToChar(int[][] intMat) {
        char[][] charMat = new char[intMat.length][intMat[0].length];
        for (int i = 0; i < charMat.length; i++) {
            for (int j = 0; j < charMat[0].length; j++) {
                if (intMat[i][j] >= 0) {
                    charMat[i][j] = (char) (intMat[i][j] % 26 + 'A');
                } else charMat[i][j] = (char) ((intMat[i][j] + 26) % 26 + 'A');
            }
        }
        return charMat;
    }

    // Matrix multiplication is not commutative, so oder has to be key * 2dArray
    public int[][] matrixMultiplication(int[][] key, int[][] link) {

        int sourceRows = key.length;
        int sourceColumns = key[0].length;
        int keyRows = link.length;
        int keyColumns = link[0].length;

        int[][] result = new int[sourceRows][keyColumns];

        for (int i = 0; i < sourceRows; i++) {
            for (int j = 0; j < keyColumns; j++) {
                for (int k = 0; k < sourceColumns; k++) {
                    result[i][j] += key[i][k] * link[k][j];
                }
            }
        }
        return result;
    }

    public String hillEncoder(String plaintext, char[][] charMat) {
        int[][] plainMat = new int[charMat.length][plaintext.length() / 2];
        char[] plainArr = plaintext.replaceAll(" ", "").toUpperCase().toCharArray();

        for (int i = 0; i < plainMat.length; i++) { // rows
            for (int j = 0; j < plainMat[0].length; j++) { // columns
                plainMat[i][j] = (plainArr[(j * 2 + i) % plainArr.length] + 'A') % 26; // iterate through the length of the plain text, even INDEX goes to first row, odd index goes to second
            }
        }

        int[][] key = charArrayToInteger(charMat); // convert key to int array
        int[][] encryptedArr = matrixMultiplication(key, plainMat); // does matrix multiplication between key and plaintext array, result integer array
        for (int i = 0; i < encryptedArr.length; i++) {
            for (int j = 0; j < encryptedArr[0].length; j++) {
                encryptedArr[i][j] = encryptedArr[i][j] % 26;
            }
        }

        char[][] textArr = intArrayToChar(encryptedArr); // convert matrix multiplication result to char array
        int counter = 0;
        char[] flattenedArr = new char[textArr.length * textArr[0].length]; //flat this array, pay attention to its special loop please
        for (int i = 0; i < textArr[0].length; i++) {
            for (int j = 0; j < textArr.length; j++) {
                flattenedArr[counter++] = textArr[j][i];
            }
        }

        return String.valueOf(flattenedArr);
    }

    public static void main(String[] args) {
        HillCipher testObject = new HillCipher();
        char[][] key = {{'H', 'I'}, {'L', 'L'}};
        System.out.print(testObject.hillEncoder("short example", key));
    }
}

