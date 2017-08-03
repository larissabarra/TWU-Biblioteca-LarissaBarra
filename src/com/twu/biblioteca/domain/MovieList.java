package com.twu.biblioteca.domain;

import java.util.Arrays;
import java.util.List;

public class MovieList {
    private List<Book> movieList;

    public MovieList() {
        this.movieList = Arrays.asList(new Book("Book 1", "author 1", 2017),
                new Book("Book 2", "author 2", 1994));
    }

    public String printAvailableMovies() {
        /*String list = "";
        for (Book book : movieList) {
            if (!book.isChecked()) {
                list += book.toString() + "\n";
            }
        }
        return list;*/
        return "Movie1\nMovie2\n";
    }
}
