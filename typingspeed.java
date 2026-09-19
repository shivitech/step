import java.util.Scanner;

public class typingspeed {

    // Compares original and typed strings character by character
    static void checkTypingAccuracy(String original, String typed) {
        int length = original.length();
        int matchedCount = 0;
        int firstMismatchPosition = -1;
        char originalChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCount++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i;
                originalChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matchedCount / length) * 100;

        StringBuilder result = new StringBuilder();
        result.append("Matched: ").append(matchedCount).append("/").append(length);
        result.append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");

        if (firstMismatchPosition == -1) {
            result.append(" | No Mismatches");
        } else {
            // Position is reported as 1-based to match the sample output
            result.append(" | First Mismatch at position ").append(firstMismatchPosition + 1);
            result.append(" ('").append(originalChar).append("' vs '").append(typedChar).append("')");
        }

        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        if (original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length.");
        } else {
            checkTypingAccuracy(original, typed);
        }

        sc.close();
    }
}