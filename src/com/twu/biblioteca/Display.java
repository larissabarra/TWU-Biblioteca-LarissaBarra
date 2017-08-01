package com.twu.biblioteca;

import java.util.Scanner;

public class Display {
    private Scanner sc = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public int waitForUserInput() {
        System.out.print("Choose your option: ");
        return sc.nextInt();
    }
}
