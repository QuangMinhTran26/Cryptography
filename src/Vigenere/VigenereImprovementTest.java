package Vigenere;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class VigenereImprovementTest {

    @Test
    void encryption() {
        VigenereImprovement cipher = new VigenereImprovement("attack at 454486465dawn", "LEM455643564365,-..-,-´#ON");
        assertEquals("LXFOPVEFRNHR", cipher.encode(cipher.getInput(), cipher.getKey()));
    }

    @Test
    void decryption() {
        VigenereImprovement cipher = new VigenereImprovement("AREALHUMANBEING", "bean          ");
        assertEquals("ZNENKDUZZJBRHJG", cipher.decode(cipher.getInput(), cipher.getKey()));
    }

}