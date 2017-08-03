package com.twu.biblioteca.domain;

public class Menu {
    public String showMenu() {
        return "\n1 - List available books\n"
                + "2 - Checkout book\n"
                + "3 - Return book\n"
                + "4 - List available movies\n"
                + "9 - Exit\n";
    }
}
