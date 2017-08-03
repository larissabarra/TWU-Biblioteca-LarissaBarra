package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BookTest {
    @Test
    public void doCheckOut() throws Exception {
        Book book = new Book("title", "author", 2017);
        assertTrue(book.checkout());
    }

    @Test
    public void returnBook() throws Exception {
        Book book = new Book("title", "author", 2017);
        assertTrue(book.checkout());
        assertTrue(book.returnBook());
    }
}
