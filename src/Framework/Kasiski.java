package Framework;

import java.util.*;

public class Kasiski implements KeyLengthInterface<Map<String, List<Integer>>> {

    public Map<String, List<Integer>> kasiskiTest(String text, int sequenceLength) {
        Map<String, List<Integer>> results = new HashMap<>();

        for (int i = 0; i < text.length() - sequenceLength + 1; i++) {
            String sequence = text.substring(i, i + sequenceLength);
            if (!results.containsKey(sequence)) {
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                results.put(sequence, positions);
            } else {
                results.get(sequence).add(i);
            }
        }

        // Filter out sequences with only one occurrence
        Map<String, List<Integer>> filteredResults = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : results.entrySet()) {
            if (entry.getValue().size() > 1) {
                filteredResults.put(entry.getKey(), entry.getValue());
            }
        }

        // Calculate distances between occurrences
        return getDistance(filteredResults);
    }

    private Map<String, List<Integer>> getDistance(Map<String, List<Integer>> filteredResults) {
        Map<String, List<Integer>> distances = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : filteredResults.entrySet()) {
            String sequence = entry.getKey();
            List<Integer> positions = entry.getValue();
            List<Integer> distanceList = new ArrayList<>();
            for (int j = 1; j < positions.size(); j++) {
                int distance = positions.get(j) - positions.get(j - 1);
                distanceList.add(distance);
            }
            distances.put(sequence, distanceList);
        }
        return distances;
    }

    // works best with sequence length >= 5
    @Override
    public double determineKeyLength(Map<String, List<Integer>> distances) {
        Set<Integer> gcds = new HashSet<>(); //Set will eliminate duplicates, only save unique values

        // Copy all the entries of the List<Integer> distances to my new Set
        for (List<Integer> list : distances.values()) {
            gcds.addAll(list);
        }
        // Find the most common divisor
        int[] setToArray = gcds.stream().mapToInt(i -> i).toArray();
        return findGCDArray(setToArray);
    }

    public int findGCDArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        for (int num : nums) {
            result = gcd(result, num);
        }

        return result;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;

        // Recursive call with swapped parameters
        return gcd(b, a % b);
    }


}
