package ub.csi142.studygroupscheduler.util;

import java.util.Scanner;

public class InputHelper {

    private Scanner scanner = new Scanner(System.in);

    public int readInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}
