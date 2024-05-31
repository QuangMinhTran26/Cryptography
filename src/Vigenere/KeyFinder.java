package Vigenere;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KeyFinder {
    //TODO: every character at index i, i + keyLength has to packed into one element of divider array
    public String keyDetermination(String input, int keyLength) {
        String result = "";
        char[] inputArr = input.toCharArray();
        String[] divider = new String[input.length() / keyLength];
        for (int i = 0; i < input.length(); i++) {


        }
        return result;
    }


    public Character charFreqAnalysis(String input) {
        HashMap<Character, Double> freqTable = new HashMap<>();
        for (char c : input.toCharArray()) {
            freqTable.put(c, freqTable.getOrDefault(c, 0.0) + 1);
        }

        double highestValue = (Collections.max(freqTable.values()));
//      returns max value in the HashMap
        for (Map.Entry<Character, Double> entry : freqTable.entrySet()) {
            if (entry.getValue() == highestValue) {
                return entry.getKey();
            }
        }
        return null;
    }


}
