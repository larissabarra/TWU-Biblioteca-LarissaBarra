package com.twu.biblioteca.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MovieList {
    private List<Movie> movieList;

    public MovieList() {
        this.movieList = Arrays.asList(new Movie("Movie 1", "director 1", 2017, 10),
                new Movie("Movie 2", "director 2", 1994, 9));
    }

    public String printAvailableMovies() {
        String list = "";
        for (Movie movie : movieList) {
            if (!movie.isChecked()) {
                list += movie.toString() + "\n";
            }
        }
        return list;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public boolean checkoutByName(String name) {
        Optional<Movie> movieToCheckout = movieList.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst();
        return movieToCheckout.isPresent() && movieToCheckout.get().checkout();
    }
}
