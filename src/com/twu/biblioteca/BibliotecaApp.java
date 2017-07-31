package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage message = new WelcomeMessage();
        System.out.println(message.returnWelcomeMessage());

        BookList list = new BookList();
        System.out.println(list.getBookList().toString());
    }
}
