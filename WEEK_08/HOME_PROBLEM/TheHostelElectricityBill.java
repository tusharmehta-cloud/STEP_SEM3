package WEEK_08.HOME_PROBLEM;

import java.util.Scanner;

public class TheHostelElectricityBill {

    static abstract class Room {
        int units;

        Room(int units) {
            this.units = units;
        }

        abstract double calculateBill();

        abstract String getType();
    }

    static class SingleRoom extends Room {

        SingleRoom(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return units * 8;
        }

        @Override
        String getType() {
            return "SINGLE";
        }
    }

    static class SharedRoom extends Room {

        int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        double calculateBill() {
            return (units * 6.0) / occupants;
        }

        @Override
        String getType() {
            return "SHARED";
        }
    }

    static class AcRoom extends Room {

        AcRoom(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return (units * 10) + 200;
        }

        @Override
        String getType() {
            return "AC";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms[i] = new SingleRoom(units);
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms[i] = new SharedRoom(units, occupants);
                    break;

                case "AC":
                    rooms[i] = new AcRoom(units);
                    break;
            }
        }

        double total = 0;

        for (Room room : rooms) {

            double bill = room.calculateBill();

            System.out.printf(
                    "%s: %.2f%n",
                    room.getType(),
                    bill
            );

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}