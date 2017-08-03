package com.twu.biblioteca;

import com.twu.biblioteca.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UserInteractionTest {

    private WelcomeMessage welcomeMessage;
    private BookList bookList;
    private MovieList movieList;
    private UserList userList;
    private UserInteraction userInteraction;
    private IO display;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        welcomeMessage = mock(WelcomeMessage.class);
        bookList = mock(BookList.class);
        movieList = mock(MovieList.class);
        userList = mock(UserList.class);
        display = mock(IO.class);
        menu = mock(Menu.class);
        userInteraction = new UserInteraction(welcomeMessage, bookList, movieList, userList, display, menu);
    }

    @Test
    public void printWelcomeMessage() throws Exception {
        simulateLogin();
        when(welcomeMessage.returnWelcomeMessage())
                .thenReturn("Ei");
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(9);

        userInteraction.execute();
        verify(welcomeMessage).returnWelcomeMessage();
        verify(display).print("Ei");
    }

    @Test
    public void showMenu() throws Exception {
        simulateLogin();
        when(menu.showMenu())
                .thenReturn("1 - List books");
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(9);

        userInteraction.execute();
        verify(menu).showMenu();
        verify(display).print("1 - List books");
    }

    @Test
    public void chooseMenuOption() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(1, 9);

        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput("Choose your option: ");
        verify(bookList).printAvailableBooks();
    }

    @Test
    public void chooseInvalidMenuOption() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(10, 9);

        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput("Choose your option: ");
        verify(display).print("Select a valid option!");
    }

    @Test
    public void showMenuWhileUserDoesntQuit() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(10,9);

        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput("Choose your option: ");
        verify(menu, times(2)).showMenu();
    }

    @Test
    public void chooseBookCheckoutMenuOption() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(2, 9);
        when(display.waitForUserStringInput("Enter the book title: "))
                .thenReturn("xyz");
        when(bookList.checkoutByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).waitForUserStringInput("Enter the book title: ");
        verify(bookList).checkoutByTitle("xyz");
    }

    @Test
    public void chooseMovieCheckoutMenuOption() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(5, 9);
        when(display.waitForUserStringInput("Enter the movie title: "))
                .thenReturn("xyz");
        when(movieList.checkoutByName("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).waitForUserStringInput("Enter the movie title: ");
        verify(movieList).checkoutByName("xyz");
    }

    @Test
    public void showMessageForSuccessfulBookCheckout() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(2, 9);
        when(display.waitForUserStringInput("Enter the book title: "))
                .thenReturn("xyz");
        when(bookList.checkoutByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).print("Thank you! Enjoy the book.");
    }

    @Test
    public void showMessageForSuccessfulMovieCheckout() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(5, 9);
        when(display.waitForUserStringInput("Enter the movie title: "))
                .thenReturn("xyz");
        when(movieList.checkoutByName("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).print("Thank you! Enjoy the movie.");
    }

    @Test
    public void showMessageForUnsuccessfulBookCheckout() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(2, 9);
        when(display.waitForUserStringInput("Enter the book title: "))
                .thenReturn("xyz");
        when(bookList.checkoutByTitle("xyz"))
                .thenReturn(false);

        userInteraction.execute();
        verify(display).print("That book is not available.");
    }

    @Test
    public void showMessageForUnsuccessfulMovieCheckout() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(5, 9);
        when(display.waitForUserStringInput("Enter the movie title: "))
                .thenReturn("xyz");
        when(movieList.checkoutByName("xyz"))
                .thenReturn(false);

        userInteraction.execute();
        verify(display).print("That movie is not available.");
    }

    @Test
    public void chooseBookReturnMenuOption() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(3, 9);
        when(display.waitForUserStringInput("Enter the book title: "))
                .thenReturn("xyz");
        when(bookList.returnByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).waitForUserStringInput("Enter the book title: ");
        verify(bookList).returnByTitle("xyz");
    }

    @Test
    public void showMessageForSuccessfulBookReturn() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(3, 9);
        when(display.waitForUserStringInput("Enter the book title: "))
                .thenReturn("xyz");
        when(bookList.returnByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).print("Thank you for returning the book.");
    }

    @Test
    public void showMessageForUnsuccessfulBookReturn() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(3, 9);
        when(display.waitForUserStringInput("Enter the book title: "))
                .thenReturn("xyz");
        when(bookList.returnByTitle("xyz"))
                .thenReturn(false);

        userInteraction.execute();
        verify(display).print("That is not a valid book to return.");
    }

    @Test
    public void chooseLoginOption() throws Exception {
        simulateLogin();
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(8, 9);

        userInteraction.execute();
        verify(display).waitForUserStringInput("Enter your library number: ");
        verify(display).waitForUserStringInput("Enter your password: ");
    }

    @Test
    public void demandLoginBeforeUsingSystem() throws Exception {
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(9);
        simulateLogin();

        userInteraction.execute();
        verify(display).waitForUserStringInput("Enter your library number: ");
        verify(display).waitForUserStringInput("Enter your password: ");
        verify(menu).showMenu();
    }

    private void simulateLogin() {
        when(display.waitForUserStringInput("Enter your library number: "))
                .thenReturn("xxx-xxxx");
        when(display.waitForUserStringInput("Enter your password: "))
                .thenReturn("123");
        when(userList.login("xxx-xxxx", "123"))
                .thenReturn(new User("user 1", "email 1", "123", "xxx", "xxx-xxxx"));
    }
}