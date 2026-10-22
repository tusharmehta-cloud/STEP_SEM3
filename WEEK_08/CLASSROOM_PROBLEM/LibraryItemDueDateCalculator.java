package WEEK_08.CLASSROOM_PROBLEM;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryItemDueDateCalculator {

    static abstract class LibraryItem {

        String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getLoanDays();

        LocalDate getDueDate() {
            return LocalDate.of(2023, 10, 26)
                    .plusDays(getLoanDays());
        }
    }

    static class Book extends LibraryItem {

        Book(String title) {
            super(title);
        }

        @Override
        int getLoanDays() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {

        DVD(String title) {
            super(title);
        }

        @Override
        int getLoanDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {

        Magazine(String title) {
            super(title);
        }

        @Override
        int getLoanDays() {
            return 3;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            int space = line.indexOf(' ');

            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            switch (type.toUpperCase()) {
                case "BOOK":
                    items[i] = new Book(title);
                    break;

                case "DVD":
                    items[i] = new DVD(title);
                    break;

                case "MAGAZINE":
                    items[i] = new Magazine(title);
                    break;
            }
        }

        for (LibraryItem item : items) {
            System.out.println(
                    item.title + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}