package Base64;

public class MB64 {
    private char[] base64 = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    public String encode(String input) {
        String bits = stringToBinary(input);
        String[] from8To6Bits = get6Bits(bits);

        return b64Result(from8To6Bits);
    }

    public String b64Result(String[] arrayOf6Bits) {
        StringBuilder result = new StringBuilder();
        int[] decimal = new int[arrayOf6Bits.length];
        for (int i = 0; i < decimal.length; i++) {
            decimal[i] = Integer.parseInt(arrayOf6Bits[i], 2);
            result.append(base64[decimal[i]]);
        }

        return result.toString();
    }

    public String[] get6Bits(String binary) {
        String[] arrayOf6Bits = new String[(binary.length() / 6)];

        for (int i = 0; i < arrayOf6Bits.length; i++) {
            arrayOf6Bits[i] = binary.substring(6 * i, (6 * i) + 6); //substring: take head index, tail index - 1 check ex
        }
        return arrayOf6Bits;
    }

    public static String stringToBinary(String input) {
        StringBuilder binary = new StringBuilder();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            binary.append(
                    String.format("%8s", Integer.toBinaryString(charArray[i])) //transform argument into a string. If result < 8 letters wide -> will be padded to 8
                            .replaceAll(" ", "0")
            );
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        MB64 base64 = new MB64();
        String str = "Kry";

        System.out.println(base64.encode(str));
    }
}
