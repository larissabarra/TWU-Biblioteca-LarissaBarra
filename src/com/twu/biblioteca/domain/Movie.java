package com.twu.biblioteca.domain;

public class Movie extends Media{
    private final String director;
    private final int rating;

    public Movie(String name, String director, int year, int rating) {
        super(name, year);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return getTitle() + " - " + director + " - " + year + " - " + rating;
    }
}
