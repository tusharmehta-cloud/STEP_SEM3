
package WEEK_01.HOME_PROBLEM;

import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < totalCharacters; i++) {

            if (i < typed.length()
                    && original.charAt(i) == typed.charAt(i)) {

                matchedCharacters++;

            } else if (firstMismatchPosition == -1) {

                firstMismatchPosition = i + 1;
            }
        }

        if (typed.length() > original.length()
                && firstMismatchPosition == -1) {

            firstMismatchPosition = original.length() + 1;
        }

        double accuracy = ((double) matchedCharacters
                / totalCharacters) * 100;

        System.out.println("Matched: " + matchedCharacters
                + "/" + totalCharacters);

        System.out.printf("Accuracy: %.2f%%%n", accuracy);

        if (firstMismatchPosition == -1
                && typed.length() == original.length()) {

            System.out.println("No Mismatches");

        } else {

            System.out.println(
                    "First Mismatch at position: "
                            + firstMismatchPosition);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}