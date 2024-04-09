package Vigenere;

public class VigenereCipher {
    private String input;
    private String key;

    public VigenereCipher(String input, String key) {
        this.input = input;
        this.key = key;
    }

    public String getInput() {
        return input;
    }

    private String printCharArray(char[] c) {
        StringBuilder s = new StringBuilder("");
        for (char element : c) {
            s.append(element);
        }
        return s.toString();
    }

    public String keyGeneration() {
        String result = "";
        char[] keystream = new char[input.length()];
        char[] keyToArr = key.toCharArray();

        if (input.length() == key.length()) {
            result = key;
        }
        if (input.length() < key.length()) {
            for (int i = 0; i < keystream.length; i++) {
                keystream[i] = keyToArr[i];
            }
            result = printCharArray(keystream);
        }
        if (input.length() > key.length()) {

            for (int i = 0; i < keystream.length; i++) {
                keystream[i] = keyToArr[i % key.length()];
            }

            result = printCharArray(keystream);
        }
        return result;
    }

    public String encode(String input, String key) {
        input = input.toUpperCase();
        key = key.toUpperCase();
        String encodedText = "";
        for (int i = 0; i < input.length(); i++) {
            // converting in range 0-25
            int x = (input.charAt(i) + key.charAt(i)) % 26;

            // convert into alphabets(ASCII)
            x += 'A';

            encodedText += (char) (x);
        }
        return encodedText;
    }

    public String decode(String input, String key) {
        input = input.toUpperCase();
        key = key.toUpperCase();
        String decodedText = "";
        for (int i = 0; i < input.length(); i++) {
            // converting in range 0-25
            int x = (input.charAt(i) - key.charAt(i) + 26) % 26;

            // convert into alphabets(ASCII)
            x += 'A';
            decodedText += (char) (x);
        }
        return decodedText;
    }

    public static void main(String[] args) {
        VigenereCipher cipher = new VigenereCipher("jackie", "abcde");
        String generatedKey = cipher.keyGeneration();
        String encryption = cipher.encode(cipher.getInput(), generatedKey);
        System.out.println(encryption);

        VigenereCipher decryptionEx = new VigenereCipher("johan", "mess");
        String generatedKey2 = decryptionEx.keyGeneration();
        String decryption = decryptionEx.decode(decryptionEx.getInput(), generatedKey2);
        System.out.println(decryption);
    }
}