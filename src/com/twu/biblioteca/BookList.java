package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BookList {
    private List bookList;

    public BookList() {
        this.bookList = Arrays.asList(new Book("Book 1", "author 1", 2017),
                                        new Book("Book 2", "author 2", 1994));
    }

    public List getBookList() {
        return bookList;
    }
}
