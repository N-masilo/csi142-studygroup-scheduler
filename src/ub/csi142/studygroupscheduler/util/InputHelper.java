package ub.csi142.studygroupscheduler.util;

import java.util.Scanner;

public class InputHelper {

    private Scanner scanner;

    public InputHelper() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String prompt) {
        String value = "";
        while (value.trim().isEmpty()) {
            System.out.print(prompt);
            value = scanner.nextLine();
            if (value.trim().isEmpty()) {
                System.out.println("  [!] This field cannot be blank. Please try again.");
            }
        }
        return value.trim();
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Please enter a whole number (e.g. 1, 2, 3).");
            }
        }
    }

    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) return value;
            System.out.println("  [!] Please enter a number between " + min + " and " + max + ".");
        }
    }

    public String readTime(String prompt) {
        while (true) {
            String value = readString(prompt);
            if (value.matches("\\d{2}:\\d{2}")) return value;
            System.out.println("  [!] Time must be in HH:MM format, e.g. 08:00 or 14:30.");
        }
    }

    public void close() {
        scanner.close();
    }
}
