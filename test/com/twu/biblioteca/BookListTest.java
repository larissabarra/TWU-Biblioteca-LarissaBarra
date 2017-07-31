package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BookListTest {
    @Test
    public void returnsListOfBooks() throws Exception {
        BookList list = new BookList();
        assertNotNull(list.getBookList());
    }
}
