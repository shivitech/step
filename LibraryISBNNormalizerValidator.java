import java.util.Scanner;

public class LibraryISBNNormalizerValidator {

    // Trims spaces and uppercases only the first 3 characters
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed;
        }

        String publisherPart = trimmed.substring(0, 3).toUpperCase();
        String restPart = trimmed.substring(3);

        return publisherPart + restPart;
    }

    // Validates the normalized code and builds a formatted display line, or returns an error reason
    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: length must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);
        String yearPart = code.substring(3, 7);
        String catalogPart = code.substring(7, 13);

        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = yearPart + catalogPart;
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining 10 characters must be digits";
            }
        }

        StringBuilder display = new StringBuilder();
        display.append("[").append(publisherCode).append("] ");
        display.append("YEAR: ").append(yearPart).append(" | ");
        display.append("CATALOG: ").append(catalogPart);

        return display.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter raw code: ");
        String raw = sc.nextLine();

        String normalized = normalizeCode(raw);
        String result = validateAndFormat(normalized);

        System.out.println(result);

        sc.close();
    }
}