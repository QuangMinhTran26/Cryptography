package DES;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SBoxTest {
    SBox obj;

    @BeforeEach
    void setUp() {
        obj = new SBox();
    }

    @Test
    void sBoxCalculation_a() {
        assertEquals(2, obj.sBoxCalculation(100111, 1));
    }

    @Test
    void sBoxCalculation_b() {
        assertEquals(12, obj.sBoxCalculation(011001, 3));
    }

    @Test
    void sBoxCalculation_c() {
        assertEquals(15, obj.sBoxCalculation(110011, 5));
    }

    @Test
    void sBoxCalculation_d() {
        assertEquals(7, obj.sBoxCalculation(000111, 7));
    }

}