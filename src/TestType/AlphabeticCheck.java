package TestType;

public class AlphabeticCheck {
    private static void printArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        String s = "a dog";
        printArray(s.toCharArray());
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) {
                s = s.replace(s.charAt(i), ('x'));
            }
        }
        s = s.replaceAll("x", "").toUpperCase();
        System.out.println(s);
    }
}
