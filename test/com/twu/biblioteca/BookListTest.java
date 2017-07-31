package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookListTest {
    private BookList bookList;

    @Before
    public void setUp() throws Exception {
        bookList = mock(BookList.class);
    }

    @Test
    public void returnsListOfBooks() throws Exception {
        assertNotNull(bookList.getBookList());
    }

    @Test
    public void booksHaveAuthor() throws Exception {
        when(bookList.getBookList())
                .thenReturn(Arrays.asList(new Book("author", 2017)));

        List list = bookList.getBookList();
        assertEquals("author", ((Book) list.get(0)).getAuthor());
        assertEquals(2017, ((Book) list.get(0)).getYear());
    }
}
