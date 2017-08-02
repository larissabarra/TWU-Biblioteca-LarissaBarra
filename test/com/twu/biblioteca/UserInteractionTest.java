package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

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

    /*
    @Test
    public void printBookList() throws Exception {
        when(bookList.printBookList())
                .thenReturn("title - author - 2017");

        userInteraction.execute();
        verify(bookList).printBookList();
        verify(display).print("title - author - 2017");
    }*/

    @Test
    public void showMenu() throws Exception {
        when(menu.showMenu())
                .thenReturn("1 - List books");

        userInteraction.execute();
        verify(menu).showMenu();
        verify(display).print("1 - List books");
    }

    @Test
    public void chooseMenuOption() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(1);
        userInteraction.execute();
        verify(display).waitForUserIntInput();
        verify(bookList).printBookList();
    }

    @Test
    public void chooseInvalidMenuOption() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(2, 9);
        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput();
        verify(display).print("Select a valid option!");
    }

    @Test
    public void showMenuWhileUserDoesntQuit() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(2,9);
        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput();
        verify(menu, times(2)).showMenu();
    }
}