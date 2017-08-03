package com.twu.biblioteca;

import com.twu.biblioteca.domain.BookList;
import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.domain.MovieList;
import com.twu.biblioteca.domain.WelcomeMessage;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage message = new WelcomeMessage();
        BookList bookList = new BookList();
        MovieList movieList = new MovieList();
        IO display = new IO();
        Menu menu = new Menu();

        new UserInteraction(message, bookList, movieList, display, menu).execute();
    }
}
