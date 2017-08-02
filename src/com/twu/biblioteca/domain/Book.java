package com.twu.biblioteca.domain;

public class Book {
    private final String title;
    private final String author;
    private final int year;
    private boolean checked;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.checked = false;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean checkOut() {
        if (!isChecked()) {
            setChecked(true);
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return title + " - " + author + " - " + year;
    }
}
