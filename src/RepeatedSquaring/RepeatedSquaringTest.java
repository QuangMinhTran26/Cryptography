package RepeatedSquaring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatedSquaringTest {
    RepeatedSquaring testObject;
    RPKlausur testObject2;

    @BeforeEach
    void setUp() {
        testObject = new RepeatedSquaring();
        testObject2 = new RPKlausur();
    }

    @Test
    void repeatedSquaring_SuZ4_1b() {
        assertEquals(27, testObject.repeatedSquaring(27, 41, 77));
    }

    @Test
    void repeatedSquaring_SuZ4_1c() {
        assertEquals(53964, testObject.repeatedSquaring(504, 65535, 65537));
    }

    @Test
    void repeatedSquaring_SusanZehra1() {
        assertEquals(2, testObject.repeatedSquaring(240, 262, 14));
    }

    @Test
    void repeatedSquaring_SusanZehra2() {
        assertEquals(345, testObject.repeatedSquaring(2, 223, 353));
    }

    @Test
    void repeatedSquaring_SuZ5_1b() {
        assertEquals(27, testObject.repeatedSquaring(42, 37, 47));
    }

    @Test
    void repeatedSquaring_SuZ5_1c() {
        assertEquals(8693, testObject.repeatedSquaring(700, 12341, 12343));
    }

    @Test
    void repeatedSquaring_SuZ5_1cExtra() {
        assertEquals(3318, testObject.repeatedSquaring(700, 12341, 12341));
    }

    @Test
    void rpKlausur_SuZ4_1b() {
        assertEquals(27, testObject2.repeatedSquaring(27, 41, 77));
    }

    @Test
    void rpKlausur_SuZ4_1c() {
        assertEquals(53964, testObject2.repeatedSquaring(504, 65535, 65537));
    }

    @Test
    void rpKlausur_SusanZehra1() {
        assertEquals(2, testObject2.repeatedSquaring(240, 262, 14));
    }

    @Test
    void rpKlausur_SusanZehra2() {
        assertEquals(345, testObject2.repeatedSquaring(2, 223, 353));
    }

    @Test
    void rpKlausur_SuZ5_1b() {
        assertEquals(27, testObject2.repeatedSquaring(42, 37, 47));
    }

    @Test
    void rpKlausur_SuZ5_1c() {
        assertEquals(8693, testObject2.repeatedSquaring(700, 12341, 12343));
    }

    @Test
    void rpKlausur_SuZ5_1cExtra() {
        assertEquals(3318, testObject2.repeatedSquaring(700, 12341, 12341));
    }

}