package WEEK_08.CLASSROOM_PROBLEM;

import java.util.Scanner;

public class PublicTransportFareCalculator {

    static abstract class Transport {
        double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract double calculateFare();

        abstract String getType();
    }

    static class Bus extends Transport {

        Bus(double distance) {
            super(distance);
        }

        @Override
        double calculateFare() {
            return Math.min(2 + (0.10 * distance), 10);
        }

        @Override
        String getType() {
            return "BUS";
        }
    }

    static class Train extends Transport {

        Train(double distance) {
            super(distance);
        }

        @Override
        double calculateFare() {
            return 3 + (0.15 * distance);
        }

        @Override
        String getType() {
            return "TRAIN";
        }
    }

    static class Metro extends Transport {

        double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        double calculateFare() {
            return (1.50 + (0.20 * distance)) * peakHourFactor;
        }

        @Override
        String getType() {
            return "METRO";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Transport[] journeys = new Transport[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            switch (type) {

                case "BUS":
                    journeys[i] = new Bus(distance);
                    break;

                case "TRAIN":
                    journeys[i] = new Train(distance);
                    break;

                case "METRO":
                    double factor = sc.nextDouble();
                    journeys[i] = new Metro(distance, factor);
                    break;
            }
        }

        double total = 0;

        for (Transport journey : journeys) {

            double fare = journey.calculateFare();

            System.out.printf(
                    "%s: %.2f%n",
                    journey.getType(), fare
            );

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}