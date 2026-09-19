import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StopWordFilteredWordFrequencyReport {

    // Cleans text, filters stop words, counts frequency, and prints sorted by count descending
    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(",", "");
        cleaned = cleaned.replace(".", "");

        String[] words = cleaned.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            boolean isStopWord = false;
            for (int j = 0; j < stopWords.length; j++) {
                if (word.equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            if (isStopWord || word.isEmpty()) {
                continue;
            }

            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        // Simple selection-style sort by count descending, no extra Collections utilities
        String[] uniqueWords = frequency.keySet().toArray(new String[0]);

        for (int i = 0; i < uniqueWords.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < uniqueWords.length; j++) {
                if (frequency.get(uniqueWords[j]) > frequency.get(uniqueWords[maxIndex])) {
                    maxIndex = j;
                }
            }
            String temp = uniqueWords[i];
            uniqueWords[i] = uniqueWords[maxIndex];
            uniqueWords[maxIndex] = temp;
        }

        for (int i = 0; i < uniqueWords.length; i++) {
            System.out.println(uniqueWords[i] + ": " + frequency.get(uniqueWords[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback paragraph: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}