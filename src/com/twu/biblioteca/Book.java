package com.twu.biblioteca;

public class Book {
    private final String author;
    private final int year;

    public Book(String author, int year) {
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
