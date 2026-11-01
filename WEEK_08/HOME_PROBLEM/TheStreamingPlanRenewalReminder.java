package WEEK_08.HOME_PROBLEM;

import java.time.LocalDate;
import java.util.Scanner;

public class TheStreamingPlanRenewalReminder {

    static abstract class Plan {
        String name;
        LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int getValidityDays();

        LocalDate getRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }

    static class Basic extends Plan {

        Basic(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        int getValidityDays() {
            return 30;
        }
    }

    static class Standard extends Plan {

        Standard(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        int getValidityDays() {
            return 90;
        }
    }

    static class Premium extends Plan {

        Premium(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        int getValidityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Plan[] plans = new Plan[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            switch (type) {
                case "BASIC":
                    plans[i] = new Basic(name, startDate);
                    break;

                case "STANDARD":
                    plans[i] = new Standard(name, startDate);
                    break;

                case "PREMIUM":
                    plans[i] = new Premium(name, startDate);
                    break;
            }
        }

        for (Plan plan : plans) {
            System.out.println(
                    plan.name + ": " + plan.getRenewalDate()
            );
        }

        sc.close();
    }
}