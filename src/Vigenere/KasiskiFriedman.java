package Vigenere;


import java.util.*;

public class KasiskiFriedman {

    public static void main(String[] args) {
        String ciphertext = "LWFCOSYJYWTWHRYKUGKLHLLOMGMXLPYNABVJJLAWTCVGALUTQBUXLQUKOVZCLRBSNSETPRYPMFDTLEOXSSJILPFLGBULHIBJQBUXJLBAQFJEYIWZQBRTOILLEWTWKMYKQOIBLIOFESITYBMLMRKVSEOTFAZGDIHFUQYTBGBKMUVLPVBSNSETPRYOUFBAPGBKOVNTYITWUHMDYYHKMPVGEAYFZKZGKELSGTMDYFYJQWKTAWYAZKFASIHXPOECTYYKESELPVTMQFJIBRMWDSRCNWNVMJFGEEVDQUVCPGBKFSYTOMYJVSKOAZIJQITWCSYDXWXPUKMLRFVXDMYKASKLHAYAXWTWHRYLIOJMNPUMNSLCKMBJZWTWARYAZWTWZXYZQVZTYSBFQOEVZXQWUZZROINOMGEXJLNNQFXTZWYFTOSTEMWZTOSTUMWZFJVGNIMKQBUPZWCUTBZROXBAQFSXUAYYQBUTZAYYQGUTYZIJYWIAPIALECESLVHPISXTUHYKISXTZHYJNSITPXMZUBKTYQCJXWVVAMWZTOSTUMWZFJVGNIMKQBUPZWQADPVGLMNKJGVXALOFPSIIQEBJQBXTNIHVUSJTTEMUTWETUOUWYDWTUMWZTOSTUMWZFJVGNIMKQBUPZWMAQLJTPXBMZRVGANUZDSEXOVYSDAVTUWWZUQBTUYGMZGQJGILKFCVGLROFPBRROICFQAAPOVBMZRVGABXWEYIXLKYKTOSTPGBFUQYICILYQGJTUAUKPOJLPGBLUUJILMMLIWIHPRXFAQYWPILDMGJIBRMPTSLILRUUTHUXLWYJMFDTLZIFTWVGHYMWUBVQVXMUTOWIZGBAOYVCSEMKFIEHOIOLQBRROXRVUSJTOSYZXSEOBQYJLWKILVHTDWEVLRBWGHVCHGBLISISLRQADRZTZIBSXZVCHYMWDRVMZXUZXIESZXYAZSIQLFYFXOJHLRMAQGFASIHMZGYDLVYFHCDGVXYFWSICIMMRGAJROAUJLSEMOMGEQZYTBXYFMQYIDILVQBNXYHUXGSIHVVAWZRRHZWCWZWVBHPMNQFXTZWYFPOJXZXTAABLCKBQADVRQLREWUBVPUKML";
        int sequenceLength = 8;

        double friedman = friedmanTest(ciphertext);
        System.out.println("Friedman: " + friedman);

        Map<String, List<Integer>> results = kasiskiTest(ciphertext, sequenceLength);

        // Output repeated sequences and their distances
        for (Map.Entry<String, List<Integer>> entry : results.entrySet()) {
            String sequence = entry.getKey();
            List<Integer> distances = entry.getValue();
            System.out.println("Sequence: " + sequence + ", Distances: " + distances);
        }

        int keyLength = determineKeyLength(results);
        System.out.println("Likely key length: " + keyLength);
    }

    public static double friedmanTest(String ciphertext) {
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

    public static Map<String, List<Integer>> kasiskiTest(String text, int sequenceLength) {
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

    private static Map<String, List<Integer>> getDistance(Map<String, List<Integer>> filteredResults) {
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
    public static int determineKeyLength(Map<String, List<Integer>> distances) {
        Set<Integer> gcds = new HashSet<>(); //Set will eliminate duplicates, only save unique values

        // Copy all the entries of the List<Integer> distances to my new Set
        for (List<Integer> list : distances.values()) {
            gcds.addAll(list);
        }
        // Find the most common divisor
        int[] setToArray = gcds.stream().mapToInt(i -> i).toArray();
        return findGCDArray(setToArray);
    }

    public static int findGCDArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        for (int num : nums) {
            result = gcd(result, num);
        }

        return result;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;

        // Recursive call with swapped parameters
        return gcd(b, a % b);
    }
}
