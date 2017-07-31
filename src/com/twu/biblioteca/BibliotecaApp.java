package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage message = new WelcomeMessage();
        BookList list = new BookList();
        Display display = new Display();

        new UserInteraction(message, list, display).execute();
    }
}
