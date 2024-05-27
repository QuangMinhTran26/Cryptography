package RepeatedSquaring;

public class RPKlausur {
    public double repeatedSquaring(double a, double b, double m) {
        String biExponent = Integer.toBinaryString((int) b);
        double[] biArray = new double[biExponent.length()];
        for (int i = 0; i < biArray.length; i++) {
            biArray[i] = Character.getNumericValue(biExponent.charAt(i));
        }
        double result = 1;
        for (int i = 0; i < biArray.length; i++) {
            result = result * result * Math.pow(a, biArray[i]);
            result = result % m;
        }
        return result;
    }
}
