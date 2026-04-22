package ub.csi142.studygroupscheduler.util;

import java.util.Scanner;

public class InputHelper {
    private Scanner scanner = new Scanner(System.in);

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public String readString(String prompt) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty())
                System.out.println("Input cannot be empty.");
        }
        return input;
    }

    public void close() { scanner.close(); }
}
