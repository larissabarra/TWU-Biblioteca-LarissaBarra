package com.twu.biblioteca;

import com.twu.biblioteca.domain.BookList;
import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.domain.MovieList;
import com.twu.biblioteca.domain.WelcomeMessage;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UserInteractionTest {

    private WelcomeMessage welcomeMessage;
    private BookList bookList;
    private MovieList movieList;
    private UserInteraction userInteraction;
    private IO display;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        welcomeMessage = mock(WelcomeMessage.class);
        bookList = mock(BookList.class);
        movieList = mock(MovieList.class);
        display = mock(IO.class);
        menu = mock(Menu.class);
        userInteraction = new UserInteraction(welcomeMessage, bookList, movieList, display, menu);
    }

    @Test
    public void printWelcomeMessage() throws Exception {
        when(welcomeMessage.returnWelcomeMessage())
                .thenReturn("Ei");
        when(display.waitForUserIntInput())
                .thenReturn(9);

        userInteraction.execute();
        verify(welcomeMessage).returnWelcomeMessage();
        verify(display).print("Ei");
    }

    @Test
    public void showMenu() throws Exception {
        when(menu.showMenu())
                .thenReturn("1 - List books");
        when(display.waitForUserIntInput())
                .thenReturn(9);

        userInteraction.execute();
        verify(menu).showMenu();
        verify(display).print("1 - List books");
    }

    @Test
    public void chooseMenuOption() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(1, 9);
        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput();
        verify(bookList).printAvailableBooks();
    }

    @Test
    public void chooseInvalidMenuOption() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(8, 9);
        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput();
        verify(display).print("Select a valid option!");
    }

    @Test
    public void showMenuWhileUserDoesntQuit() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(8,9);
        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput();
        verify(menu, times(2)).showMenu();
    }

    @Test
    public void chooseBookCheckoutMenuOption() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(2, 9);
        when(display.waitForUserStringInput())
                .thenReturn("xyz");
        when(bookList.checkoutByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).waitForUserStringInput();
        verify(bookList).checkoutByTitle("xyz");
    }

    @Test
    public void chooseMovieCheckoutMenuOption() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(5, 9);
        when(display.waitForUserStringInput())
                .thenReturn("xyz");
        when(movieList.checkoutByName("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).waitForUserStringInput();
        verify(movieList).checkoutByName("xyz");
    }

    @Test
    public void showMessageForSuccessfulBookCheckout() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(2, 9);
        when(display.waitForUserStringInput())
                .thenReturn("xyz");
        when(bookList.checkoutByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).print("Thank you! Enjoy the book.");
    }

    @Test
    public void showMessageForSuccessfulMovieCheckout() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(5, 9);
        when(display.waitForUserStringInput())
                .thenReturn("xyz");
        when(movieList.checkoutByName("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).print("Thank you! Enjoy the movie.");
    }

    @Test
    public void showMessageForUnsuccessfulBookCheckout() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(2, 9);
        when(display.waitForUserStringInput())
                .thenReturn("xyz");
        when(bookList.checkoutByTitle("xyz"))
                .thenReturn(false);

        userInteraction.execute();
        verify(display).print("That book is not available.");
    }

    @Test
    public void showMessageForUnsuccessfulMovieCheckout() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(5, 9);
        when(display.waitForUserStringInput())
                .thenReturn("xyz");
        when(movieList.checkoutByName("xyz"))
                .thenReturn(false);

        userInteraction.execute();
        verify(display).print("That movie is not available.");
    }

    @Test
    public void chooseBookReturnMenuOption() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(3, 9);
        when(display.waitForUserStringInput())
                .thenReturn("xyz");
        when(bookList.returnByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).waitForUserStringInput();
        verify(bookList).returnByTitle("xyz");
    }

    @Test
    public void showMessageForSuccessfulBookReturn() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(3, 9);
        when(display.waitForUserStringInput())
                .thenReturn("xyz");
        when(bookList.returnByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).print("Thank you for returning the book.");
    }

    @Test
    public void showMessageForUnsuccessfulBookReturn() throws Exception {
        when(display.waitForUserIntInput())
                .thenReturn(3, 9);
        when(display.waitForUserStringInput())
                .thenReturn("xyz");
        when(bookList.returnByTitle("xyz"))
                .thenReturn(false);

        userInteraction.execute();
        verify(display).print("That is not a valid book to return.");
    }
}