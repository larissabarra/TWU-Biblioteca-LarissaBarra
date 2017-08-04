package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void returnsListOfBooks() throws Exception {
        BookList list = new BookList();
        assertNotNull(list.getMediaList());
    }

    @Test
    public void printOnlyAvailableBooks() throws Exception {
        BookList list = new BookList();
        list.getMediaList().get(0).checkout();

        String printedList = list.printAvailableMedia();
        assertEquals("Book 2 - author 2 - 1994\n", printedList);
    }

    @Test
    public void doCheckout() throws Exception {
        BookList list = new BookList();
        boolean checkoutBook1 = list.checkoutByTitle("Book 1");
        assertTrue(checkoutBook1);
    }

    @Test
    public void returnBook() throws Exception {
        BookList list = new BookList();
        assertTrue(list.checkoutByTitle("Book 1"));
        assertTrue(list.returnByTitle("Book 1"));
    }
}