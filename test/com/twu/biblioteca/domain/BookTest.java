package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {
    Book book = new Book("title", "author", 2017);

    @Test
    public void booksHaveAuthor() throws Exception {
        assertEquals("author", book.getAuthor());
    }

    @Test
    public void booksHaveYear() throws Exception {
        assertEquals(2017, book.getYear());
    }

    @Test
    public void doCheckOut() throws Exception {
        assertTrue(book.checkout());
    }

    @Test
    public void returnBook() throws Exception {
        Book book2 = new Book("title", "author", 2017);
        assertTrue(book2.checkout());
        assertTrue(book2.returnBook());
    }
}
