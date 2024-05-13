package Framework;

import java.util.HashMap;
import java.util.Map;

public class Friedman implements keyLengthInterface<String> {

    @Override
    public double determineKeyLength(String ciphertext) {
        int n = ciphertext.length();
        Map<Character, Double> frequencies = new HashMap<>();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                frequencies.put(c, frequencies.getOrDefault(c, 0.0) + 1);
            }
        }

        double ic = 0;
        for (double freq : frequencies.values()) {
            ic += (freq * (freq - 1)) / (n * (n - 1));
        }

        return (0.0377 * n) / ((n - 1) * ic - 0.0385 * n + 0.0762);
    }

}