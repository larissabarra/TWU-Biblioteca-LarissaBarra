package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BookList {
    private List bookList;

    public BookList() {
        this.bookList = Arrays.asList("Book 1", "Book 2", "Book 3");
    }

    public List getBookList() {
        return bookList;
    }
}
