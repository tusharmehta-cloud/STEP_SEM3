package WEEK_07.CLASSROOM_PROBLEM;

public class TheQuizScorecard {

    static class Scorecard {

        private boolean[] results;
        private int recordedAnswers;

        Scorecard(int totalQuestions) {
            results = new boolean[totalQuestions];
            recordedAnswers = 0;
        }

        void recordAnswer(boolean correct) {

            if (recordedAnswers < results.length) {
                results[recordedAnswers] = correct;
                recordedAnswers++;
            } else {
                System.out.println(
                        "Cannot record more answers."
                );
            }
        }

        int getScore() {

            int score = 0;

            for (int i = 0; i < recordedAnswers; i++) {

                if (results[i]) {
                    score++;
                }
            }

            return score;
        }
    }

    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(
                "Score: " + sc.getScore()
        );
    }
}