import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {

    // Counts contiguous subarrays whose sum equals exactly k, using prefix sums + hash map
    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        // Base case: an empty prefix (sum 0) occurs once, before we've read any elements.
        // This lets subarrays starting at index 0 be counted correctly.
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            // If (currentSum - k) has been seen before as a prefix sum,
            // then the subarray between that point and here sums to exactly k.
            int needed = currentSum - k;
            if (prefixSumCount.containsKey(needed)) {
                count += prefixSumCount.get(needed);
            }

            // Record this prefix sum's occurrence
            if (prefixSumCount.containsKey(currentSum)) {
                prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) + 1);
            } else {
                prefixSumCount.put(currentSum, 1);
            }
        }

        return count;
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

        System.out.print("Enter k: ");
        int k = Integer.parseInt(sc.nextLine().trim());

        int result = subarraySum(nums, k);
        System.out.println(result);

        sc.close();
    }
}