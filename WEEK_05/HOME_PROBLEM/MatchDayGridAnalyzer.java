package WEEK_05.HOME_PROBLEM;

import java.util.Scanner;

public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {

        if (row.length == 0) {
            return 0;
        }

        int sum = 0;

        for (int runs : row) {
            sum += runs;
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(
            int[][] runsPerOver,
            int threshold) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {

            double average = rowAverage(runsPerOver[i]);

            String status;

            if (average >= threshold) {
                status = "Power Surge";
            } else {
                status = "Normal";
            }

            result.append("Match ")
                    .append(i)
                    .append(": ")
                    .append(status);

            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matches: ");
        int matches = sc.nextInt();

        int[][] runsPerOver = new int[matches][];

        for (int i = 0; i < matches; i++) {

            System.out.print(
                    "Enter number of overs for Match "
                            + i + ": "
            );

            int overs = sc.nextInt();

            runsPerOver[i] = new int[overs];

            System.out.println(
                    "Enter runs for Match " + i + ":"
            );

            for (int j = 0; j < overs; j++) {
                runsPerOver[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        String result = classifyMatches(
                runsPerOver,
                threshold
        );

        System.out.println(result);

        sc.close();
    }
}