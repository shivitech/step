import java.util.Arrays;

class Player implements Comparable<Player> {
    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Established players: experience alone is enough
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Everyone else: some experience AND not injured
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    boolean isDraftable() {
        return isDraftable(matchesPlayed) || isDraftable(matchesPlayed, injured);
    }

    // Descending by batting average
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    String getName() { return name; }
}

public class AutoDraftRankingEngine {

    static String draftAndRank(Player[] players) {
        int count = 0;
        for (Player p : players) if (p.isDraftable()) count++;

        Player[] draftable = new Player[count];
        int k = 0;
        for (Player p : players) if (p.isDraftable()) draftable[k++] = p;

        Arrays.sort(draftable);   // uses compareTo

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(draftable[i].getName());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));  // 1. Rahul | 2. Virat | 3. Dev
    }
}