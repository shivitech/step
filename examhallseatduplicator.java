import java.util.Scanner;

public class examhallseatduplicator {

    // Checks for duplicate seat numbers using nested loops only
    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        boolean[] alreadyReported = new boolean[seatNumbers.length]; // avoid repeating same duplicate value

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyReported[i]) {
                continue;
            }
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    alreadyReported[j] = true; // don't print this value again later
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of seats: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] seatNumbers = new int[n];
        System.out.println("Enter " + n + " seat numbers (space-separated or one per line):");

        // Support both space-separated on one line, or one-per-line entry
        String line = sc.nextLine().trim();
        String[] parts = line.split("\\s+");

        if (parts.length == n) {
            for (int i = 0; i < n; i++) {
                seatNumbers[i] = Integer.parseInt(parts[i]);
            }
        } else {
            // fallback: read one number per line, first entered value already used
            seatNumbers[0] = Integer.parseInt(parts[0]);
            for (int i = 1; i < n; i++) {
                seatNumbers[i] = Integer.parseInt(sc.nextLine().trim());
            }
        }

        checkDuplicateSeats(seatNumbers);

        sc.close();
    }
}