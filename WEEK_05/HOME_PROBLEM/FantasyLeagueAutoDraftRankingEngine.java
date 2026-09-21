package WEEK_05.HOME_PROBLEM;

import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(
                String name,
                int matchesPlayed,
                double battingAverage,
                boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(
                int matchesPlayed,
                boolean injured) {

            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {

            return Double.compare(
                    other.battingAverage,
                    this.battingAverage
            );
        }

        public String getName() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (Player player : players) {

            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(
                            player.matchesPlayed,
                            player.injured)) {

                draftable[count++] = player;
            }
        }

        Player[] finalList = Arrays.copyOf(draftable, count);

        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < finalList.length; i++) {

            result.append(i + 1)
                    .append(". ")
                    .append(finalList[i].getName());

            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }

        if (finalList.length == 0) {
            return "No Players Draftable";
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPlayer " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is player injured? (true/false): ");
            boolean injured = sc.nextBoolean();

            sc.nextLine();

            players[i] = new Player(
                    name,
                    matchesPlayed,
                    battingAverage,
                    injured
            );
        }

        String result = draftAndRank(players);

        System.out.println("\nDraftable Players:");
        System.out.println(result);

        sc.close();
    }
}