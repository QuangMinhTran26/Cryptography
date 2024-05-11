package Framework;


@SuppressWarnings("DuplicatedCode")
public class CaesarCipher implements Cipher<Integer> {
    public String alphabeticCheck(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isAlphabetic((input.charAt(i)))) {
                input = input.replace(input.charAt(i), '°'); // there is no empty character, so ° acts as a placeholder
            }
        }
        input = input.replaceAll("°", "").toUpperCase(); // can not be put in the loop
        return input;
    }

    public int step26(int num) {
        if (num < 0) {
            int result = num + 26;
            while (result < 0) {
                result += 26;
            }
            return result;
        } else return num;
    }

    @Override
    public String encode(String input, Integer key) {
        StringBuilder encodedText = new StringBuilder();
        input = alphabeticCheck(input);
        for (int i = 0; i < input.length(); i++) {
            encodedText.append((char) (step26(input.charAt(i) - 'A' + key) % 26 + 65));
        }
        return encodedText.toString();
    }

    @Override
    public String decode(String input, Integer key) {
        StringBuilder decodedText = new StringBuilder();
        input = alphabeticCheck(input);
        for (int i = 0; i < input.length(); i++) {
            decodedText.append((char) (step26(input.charAt(i) - 'A' - key) % 26 + 65));
        }
        return decodedText.toString();
    }
    // encode(input, 26 - key) Decoding is just encoding with the inverse key
}
