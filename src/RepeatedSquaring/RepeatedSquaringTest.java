package RepeatedSquaring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatedSquaringTest {
    RepeatedSquaring testObject;

    @BeforeEach
    void setUp() {
        testObject = new RepeatedSquaring();
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


}