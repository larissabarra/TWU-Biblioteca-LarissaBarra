package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    @Test
    public void movieHasName() throws Exception {
        Movie movie = new Movie("name", "director", 2016, 8);
        assertEquals("name", movie.getName());
    }

    @Test
    public void movieHasDirector() throws Exception {
        Movie movie = new Movie("name", "director", 2016, 8);
        assertEquals("director", movie.getDirector());
    }

    @Test
    public void movieHasYear() throws Exception {
        Movie movie = new Movie("name", "director", 2016, 8);
        assertEquals(2016, movie.getYear());
    }

    @Test
    public void movieHasRating() throws Exception {
        Movie movie = new Movie("name", "director", 2016, 8);
        assertEquals(8, movie.getRating());
    }

    @Test
    public void doCheckOut() throws Exception {
        Movie movie = new Movie("name", "director", 2016, 8);
        assertTrue(movie.checkout());
    }
}
