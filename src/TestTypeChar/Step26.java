package TestTypeChar;

public class Step26 {
    public static int step26(int num) {
        if (num >= 0)
            return num;
        int result = num + 26;
        while (result < 0) {
            result += 26;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(step26(300));
    }
}
