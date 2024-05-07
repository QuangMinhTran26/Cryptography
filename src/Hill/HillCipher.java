package Hill;

public class HillCipher {

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
                if (intMat[i][j] >= 0) {
                    charMat[i][j] = (char) (intMat[i][j] % 26 + 'A');
                } else charMat[i][j] = (char) ((intMat[i][j] + 26) % 26 + 'A');
            }
        }
        return charMat;
    }

    public int[][] textTo2DArray(String plaintext) {
        int[][] result = new int[2][plaintext.length() / 2];
        char[] plainArr = plaintext.replaceAll(" ", "").toUpperCase().toCharArray();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = (plainArr[(j * 2 + i) % plainArr.length] + 'A') % 26;
            }
        }
        return result;
    }

    public String flattenArray(char[][] input) {

        return "";
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
        int[][] plainMat = textTo2DArray(plaintext);
        int[][] key = charArrayToInteger(charMat); // convert key to int array
        int[][] encryptedInt = matrixMultiplication(key, plainMat); // does matrix multiplication between key and plaintext array, result integer array
        for (int i = 0; i < encryptedInt.length; i++) {
            for (int j = 0; j < encryptedInt[0].length; j++) {
                encryptedInt[i][j] = encryptedInt[i][j] % 26;
            }
        }

        char[][] textArr = intArrayToChar(encryptedInt); // convert matrix multiplication result to char array
        int counter = 0;
        char[] flattenedArr = new char[textArr.length * textArr[0].length]; //flat this array, pay attention to its special loop please
        for (int i = 0; i < textArr[0].length; i++) {
            for (int j = 0; j < textArr.length; j++) {
                flattenedArr[counter++] = textArr[j][i];
            }
        }

        return String.valueOf(flattenedArr);
    }

    public int[][] invertMatrix(int[][] matrix) {
        int a = matrix[0][0];
        int b = matrix[0][1];
        int c = matrix[1][0];
        int d = matrix[1][1];

        // find ad-bc, then find multiplicative inverse of this mod 26, then takes result multiply with adjoin matrix
        int k = a * d - b * c;
        if (k < 0) k = k + 26; //deal with negative number mod 26
        int mInverse = determineMultiplicativeInverse26(k);

        int[][] inverted = new int[matrix.length][matrix[0].length];
        inverted[0][0] = d;
        inverted[0][1] = -b;
        inverted[1][0] = -c;
        inverted[1][1] = a;

        //K^(-1) = 1/|K| * adjoin(K)
        for (int i = 0; i < inverted.length; i++) {
            for (int j = 0; j < inverted[0].length; j++) {
                inverted[i][j] = inverted[i][j] * mInverse;
                if (inverted[i][j] < 0) {
                    inverted[i][j] = inverted[i][j] + 26;
                }
            }
        }
        return inverted;
    }

    public String hillDecoder(String plaintext, int[][] key) {
        int[][] invertedKey = invertMatrix(key);
        int[][] cipherArr = textTo2DArray(plaintext);
        int[][] decryptedInt = matrixMultiplication(invertedKey, cipherArr);
        for (int i = 0; i < decryptedInt.length; i++) {
            for (int j = 0; j < decryptedInt[0].length; j++) {
                decryptedInt[i][j] = decryptedInt[i][j] % 26;
            }
        }
        char[][] textArr = intArrayToChar(decryptedInt);
        int counter = 0;
        char[] flattenedArr = new char[textArr.length * textArr[0].length]; //flat this array, pay attention to its special loop please
        for (int i = 0; i < textArr[0].length; i++) {
            for (int j = 0; j < textArr.length; j++) {
                flattenedArr[counter++] = textArr[j][i];
            }
        }

        return String.valueOf(flattenedArr);
    }


    public int determineMultiplicativeInverse26(int num) {
        int mInverse = 1;
        while ((mInverse * num) % 26 != 1) {
            mInverse++;
            if ((mInverse * num) % 26 == 1) break;
        }
        return mInverse;
    }
    
}

