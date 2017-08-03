package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void booksHaveAuthor() throws Exception {
        Book book = new Book("title", "author", 2017);
        assertEquals("author", book.getAuthor());
    }

    @Test
    public void booksHaveYear() throws Exception {
        Book book = new Book("title", "author", 2017);
        assertEquals(2017, book.getYear());
    }
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
