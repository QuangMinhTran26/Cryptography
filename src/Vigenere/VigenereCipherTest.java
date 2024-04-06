package Vigenere;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VigenereCipherTest {

    @Test
    void encryption_LowercaseInputAndKey() {
        VigenereCipher cipher = new VigenereCipher("jackie", "abcde");
        String generatedKey = cipher.keyGeneration();
        String encryption = cipher.encode(cipher.getInput(), generatedKey);
        assertEquals("JBENME", encryption);
    }

    @Test
    void encryption_UppercaseInputAndKey() {
        VigenereCipher cipher = new VigenereCipher("ATTACKATDAWN", "LEMON");
        String generatedKey = cipher.keyGeneration();
        String encryption = cipher.encode(cipher.getInput(), generatedKey);
        assertEquals("LXFOPVEFRNHR", encryption);
    }

    @Test
    void encryption_LowercaseKey(){
        VigenereCipher cipher = new VigenereCipher("ICANFIXTHAT", "orange");
        String generatedKey = cipher.keyGeneration();
        String encryption = cipher.encode(cipher.getInput(), generatedKey);
        assertEquals("WTAALMLKHNZ", encryption);
    }

    @Test
    void encryption_LowercaseInput(){
        VigenereCipher cipher = new VigenereCipher("obiwankenobi", "HELLOTHERE");
        String generatedKey = cipher.keyGeneration();
        String encryption = cipher.encode(cipher.getInput(), generatedKey);
        assertEquals("VFTHOGRIESIM", encryption);
    }
}