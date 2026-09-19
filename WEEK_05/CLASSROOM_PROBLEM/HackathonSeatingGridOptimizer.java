package WEEK_05.CLASSROOM_PROBLEM;

import java.util.Scanner;

public class HackathonSeatingGridOptimizer {

    private static double rowAverage(int[] row) {

        if (row.length == 0) {
            return 0;
        }

        int sum = 0;

        for (int score : row) {
            sum += score;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {

            double average = rowAverage(seatingScores[i]);

            String zone;

            if (average < threshold) {
                zone = "Quiet Zone";
            } else {
                zone = "Buzzing Zone";
            }

            result.append("Row ")
                  .append(i)
                  .append(": ")
                  .append(zone);

            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        int[][] seatingScores = new int[rows][];

        for (int i = 0; i < rows; i++) {

            System.out.print("Enter number of scores in row "
                    + i + ": ");

            int columns = sc.nextInt();

            seatingScores[i] = new int[columns];

            System.out.println("Enter scores for row " + i + ":");

            for (int j = 0; j < columns; j++) {
                seatingScores[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        String result = classifyRows(seatingScores, threshold);

        System.out.println(result);

        sc.close();
    }
}