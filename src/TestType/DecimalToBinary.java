package TestType;

public class DecimalToBinary {

    public static String intToBinary(int num) {
        StringBuilder lastDigitToFirst = new StringBuilder();
        while (num > 0) {
            lastDigitToFirst.append(num % 2);
            num = num / 2;
        }

        StringBuilder result = new StringBuilder();
        for (int i = lastDigitToFirst.length() - 1; i >= 0; i--) {
            result.append(lastDigitToFirst.charAt(i));
        }
        return result.toString();
    }

    // Integer.toBinaryString(): built-in, works really well

    public static void main(String[] args) {
        System.out.print(intToBinary(413546843));
    }
}
