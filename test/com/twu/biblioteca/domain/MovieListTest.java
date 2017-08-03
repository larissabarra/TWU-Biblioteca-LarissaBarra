package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieListTest {
    @Test
    public void printMoviesList() throws Exception {
        MovieList movieList = new MovieList();
        String printedList = movieList.printAvailableMovies();
        assertEquals("Movie1\nMovie2\n", printedList);
    }
}
