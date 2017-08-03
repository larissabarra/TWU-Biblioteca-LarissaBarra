package com.twu.biblioteca.domain;

public class Movie {
    private final String name;
    private final String director;
    private final int year;
    private final int rating;
    private boolean checked;

    public Movie(String name, String director, int year, int rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.checked = false;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public boolean checkout() {
        if (!isChecked()) {
            setChecked(true);
            return true;
        }
        return false;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    @Override
    public String toString() {
        return name + " - " + director + " - " + year + " - " + rating;
    }
}
