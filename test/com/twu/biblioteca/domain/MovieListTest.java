package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieListTest {
    @Test
    public void printMoviesList() throws Exception {
        MovieList movieList = new MovieList();
        movieList.getMediaList().get(0).checkout();

        String printedList = movieList.printAvailableMedia();
        assertEquals("Movie 2 - director 2 - 1994 - 9\n", printedList);
    }

    @Test
    public void doCheckout() throws Exception {
        MovieList movieList = new MovieList();
        boolean checkoutMovie1 = movieList.checkoutByTitle("Movie 1");
        assertTrue(checkoutMovie1);
    }
}
