package Vigenere;

public class VigenereTable {
    public static void main(String[] args) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray(); // Convert string to char array

        int rows = alphabet.length; // Number of rows (same as alphabet length)

        for (int i = 0; i < rows; i++) {
            // Loop for each row
            for (int j = 0; j < rows; j++) {
                // Loop for each element in the row
                int index = (i + j) % rows; // Calculate rotated index
                System.out.print(alphabet[index] + " "); // Print character at rotated index
            }
            System.out.println(); // Print newline after each row
        }
    }
}
