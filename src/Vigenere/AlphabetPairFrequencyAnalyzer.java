package Vigenere;

import java.util.HashMap;
import java.util.Map;

public class AlphabetPairFrequencyAnalyzer {
    public static void main(String[] args) {
        String text = "KFEKWIFHZBJRTUBOWRIMHBTUOOJAXIUBVNTFWYCWEDZFHJTCPVSORSZSANVNBFDLPNFKAYSIYOXPYWMWBLSOUJISWSLXEKQMMWTUZVUUGBZDHJNWWWQMKFXIQIQVTUDJEIHEXIZFYHTUZYFZXTKFCCZSPMNEFKAYSCDEXQFTTFVNVLHJKFWYCQCULTHJBYDDRXUQEEXOSKHGMWMWQJGYSXMOQWNNHENZFOLLNGAYKFCCZSNERZEIMWFHHPVSCPXIXACUCWNALIQXRDTSRDEKWAWGUUGBOTXPXZTUZQVSFOCOQGNNURTFZDTUHPHGEIFZTAXPVMJUHCKAFOWBIMHBFBVIRQLKOLWYQJKGKFJRUQHPVBZDUARQUKFUTCFUYOHSMWTURCUFHJRDFOWAHORGCUEKWQKFOTZJZARRXPTUQYSAMWSOCVYENBHJNWHBMQKFGYXVAGDGXTSOHBOYXIDWNNHBMQRGCVSZEICVCCQMWUKAVSZFHEMTKOSOSLTULKKVJRCOFBKFOYQZIUVNVJNNLXLXKIGXLXDMHKHCWWRMZQQYCVKFCCTSNZNAXCNQBEVSNUXTRDDZRGKNUQNNRJKGCCTUQGDEHCWWZDZDZXIKNCBFSDSMDEQCFOWBQYZXZVZBXPOIOTZJBIDJKGHBTULKLMBFIPWYGCNFZSCVCQJNEKGQXVYOXPEKWWBFPEUUWUKAWUKAZVBYSYHJKFWERRIJHHWYTSXFFYOSRHHJNNURBNIKYHTULKWRFBBGRKYENBYMZXFBHJNWMIRHXPEKWWMWKFEKXSCHXTLIIKCVXPNNEQKIDYCHFZHEOJXVSODVVJTUZQIMCUGQJRNWRQTUFOGBUQFHUUKFWYRGUMXTBFKFSOEDMKGUHPIONWHCHEZVZDSOFRHJVSFOFUKFZDYACMHGMWHPYOECNNQUFKBIVAQJKGKFEKWYMWTFFBZIXOPMLXVSPCRXMQMLKOOCNNHDPRRDFZWUKAVIRQBYQRBHXPDXRGHBUQWAMSZQTCGQWGQVTUHPPMHBBLZDPCMWZDRDTGBYEDHJKFEKUUCVKAGFHJNWCQTXWKXFVKOLEKDJRDFRHJNWISREOLNNGCJWNWVKZVRRVKMLVNHSWQKFKFPPXPQKRGYYUUHPJRTUHPPMHBKIUBTUTXOSQVHSZIANTBSODCTHCCMWEKOEHECVECGVHJNWVFMQRKGQXVNFQCGCSLFHRXZFDMHPUUCVTUZQMIZQKFRXWGUADLRUUUKFYMRMZQUOOSRHYMFBXSJUFUNXBRNH";

        Map<String, Integer> pairFrequency = analyzeSequenceFrequency(text, 2);

        System.out.println("Alphabet Pair Frequencies:");
        for (Map.Entry<String, Integer> entry : pairFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Integer> analyzeSequenceFrequency(String text, int sequenceLength) {
        Map<String, Integer> sequenceFrequency = new HashMap<>();


        text = text.toLowerCase().replaceAll("[^a-z]", "");


        if (text.length() < sequenceLength) {
            return sequenceFrequency;
        }

        for (int i = 0; i < text.length() - sequenceLength + 1; i++) {
            String sequence = text.substring(i, i + sequenceLength);
            sequenceFrequency.put(sequence, sequenceFrequency.getOrDefault(sequence, 0) + 1);
        }

        return sequenceFrequency;
    }
}