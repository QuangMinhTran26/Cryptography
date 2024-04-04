package Vigenere;

public class LengthStabilize {
    private String input;
    private String key;

    public LengthStabilize(String input, String key) {
        this.input = input;
        this.key = key;
    }

    private String converter(char[] c) {
        String s = " ";
        for (char element : c) {
            s += element;
        }
        return s;
    }

    private String stabilization() {
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
            result = converter(keystream);
        }

        if (input.length() > key.length()) {
            for (int i = 0; i < key.length(); i++) {
                keystream[i] = keyToArr[i];
            }
            for (int i = key.length(); i < keystream.length; i++) {
                keystream[i] = keyToArr[i - key.length()];
            }
            result = converter(keystream);
        }


        return result;

//        IntelliJ Suggestion
//        if (input.length() < key.length()) {
//            System.arraycopy(keyToArr, 0, keystream, 0, keystream.length);
//            result = converter(keystream);
//        }
//
//        if (input.length() > key.length()) {
//            System.arraycopy(keyToArr, 0, keystream, 0, key.length());
//            if (keystream.length - key.length() >= 0)
//                System.arraycopy(keyToArr, key.length() - key.length(), keystream, key.length(), keystream.length - key.length());
//            result = converter(keystream);
//        }
//


    }


    public static void main(String[] args) {
        LengthStabilize testObj = new LengthStabilize("Jack", "abcde");
        System.out.print(testObj.stabilization());
    }
}
