package com.twu.biblioteca.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookListTest {

    @Test
    public void returnsListOfBooks() throws Exception {
        BookList list = new BookList();
        assertNotNull(list.getBookList());
    }

    @Test
    public void printOnlyAvailableBooks() throws Exception {
        BookList list = new BookList();
        list.getBookList().get(0).checkout();

        String printedList = list.printAvailableBooks();
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