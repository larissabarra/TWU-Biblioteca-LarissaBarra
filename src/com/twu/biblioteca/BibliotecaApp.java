package com.twu.biblioteca;

import com.twu.biblioteca.domain.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage message = new WelcomeMessage();
        BookList bookList = new BookList();
        MovieList movieList = new MovieList();
        UserList userList = new UserList();
        IO display = new IO();
        Menu menu = new Menu();

        new UserInteraction(message, bookList, movieList, userList, display, menu).execute();
    }
}
