import java.util.Scanner;

public class sumthree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        System.out.println("Maximum Subarray Sum: " + maxSum);

        sc.close();
    }
}