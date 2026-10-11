import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        k = k % n;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int newPosition = (i + k) % n;
            result[newPosition] = nums[i];
        }

        System.out.println("Rotated array:");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}