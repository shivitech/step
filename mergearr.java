import java.util.Scanner;

public class mergearr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();

        int[] arr1 = new int[n];

        System.out.println("Enter first sorted array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();

        int[] arr2 = new int[m];

        System.out.println("Enter second sorted array:");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < m) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        System.out.println("Merged array:");
        for (int x = 0; x < result.length; x++) {
            System.out.print(result[x] + " ");
        }

        sc.close();
    }
}