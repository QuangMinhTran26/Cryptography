package Vigenere;

import java.util.HashMap;

public class KeyFinder {
    //TODO: every character at index i, i + keyLength has to packed into one element of divider array
    public String keyDetermination(String input, int keyLength) {
        String result = "";
        char[] inputArr = input.toCharArray();
        String[] divider = new String[input.length() / keyLength];
        for (int i = 0; i < input.length(); i++) {
            divider[i] += inputArr[i % keyLength];
        }
        return result;
    }

    //TODO: find the most frequent character through its value
    public char charFreqAnalysis(String input) {
        HashMap<Character, Double> freqTable = new HashMap<>();
        for (char c : input.toCharArray()) {
            freqTable.put(c, freqTable.getOrDefault(c, 0.0) + 1);
        }
        char mostFreq = '0';
        double count = 0;


        return mostFreq;
    }

    public void getKeyByValue(HashMap<Character, Double> freqTable) {

    }
}
