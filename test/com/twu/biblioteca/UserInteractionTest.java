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
        simulateExitOption();

        userInteraction.execute();
        verify(welcomeMessage).returnWelcomeMessage();
        verify(display).print("Ei");
    }

    @Test
    public void showMenu() throws Exception {
        simulateLogin();
        when(menu.showMenu())
                .thenReturn("1 - List books");
        simulateExitOption();

        userInteraction.execute();
        verify(menu).showMenu();
        verify(display).print("1 - List books");
    }

    @Test
    public void chooseMenuOption() throws Exception {
        simulateLogin();
        simulateMenuOption(1);

        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput("Choose your option: ");
        verify(bookList).printAvailableMedia();
    }

    @Test
    public void chooseInvalidMenuOption() throws Exception {
        simulateLogin();
        simulateMenuOption(10);

        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput("Choose your option: ");
        verify(display).print("Select a valid option!");
    }

    @Test
    public void showMenuWhileUserDoesNotQuit() throws Exception {
        simulateLogin();
        simulateMenuOption(10);

        userInteraction.execute();
        verify(display, times(2)).waitForUserIntInput("Choose your option: ");
        verify(menu, times(2)).showMenu();
    }

    @Test
    public void chooseBookCheckoutMenuOption() throws Exception {
        simulateLogin();
        simulateMenuOption(2);
        askForMediaTitle("Enter the book title: ");
        when(bookList.checkoutByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).waitForUserStringInput("Enter the book title: ", false);
        verify(bookList).checkoutByTitle("xyz");
    }

    @Test
    public void chooseMovieCheckoutMenuOption() throws Exception {
        simulateLogin();
        simulateMenuOption(5);
        askForMediaTitle("Enter the movie title: ");
        when(movieList.checkoutByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).waitForUserStringInput("Enter the movie title: ", false);
        verify(movieList).checkoutByTitle("xyz");
    }

    @Test
    public void showMessageForSuccessfulBookCheckout() throws Exception {
        simulateLogin();
        simulateMenuOption(2);
        askForMediaTitle("Enter the book title: ");
        when(bookList.checkoutByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).print("Thank you! Enjoy the book.");
    }

    @Test
    public void showMessageForSuccessfulMovieCheckout() throws Exception {
        simulateLogin();
        simulateMenuOption(5);
        askForMediaTitle("Enter the movie title: ");
        when(movieList.checkoutByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).print("Thank you! Enjoy the movie.");
    }

    @Test
    public void showMessageForUnsuccessfulBookCheckout() throws Exception {
        simulateLogin();
        simulateMenuOption(2);
        askForMediaTitle("Enter the book title: ");
        when(bookList.checkoutByTitle("xyz"))
                .thenReturn(false);

        userInteraction.execute();
        verify(display).print("That book is not available.");
    }

    @Test
    public void showMessageForUnsuccessfulMovieCheckout() throws Exception {
        simulateLogin();
        simulateMenuOption(5);
        askForMediaTitle("Enter the movie title: ");
        when(movieList.checkoutByTitle("xyz"))
                .thenReturn(false);

        userInteraction.execute();
        verify(display).print("That movie is not available.");
    }

    @Test
    public void chooseBookReturnMenuOption() throws Exception {
        simulateLogin();
        simulateMenuOption(3);
        askForMediaTitle("Enter the book title: ");
        when(bookList.returnByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).waitForUserStringInput("Enter the book title: ", false);
        verify(bookList).returnByTitle("xyz");
    }

    @Test
    public void showMessageForSuccessfulBookReturn() throws Exception {
        simulateLogin();
        simulateMenuOption(3);
        askForMediaTitle("Enter the book title: ");
        when(bookList.returnByTitle("xyz"))
                .thenReturn(true);

        userInteraction.execute();
        verify(display).print("Thank you for returning the book.");
    }

    @Test
    public void showMessageForUnsuccessfulBookReturn() throws Exception {
        simulateLogin();
        simulateMenuOption(3);
        askForMediaTitle("Enter the book title: ");
        when(bookList.returnByTitle("xyz"))
                .thenReturn(false);

        userInteraction.execute();
        verify(display).print("That is not a valid book to return.");
    }

    @Test
    public void demandLoginBeforeUsingSystem() throws Exception {
        simulateLogin();
        simulateExitOption();

        userInteraction.execute();
        verify(display).waitForUserStringInput("Enter your library number: ", true);
        verify(display).waitForUserStringInput("Enter your password: ", true);
        verify(menu).showMenu();
    }

    @Test
    public void printUserInformation() throws Exception {
        simulateLogin();
        simulateMenuOption(7);

        userInteraction.execute();
        verify(display).print("Library number: zzz-zzzz\nName: user1\nEmail: email1\nPhone: xxx");
    }

    private void simulateLogin() {
        when(display.waitForUserStringInput("Enter your library number: ", true))
                .thenReturn("zzz-zzzz");
        when(display.waitForUserStringInput("Enter your password: ", true))
                .thenReturn("qwe");
        when(userList.login("zzz-zzzz", "qwe"))
                .thenReturn(new Customer("zzz-zzzz", "qwe", "user1", "email1", "xxx"));
    }
    private void simulateMenuOption(int option) {
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(option, 9);
    }

    private void simulateExitOption() {
        when(display.waitForUserIntInput("Choose your option: "))
                .thenReturn(9);
    }

    private void askForMediaTitle(String message) {
        when(display.waitForUserStringInput(message, false))
                .thenReturn("xyz");
    }
}