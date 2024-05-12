package Framework;

@SuppressWarnings("DuplicatedCode")
public class HillCipher implements Cipher<int[][]> {

    // when a number is < -26, then add a certain amount of step 26 so that it becomes >= 0
    public int step26(int num) {
        if (num < 0) {
            int result = num + 26;
            while (result < 0) {
                result += 26;
            }
            return result;
        } else return num;
    }

    // Mat is short for Matrix
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
                charMat[i][j] = (char) (step26(intMat[i][j]) % 26 + 'A');
            }
        }
        return charMat;
    }

    public int[][] textTo2dIntArray(String plaintext) {
        plaintext = plaintext.replaceAll(" ", "").toUpperCase();
        if (plaintext.length() % 2 != 0) {
            plaintext = plaintext + 'A';
        }
        int[][] result = new int[2][plaintext.length() / 2];
        char[] plainArr = plaintext.toCharArray();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = (plainArr[(j * 2 + i)] + 'A') % 26;
            }
        }
        return result;
    }

    //Or use StringBuilder, check Hill
    public String flattenArray(char[][] input) {
        char[] text = new char[input[0].length * input.length];
        int index = 0;
        for (int i = 0; i < input[0].length; i++) {
            for (int j = 0; j < input.length; j++) {
                text[index++] = input[j][i];
            }
        }
        return String.valueOf(text);
    }

    // Matrix multiplication is not commutative, so oder has to be key * 2dArray
    public int[][] matrixMultiplication(int[][] key, int[][] link) {

        int sourceRows = key.length;
        int sourceColumns = key[0].length;
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

    @Override
    public String encode(String plaintext, int[][] key) {
        int[][] plainMat = textTo2dIntArray(plaintext);
        int[][] encryptedInt = matrixMultiplication(key, plainMat); // does matrix multiplication between key and plaintext array, result integer array
        for (int i = 0; i < encryptedInt.length; i++) {
            for (int j = 0; j < encryptedInt[0].length; j++) {
                encryptedInt[i][j] = encryptedInt[i][j] % 26;
            }
        }

        char[][] textArr = intArrayToChar(encryptedInt); // convert matrix multiplication result to char array
        return flattenArray(textArr);
    }

    public int[][] invertMatrix(int[][] matrix) {
        int a = matrix[0][0];
        int b = matrix[0][1];
        int c = matrix[1][0];
        int d = matrix[1][1];

        // find ad-bc, then find multiplicative inverse of this mod 26, then takes result multiply with adjoin matrix
        int k = a * d - b * c;
        k = step26(k); //deal with negative number mod 26, would that be the case
        int mInverse = multiplicativeInverse26(k);

        int[][] inverted = new int[matrix.length][matrix[0].length];
        inverted[0][0] = d;
        inverted[0][1] = -b;
        inverted[1][0] = -c;
        inverted[1][1] = a;

        //K^(-1) = 1/|K| * adjoin(K)
        for (int i = 0; i < inverted.length; i++) {
            for (int j = 0; j < inverted[0].length; j++) {
                inverted[i][j] = step26(inverted[i][j] * mInverse) % 26;
            }
        }
        return inverted;
    }

    public int multiplicativeInverse26(int num) {
        int mInverse = 1;
        while ((mInverse * num) % 26 != 1) {
            mInverse++;
        }
        return mInverse;
    }

    @Override
    public String decode(String plaintext, int[][] key) {
        int[][] invertedKey = invertMatrix(key);
        int[][] cipherArr = textTo2dIntArray(plaintext);
        int[][] decryptedInt = matrixMultiplication(invertedKey, cipherArr);
        for (int i = 0; i < decryptedInt.length; i++) {
            for (int j = 0; j < decryptedInt[0].length; j++) {
                decryptedInt[i][j] = decryptedInt[i][j] % 26;
            }
        }
        char[][] textArr = intArrayToChar(decryptedInt);
        return flattenArray(textArr);
    }

}

