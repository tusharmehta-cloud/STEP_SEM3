package WEEK_07.CLASSROOM_PROBLEM;

public class ThePiggyBank {

    static class PiggyBank {

        private double savings;
        private final String id;

        PiggyBank(String id) {
            this.id = id;
            this.savings = 0;
        }

        void deposit(double amount) {

            if (amount > 0) {
                savings += amount;
            }
        }

        void withdraw(double amount) {

            if (amount > savings) {
                System.out.println(
                        "Withdrawal rejected: insufficient savings"
                );
            } else if (amount > 0) {
                savings -= amount;
            }
        }

        double getSavings() {
            return savings;
        }

        String getId() {
            return id;
        }
    }

    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);

        System.out.println(
                "Savings after deposit: "
                + pb.getSavings()
        );

        pb.withdraw(30);

        System.out.println(
                "Savings after withdrawal: "
                + pb.getSavings()
        );

        pb.withdraw(500);

        System.out.println(
                "Final savings: "
                + pb.getSavings()
        );
    }
}