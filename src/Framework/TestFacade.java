package Framework;

public class TestFacade {
    public static void main(String[] args) {
        CipherFacade test = new CipherFacade();
        System.out.println(test.encodeWithVigenere("Power over spice is power over all", "ARRAKIS"));
        System.out.println(test.decodeWithVigenere("BFCGSRBTDOHROJSGAWZ", " drive "));
        int[][] key1 = {{7, 8}, {11, 11}};
        System.out.println(test.encodeWithHill("short example", key1));
        int[][] key2 = {{2, 3}, {3, 6}};
        System.out.println(test.decodeWithHill("FKMFIO", key2));
        System.out.println(test.encodeWithCaesar("caesar", 3));
        System.out.println(test.decodeWithCaesar("KHUHBHVZHUHJUHHQ", 3));
        System.out.println(test.encodeWithBase64("Kry"));
    }
}
