package com.twu.biblioteca;

import com.twu.biblioteca.domain.*;

public class UserInteraction {
    private final WelcomeMessage welcomeMessage;
    private final BookList bookList;
    private final MovieList movieList;
    private final UserList userList;
    private final IO display;
    private final Menu menu;
    private User loggedUser;

    public UserInteraction(WelcomeMessage welcomeMessage, BookList bookList, MovieList movieList, UserList userList, IO display, Menu menu) {
        this.welcomeMessage = welcomeMessage;
        this.bookList = bookList;
        this.movieList = movieList;
        this.userList = userList;
        this.display = display;
        this.menu = menu;
        loggedUser = null;
    }

    public void execute() {
        display.print(welcomeMessage.returnWelcomeMessage());
        display.print("Log in before using the system.");
        while (loggedUser == null) {
            display.clearBuffer();
            String libNumber = display.waitForUserStringInput("Enter your library number: ");
            String password = display.waitForUserStringInput("Enter your password: ");
            loggedUser = userList.login(libNumber, password);
        }
        int choice = 0;
        while (choice != 9) {
            display.print(menu.showMenu());
            choice = display.waitForUserIntInput("Choose your option: ");
            switch (choice) {
                case 1: display.print(bookList.printAvailableBooks());
                    break;
                case 2: String bookToCheckout = display.waitForUserStringInput("Enter the book title: ");
                    boolean bookCheckoutSuccessful = bookList.checkoutByTitle(bookToCheckout);
                    if (bookCheckoutSuccessful) {
                        display.print("Thank you! Enjoy the book.");
                    } else {
                        display.print("That book is not available.");
                    }
                    break;
                case 3: String bookToReturn = display.waitForUserStringInput("Enter the book title: ");
                    boolean returnSuccessful = bookList.returnByTitle(bookToReturn);
                    if (returnSuccessful) {
                        display.print("Thank you for returning the book.");
                    } else {
                        display.print("That is not a valid book to return.");
                    }
                    break;
                case 4: display.print(movieList.printAvailableMovies());
                    break;
                case 5: String movieToCheckout = display.waitForUserStringInput("Enter the movie title: ");
                    boolean movieCheckoutSuccessful = movieList.checkoutByName(movieToCheckout);
                    if (movieCheckoutSuccessful) {
                        display.print("Thank you! Enjoy the movie.");
                    } else {
                        display.print("That movie is not available.");
                    }
                    break;
                case 7: printLoggedUsersData();
                    break;
                case 9: display.print("Bye!");
                    break;
                default: display.print("Select a valid option!");
                    break;
            }
        }
    }

    public void printLoggedUsersData() {
        display.print(loggedUser.toString());
    }
}
