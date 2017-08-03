package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieListTest {
    @Test
    public void printMoviesList() throws Exception {
        MovieList movieList = new MovieList();
        movieList.getMovieList().get(0).checkout();

        String printedList = movieList.printAvailableMovies();
        assertEquals("Movie 2 - director 2 - 1994 - 9\n", printedList);
    }
}
