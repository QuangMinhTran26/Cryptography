package Hill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HillCipherTest {

    @Test
    void hillEncoding() throws IllegalAccessException {
        HillCipher testObject = new HillCipher();
        char[][] key = {{'H', 'I'}, {'L', 'L'}};
        assertEquals("APADJTFTWLFJ", testObject.hillEncoder("short example", key));
    }
}

