package Base64;

import java.math.BigInteger;

public class HJB64 {

    // Array holding the 64 characters used in the Base64 encoding scheme.
    private char[] base64Chars = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    /**
     * Encodes a given string into its Base64 representation.
     *
     * @param str The input string to encode.
     * @return The Base64 encoded string.
     */
    public String encode(String str) {
        String bits = getBitsFromString(str);
        String[] shares = get6BitRepresentations(bits);
        String result = getResult(shares);

        return result;
    }

    /**
     * Converts an array of 6-bit binary strings to their corresponding Base64 characters
     * and concatenates them into the final Base64 encoded string.
     *
     * @param shares An array of 6-bit binary strings.
     * @return The concatenated Base64 encoded string.
     */
    private String getResult(String[] shares) {
        String result = "";
        int[] asciiValues = new int[shares.length];

        for (int i = 0; i < asciiValues.length; i++) {
            asciiValues[i] = Integer.parseInt(new BigInteger(shares[i], 2).toString());
            result += base64Chars[asciiValues[i]];
        }

        return result;
    }

    /**
     * Splits the binary representation of the input string into 6-bit segments.
     *
     * @param bits A string representing the binary form of the original input string.
     * @return An array of 6-bit binary strings.
     */
    private String[] get6BitRepresentations(String bits) {
        String[] shares = new String[bits.length() / 6];

        for (int i = 0; i < shares.length; i++) {
            shares[i] = bits.substring(6 * i, (6 * i) + 6);
        }

        return shares;
    }

    /**
     * Converts the input string into a binary string, with each character represented by an 8-bit binary number.
     * It pads the result to ensure the length of the binary string is a multiple of 6 bits.
     *
     * @param str The input string to convert.
     * @return A binary string representation of the input, padded to a multiple of 6 bits in length.
     */
    private String getBitsFromString(String str) {
        int ch;
        BigInteger bigInt;
        String binary;
        String bits = "";

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            bigInt = new BigInteger("" + ch);
            binary = bigInt.toString(2);
            while (binary.length() < 8) {
                binary = "0" + binary;
            }
            bits += binary;
        }
        while (bits.length() % 6 != 0) {
            bits += "0";
        }

        return bits;
    }

    public static void main(String[] args) {
        HJB64 base64 = new HJB64();
        String str = "Kry";

        System.out.println(base64.encode(str));
    }

}
