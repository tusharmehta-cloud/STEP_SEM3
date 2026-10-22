package WEEK_08.CLASSROOM_PROBLEM;

import java.util.Scanner;

public class PaymentSystemFeeCalculation {

    static abstract class Payment {
        double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double calculateAmount();

        abstract String getType();
    }

    static class CardPayment extends Payment {

        CardPayment(double amount) {
            super(amount);
        }

        @Override
        double calculateAmount() {
            return amount + (amount * 0.02);
        }

        @Override
        String getType() {
            return "CARD";
        }
    }

    static class WalletPayment extends Payment {

        WalletPayment(double amount) {
            super(amount);
        }

        @Override
        double calculateAmount() {
            return amount + (amount * 0.01);
        }

        @Override
        String getType() {
            return "WALLET";
        }
    }

    static class BankTransferPayment extends Payment {

        BankTransferPayment(double amount) {
            super(amount);
        }

        @Override
        double calculateAmount() {
            return amount;
        }

        @Override
        String getType() {
            return "BANKTRANSFER";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            switch (type) {
                case "CARD":
                    payments[i] = new CardPayment(amount);
                    break;

                case "WALLET":
                    payments[i] = new WalletPayment(amount);
                    break;

                case "BANKTRANSFER":
                    payments[i] =
                            new BankTransferPayment(amount);
                    break;
            }
        }

        double total = 0;

        for (Payment payment : payments) {

            double adjustedAmount = payment.calculateAmount();

            System.out.printf(
                    "%s: %.2f%n",
                    payment.getType(),
                    adjustedAmount
            );

            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}