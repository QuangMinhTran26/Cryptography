package TestType;

import java.util.HashMap;
import java.util.Map;

public class IterateHashMap {
    public void createAndIterate(String input) {
        HashMap<Character, Double> freqTable = new HashMap<>();
        for (char c : input.toCharArray()) {
            freqTable.put(c, freqTable.getOrDefault(c, 0.0) + 1);
        }
        for (Map.Entry<Character, Double> entry : freqTable.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue());
            System.out.println();
        }
    }
}