package TestType;

public class DecimalToBinary {

    public static String intToBinary(int num) {
        StringBuilder s = new StringBuilder();
        while (num > 0) {
            s.append(num % 2);
            num = num / 2;
        }

        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.print(intToBinary(413546843));
    }
}
