package WEEK_08.CLASSROOM_PROBLEM;

import java.util.Scanner;

public class ExaminationQuestionGrader {

    static abstract class Question {

        String correctAnswer;
        String studentAnswer;
        double points;

        Question(String correctAnswer,
                 String studentAnswer,
                 double points) {

            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double grade();

        abstract String getType();
    }

    static class MCQ extends Question {

        MCQ(String correctAnswer,
            String studentAnswer,
            double points) {

            super(correctAnswer, studentAnswer, points);
        }

        @Override
        double grade() {
            return studentAnswer.equals(correctAnswer)
                    ? points : 0;
        }

        @Override
        String getType() {
            return "MCQ";
        }
    }

    static class TrueFalse extends Question {

        TrueFalse(String correctAnswer,
                  String studentAnswer,
                  double points) {

            super(correctAnswer, studentAnswer, points);
        }

        @Override
        double grade() {
            return studentAnswer.equals(correctAnswer)
                    ? points : 0;
        }

        @Override
        String getType() {
            return "TF";
        }
    }

    static class Essay extends Question {

        Essay(String correctAnswer,
              String studentAnswer,
              double points) {

            super(correctAnswer, studentAnswer, points);
        }

        @Override
        double grade() {

            String[] keywords = correctAnswer.split(",");
            String answer = studentAnswer.toLowerCase();

            int matches = 0;

            for (String keyword : keywords) {

                if (answer.contains(keyword.trim().toLowerCase())) {
                    matches++;
                }
            }

            if (matches >= 2) {
                return points * 0.75;
            } else if (matches == 1) {
                return points * 0.50;
            }

            return 0;
        }

        @Override
        String getType() {
            return "ESSAY";
        }
    }

    static String[] parseLine(String line) {

        java.util.regex.Matcher matcher =
                java.util.regex.Pattern
                        .compile("\"([^\"]*)\"|(\\S+)")
                        .matcher(line);

        java.util.ArrayList<String> values =
                new java.util.ArrayList<>();

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                values.add(matcher.group(1));
            } else {
                values.add(matcher.group(2));
            }
        }

        return values.toArray(new String[0]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {

            String[] data = parseLine(sc.nextLine());

            String type = data[0];
            String correctAnswer = data[2];
            String studentAnswer = data[3];
            double points = Double.parseDouble(data[4]);

            switch (type.toUpperCase()) {

                case "MCQ":
                    questions[i] =
                            new MCQ(correctAnswer, studentAnswer, points);
                    break;

                case "TF":
                    questions[i] =
                            new TrueFalse(
                                    correctAnswer, studentAnswer, points);
                    break;

                case "ESSAY":
                    questions[i] =
                            new Essay(
                                    correctAnswer, studentAnswer, points);
                    break;
            }
        }

        double totalScore = 0;

        for (Question question : questions) {

            double score = question.grade();

            System.out.printf(
                    "%s: %.2f%n",
                    question.getType(), score);

            totalScore += score;
        }

        System.out.printf(
                "Total Score: %.2f%n", totalScore);

        sc.close();
    }
}