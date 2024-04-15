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

    @Test
    void decryption_LowercaseInputAndKey() {
        VigenereCipher cipher = new VigenereCipher("jbenme", "abcde");
        String generatedKey = cipher.keyGeneration();
        String decryption = cipher.decode(cipher.getInput(), generatedKey);
        assertEquals("JACKIE", decryption);
    }

    @Test
    void decryption_UppercaseInputAndKey() {
        VigenereCipher cipher = new VigenereCipher("LXFOPVEFRNHR", "LEMON");
        String generatedKey = cipher.keyGeneration();
        String decryption = cipher.decode(cipher.getInput(), generatedKey);
        assertEquals("ATTACKATDAWN", decryption);
    }

    @Test
    void decryption_LowercaseKey(){
        VigenereCipher cipher = new VigenereCipher("WTAALMLKHNZ", "orange");
        String generatedKey = cipher.keyGeneration();
        String decryption = cipher.decode(cipher.getInput(), generatedKey);
        assertEquals("ICANFIXTHAT", decryption);
    }

    @Test
    void decryption_LowercaseInput(){
        VigenereCipher cipher = new VigenereCipher("vfthogriesim", "HELLOTHERE");
        String generatedKey = cipher.keyGeneration();
        String decryption = cipher.decode(cipher.getInput(), generatedKey);
        assertEquals("OBIWANKENOBI", decryption);
    }
}