package TestType;

public class InverseElement {
    public static int multiplicativeInverse(int num, int mod) {
        int mInverse = 1;
        while ((mInverse * num) % mod != 1) {
            mInverse++;
        }
        return mInverse;
    }

    public static void main(String[] args) {
        System.out.println(multiplicativeInverse(93, 23));
        System.out.println(multiplicativeInverse(17, 29));
    }

}
