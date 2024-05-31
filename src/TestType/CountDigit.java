package TestType;

public class CountDigit {
    public static int countDigit(int n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }


}
