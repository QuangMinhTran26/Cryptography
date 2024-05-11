package Framework;

public class CipherFacade {
    private final VigenereCipher vigenereCipher;
    private final HillCipher hillCipher;

    public CipherFacade() {
        this.vigenereCipher = new VigenereCipher();
        this.hillCipher = new HillCipher();
    }

    public String encodeWithVigenere(String input, String key) {
        return vigenereCipher.encode(input, key);
    }

    public String decodeWithVigenere(String input, String key) {
        return vigenereCipher.decode(input, key);
    }

    public String encodeWithHill(String input, int[][] key) {
        return hillCipher.encode(input, key);
    }

    public String decodeWithHill(String input, int[][] key) {
        return hillCipher.decode(input, key);
    }
}
