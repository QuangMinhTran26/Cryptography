package Vigenere;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KeyFinder {
    //TODO: every character at index i, i + keyLength has to packed into one element of divider array
    public String[] group(String input, int keyLength) {
        String[] groupedChars = new String[keyLength];

        for (int i = 0; i < keyLength; i++) {
            StringBuilder group = new StringBuilder();
            for (int j = i; j < input.length(); j = j + keyLength) {
                group.append(input.charAt(j));
            }
            groupedChars[i] = group.toString();
        }
        return groupedChars;
    }

    //Vigenere decryption knowing the most common letter is 'E'
    public String decrypt(String input) {
        StringBuilder decodedText = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            decodedText.append((char) ((input.charAt(i) - 'E' + 26) % 26 + 65));
        }
        return decodedText.toString();

    }

    public String keyDetermination(String input, int keyLength) {
        String[] groupEveryNthCharacter = group(input, keyLength);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < groupEveryNthCharacter.length; i++) {
            result.append(charFreqAnalysis(groupEveryNthCharacter[i]));
        }
        return decrypt((result.toString()));
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

    public static void main(String[] args) {
        KeyFinder test = new KeyFinder();
        String cipherText = "LWFCOSYJYWTWHRYKUGKLHLLOMGMXLPYNABVJJLAWTCVGALUTQBUXLQUKOVZCLRBSNSETPRYPMFDTLEOXSSJILPFLGBULHIBJQBUXJLBAQFJEYIWZQBRTOILLEWTWKMYKQOIBLIOFESITYBMLMRKVSEOTFAZGDIHFUQYTBGBKMUVLPVBSNSETPRYOUFBAPGBKOVNTYITWUHMDYYHKMPVGEAYFZKZGKELSGTMDYFYJQWKTAWYAZKFASIHXPOECTYYKESELPVTMQFJIBRMWDSRCNWNVMJFGEEVDQUVCPGBKFSYTOMYJVSKOAZIJQITWCSYDXWXPUKMLRFVXDMYKASKLHAYAXWTWHRYLIOJMNPUMNSLCKMBJZWTWARYAZWTWZXYZQVZTYSBFQOEVZXQWUZZROINOMGEXJLNNQFXTZWYFTOSTEMWZTOSTUMWZFJVGNIMKQBUPZWCUTBZROXBAQFSXUAYYQBUTZAYYQGUTYZIJYWIAPIALECESLVHPISXTUHYKISXTZHYJNSITPXMZUBKTYQCJXWVVAMWZTOSTUMWZFJVGNIMKQBUPZWQADPVGLMNKJGVXALOFPSIIQEBJQBXTNIHVUSJTTEMUTWETUOUWYDWTUMWZTOSTUMWZFJVGNIMKQBUPZWMAQLJTPXBMZRVGANUZDSEXOVYSDAVTUWWZUQBTUYGMZGQJGILKFCVGLROFPBRROICFQAAPOVBMZRVGABXWEYIXLKYKTOSTPGBFUQYICILYQGJTUAUKPOJLPGBLUUJILMMLIWIHPRXFAQYWPILDMGJIBRMPTSLILRUUTHUXLWYJMFDTLZIFTWVGHYMWUBVQVXMUTOWIZGBAOYVCSEMKFIEHOIOLQBRROXRVUSJTOSYZXSEOBQYJLWKILVHTDWEVLRBWGHVCHGBLISISLRQADRZTZIBSXZVCHYMWDRVMZXUZXIESZXYAZSIQLFYFXOJHLRMAQGFASIHMZGYDLVYFHCDGVXYFWSICIMMRGAJROAUJLSEMOMGEQZYTBXYFMQYIDILVQBNXYHUXGSIHVVAWZRRHZWCWZWVBHPMNQFXTZWYFPOJXZXTAABLCKBQADVRQLREWUBVPUKML";
        System.out.print(test.keyDetermination(cipherText, 8));

    }

}
