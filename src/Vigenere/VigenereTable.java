package Vigenere;

public class VigenereTable {

    public static void main(String[] args)

    {
        char[][] exampleArray = new char[3][3];
        char[][] vigenereTable = new char[26][26];
        char c = 65;
        System.out.println(c);
        for( int i = 0; i < exampleArray.length; i++){
            for( int j = 0; j < exampleArray[0].length; j++){
                exampleArray[i][j] = c++;
                System.out.print(vigenereTable[i][j] + " ");
            }
            System.out.println(" ");

        }

    }
}
