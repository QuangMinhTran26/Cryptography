package TestType;

public class Example {

    public static void main(String[] args) {
        int x = 10;
        int inputBit = 0b011101;
        String inputBitBinary = Integer.toBinaryString(inputBit);
        int test1 = Integer.parseInt("110011", 16);

        System.out.println("int value + char type: " + x + 'A');
        System.out.println("use cast for int value + char type: " + (char) (x + 'A'));
        System.out.println(inputBitBinary);
        System.out.println(test1);
    }
}
