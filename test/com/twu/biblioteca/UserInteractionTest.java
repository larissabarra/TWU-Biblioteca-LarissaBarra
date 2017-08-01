package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserInteractionTest {

    private WelcomeMessage welcomeMessage;
    private BookList bookList;
    private UserInteraction userInteraction;
    private Display display;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        welcomeMessage = mock(WelcomeMessage.class);
        bookList = mock(BookList.class);
        display = mock(Display.class);
        menu = mock(Menu.class);
        userInteraction = new UserInteraction(welcomeMessage, bookList, display, menu);
    }

    @Test
    public void printWelcomeMessage() throws Exception {
        when(welcomeMessage.returnWelcomeMessage())
                .thenReturn("Ei");

        userInteraction.execute();
        verify(welcomeMessage).returnWelcomeMessage();
        verify(display).print("Ei");
    }

    //TODO: descobrir pq isso n'ao funciona
    /*@Test
    public void printBookList() throws Exception {
        when(userInteraction.printBookList())
                .thenReturn("book1 - author - 2017");

        userInteraction.execute();
        verify(userInteraction).printBookList();
        verify(display).print("book1 - author - 2017");
    }*/

    @Test
    public void showMenu() throws Exception {
        when(menu.showMenu())
                .thenReturn("1 - List books");

        userInteraction.execute();
        verify(menu).showMenu();
        verify(display).print("1 - List books");
    }
}