
package WEEK_02.HOME_PROBLEM;

import java.util.*;

public class StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        feedback = feedback.toLowerCase();

        feedback = feedback.replace(".", "")
                           .replace(",", "");

        String[] words = feedback.split("\\s+");

        Set<String> stopWords = new HashSet<>(Arrays.asList(
                "the", "was", "and", "a", "is", "of", "in"
        ));

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word) || word.isEmpty()) {
                continue;
            }

            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort((entry1, entry2) ->
                entry2.getValue() - entry1.getValue()
        );

        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(entry.getKey() + ": "
                    + entry.getValue());
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