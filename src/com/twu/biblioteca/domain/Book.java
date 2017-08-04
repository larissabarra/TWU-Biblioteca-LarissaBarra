package com.twu.biblioteca.domain;

public class Book extends Media {
    private final String author;
    private boolean checked;

    public Book(String title, String author, int year) {
        super(title, year);
        this.author = author;
        this.checked = false;
    }

    public String getAuthor() {
        return author;
    }

    public boolean returnBook() {
        if (isChecked()) {
            setChecked(false);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return title + " - " + author + " - " + year;
    }
}
