import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {

    // Returns all unique triplets that sum to zero
    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[][] tempResults = new int[n * n][3]; // generous upper bound, trimmed at the end
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the first position to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    tempResults[count][0] = nums[i];
                    tempResults[count][1] = nums[left];
                    tempResults[count][2] = nums[right];
                    count++;

                    left++;
                    right--;

                    // Skip duplicates for the second position
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Skip duplicates for the third position
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        // Trim the result array to the actual number of triplets found
        int[][] result = new int[count][3];
        for (int i = 0; i < count; i++) {
            result[i] = tempResults[i];
        }

        return result;
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

        int[][] triplets = threeSum(nums);

        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i < triplets.length; i++) {
            output.append("[").append(triplets[i][0]).append(", ")
                  .append(triplets[i][1]).append(", ")
                  .append(triplets[i][2]).append("]");
            if (i < triplets.length - 1) {
                output.append(", ");
            }
        }
        output.append("]");

        System.out.println(output.toString());

        sc.close();
    }
}