package TestTypeChar;

public class GCDArray {
    public static int findGCDArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        for (int num : nums) {
            result = gcd(result, num);
        }

        return result;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] numbers = {112, 80, 648};
        int gcd = findGCDArray(numbers);
        System.out.println(gcd);
    }
}