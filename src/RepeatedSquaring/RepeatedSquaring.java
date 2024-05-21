package RepeatedSquaring;


public class RepeatedSquaring {
    public String intToBinary(int num) {
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

    public double[] stringToIntArray(String input) {
        double[] result = new double[input.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return result;
    }

    public double repeatedSquaring(double a, int b, double m) {
        String binary = intToBinary(b);
        double[] binaryArray = stringToIntArray(binary);
        double result = 1;
        for (int i = 0; i < binaryArray.length; i++) {
            double first = Math.pow(a, i);
            result = (Math.pow(first, 2) * Math.pow(a, binaryArray[i]));

        }
        return result % m;
    }

    public static void main(String[] args) {
        RepeatedSquaring testObject = new RepeatedSquaring();
        System.out.print(testObject.repeatedSquaring(7, 8, 853));
    }
}