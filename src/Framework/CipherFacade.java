package Framework;

public class CipherFacade {
    private final VigenereCipher vigenereCipher;
    private final HillCipher hillCipher;
    private final CaesarCipher caesarCipher;
    private final Base64 base64;

    public CipherFacade() {
        this.vigenereCipher = new VigenereCipher();
        this.hillCipher = new HillCipher();
        this.caesarCipher = new CaesarCipher();
        this.base64 = new Base64();
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

    public String encodeWithCaesar(String input, Integer key) {
        return caesarCipher.encode(input, key);
    }

    public String decodeWithCaesar(String input, Integer key) {
        return caesarCipher.decode(input, key);
    }

    public String encodeWithBase64(String input) {
        return base64.encode(input);
    }

}
