package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage message = new WelcomeMessage();
        BookList list = new BookList();
        Display display = new Display();
        Menu menu = new Menu();

        new UserInteraction(message, list, display, menu).execute();
    }
}
