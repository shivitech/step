import java.util.Scanner;

public class ProductOfArrayExceptSelf {

    // Returns an array where answer[i] = product of all elements except nums[i]
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // First pass: fill answer[i] with the product of everything to the LEFT of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Second pass: multiply in the product of everything to the RIGHT of i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
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

        int[] result = productExceptSelf(nums);

        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i < result.length; i++) {
            output.append(result[i]);
            if (i < result.length - 1) {
                output.append(", ");
            }
        }
        output.append("]");

        System.out.println(output.toString());

        sc.close();
    }
}