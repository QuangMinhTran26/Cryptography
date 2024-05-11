package Framework;

@SuppressWarnings("DuplicatedCode")
public class VigenereCipher implements Cipher<String> {

    public String alphabeticCheck(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isAlphabetic((input.charAt(i)))) {
                input = input.replace(input.charAt(i), '°'); // there is no empty character, so ° acts as a placeholder
            }
        }
        input = input.replaceAll("°", "").toUpperCase(); // can not be put in the loop
        return input;
    }

    @Override
    public String encode(String input, String key) {
        StringBuilder encodedText = new StringBuilder();
        input = alphabeticCheck(input);
        key = alphabeticCheck(key);
        for (int i = 0; i < input.length(); i++) {
            encodedText.append((char) ((input.charAt(i) + key.charAt(i % key.length())) % 26 + 65));
        }
        return encodedText.toString();
    }

    @Override
    public String decode(String input, String key) {
        StringBuilder decodedText = new StringBuilder();
        input = alphabeticCheck(input);
        key = alphabeticCheck(key);
        for (int i = 0; i < input.length(); i++) {
            decodedText.append((char) ((input.charAt(i) - key.charAt(i % key.length()) + 26) % 26 + 65));
        }
        return decodedText.toString();
    }

}
