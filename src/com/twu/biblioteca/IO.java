package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    private Scanner sc = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public int waitForUserIntInput(String message) {
        System.out.print(message);
        try {
            return sc.nextInt();
        } catch (InputMismatchException ex) {
            return 0;
        }
    }

    public String waitForUserStringInput(String message, boolean shouldResetBuffer) {
        System.out.print(message);
        try {
            if (shouldResetBuffer) {
                sc.reset();
            } else {
                sc.nextLine();
            }
            return sc.nextLine();
        } catch (InputMismatchException ex) {
            return "";
        }
    }

    public void clearBuffer() {
        sc.reset();
    }
}
