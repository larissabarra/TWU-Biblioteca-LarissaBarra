package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Display {
    private Scanner sc = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public int waitForUserIntInput() {
        System.out.print("Choose your option: ");
        try {
            return sc.nextInt();
        } catch (InputMismatchException ex) {
            return 0;
        }
    }

    public String waitForUserStringInput() {
        System.out.print("Enter the book title: ");
        try {
            sc.nextLine();
            String retorno = sc.nextLine();
            return retorno;
        } catch (InputMismatchException ex) {
            return "-";
        }
    }
}
