package Base64;
import java.util.Base64;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class B64 {
    public static void main(String[] args) {
        String originalInput = "Krypto";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println("Krypto's encryption with Base64 is: "+ encodedString);

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Krypto's decryption with Base64 is: "+ decodedString);
    }
}