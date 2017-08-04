package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    Movie movie = new Movie("name", "director", 2016, 8);

    @Test
    public void movieHasName() throws Exception {
        assertEquals("name", movie.getTitle());
    }

    @Test
    public void movieHasDirector() throws Exception {
        assertEquals("director", movie.getDirector());
    }

    @Test
    public void movieHasYear() throws Exception {
        assertEquals(2016, movie.getYear());
    }

    @Test
    public void movieHasRating() throws Exception {
        assertEquals(8, movie.getRating());
    }

    @Test
    public void doCheckOut() throws Exception {
        assertTrue(movie.checkout());
    }
}
