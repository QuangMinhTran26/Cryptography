package Framework;

public interface Cipher<K> {
    String encode(String input, K key);

    String decode(String input, K key);
}
