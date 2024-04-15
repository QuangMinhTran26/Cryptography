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

    public String keyGeneration() {
        String result;
        char[] keystream = new char[input.length()];
        char[] keyToArr = key.toCharArray();

        if (input.length() < key.length()) {
            for (int i = 0; i < keystream.length; i++) {
                keystream[i] = keyToArr[i];
            }
            result = new String(keystream);
        } else if (input.length() > key.length()) {
            for (int i = 0; i < keystream.length; i++) {
                keystream[i] = keyToArr[i % key.length()];
            }
            result = new String(keystream);
        } else result = key;

        return result;
    }

    public String encode(String input, String key) {
        input = input.toUpperCase();
        key = key.toUpperCase();
        StringBuilder encodedText = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            // converting in range 0-25
            int x = (input.charAt(i) + key.charAt(i)) % 26;

            // convert into alphabets(ASCII)
            x += 'A';

            encodedText.append((char) (x));
        }
        return encodedText.toString();
    }

    public String decode(String input, String key) {
        input = input.toUpperCase();
        key = key.toUpperCase();
        StringBuilder decodedText = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            // converting in range 0-25
            int x = (input.charAt(i) - key.charAt(i) + 26) % 26;

            // convert into alphabets(ASCII)
            x += 'A';
            decodedText.append((char) (x));
        }
        return decodedText.toString();
    }

}