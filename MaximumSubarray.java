import java.util.Scanner;

public class MaximumSubarray {

    // Finds the maximum sum of any contiguous subarray using Kadane's algorithm
    static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // At each element, decide: extend the current subarray or start fresh here
            if (currentSum + nums[i] > nums[i]) {
                currentSum = currentSum + nums[i];
            } else {
                currentSum = nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers (space-separated):");
        String[] parts = sc.nextLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        int result = maxSubArray(nums);
        System.out.println(result);

        sc.close();
    }
}
