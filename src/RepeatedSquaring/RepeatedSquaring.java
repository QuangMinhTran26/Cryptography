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
            result[i] = Character.getNumericValue(input.charAt(i));
//          result[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return result;
    }

    public double repeatedSquaring(double a, double b, double m) {
        String binaryRep = intToBinary((int) b);
        double[] binaryArray = stringToIntArray(binaryRep);
        double result = 1;
        for (int i = 0; i < binaryArray.length; i++) {
            result = result * result * Math.pow(a, binaryArray[i]);
            result = result % m;
        }
        return result;
    }

//    public static void main(String[] args) {
//        RepeatedSquaring testObject = new RepeatedSquaring();
//        System.out.print(testObject.repeatedSquaring(700, 12341, 12341));
//    }
}