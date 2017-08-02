package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BookTest {
    @Test
    public void doCheckOut() throws Exception {
        Book book = new Book("title", "author", 2017);
        assertTrue(book.checkOut());
    }
}