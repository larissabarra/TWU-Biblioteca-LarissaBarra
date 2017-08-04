package com.twu.biblioteca;

import com.twu.biblioteca.domain.*;

import java.util.List;

public class UserInteraction {
    private final WelcomeMessage welcomeMessage;
    private final BookList bookList;
    private final MovieList movieList;
    private final UserList userList;
    private final IO io;
    private final Menu menu;
    private User loggedUser;

    public UserInteraction(WelcomeMessage welcomeMessage, BookList bookList, MovieList movieList, UserList userList, IO io, Menu menu) {
        this.welcomeMessage = welcomeMessage;
        this.bookList = bookList;
        this.movieList = movieList;
        this.userList = userList;
        this.io = io;
        this.menu = menu;
        loggedUser = null;
    }

    public void execute() {
        io.print(welcomeMessage.returnWelcomeMessage());
        io.print("Log in before using the system.");
        while (loggedUser == null) {
            io.clearBuffer();
            String libNumber = io.waitForUserStringInput("Enter your library number: ", true);
            String password = io.waitForUserStringInput("Enter your password: ", true);
            loggedUser = userList.login(libNumber, password);
        }
        int choice = 0;
        while (choice != 9) {
            io.print(menu.showMenu());
            choice = io.waitForUserIntInput("Choose your option: ");
            switch (choice) {
                case 1:
                    printAvailableMedia(bookList);
                    break;
                case 2:
                    checkoutMedia("book", bookList);
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    printAvailableMedia(movieList);
                    break;
                case 5:
                    checkoutMedia("movie", movieList);
                    break;
                case 7:
                    printLoggedUsersData();
                    break;
                case 9:
                    io.print("Bye!");
                    break;
                default:
                    io.print("Select a valid option!");
                    break;
            }
        }
    }

    private void printAvailableMedia(MediaList list) {
        io.print(list.printAvailableMedia());
    }

    private void returnBook() {
        String bookToReturn = io.waitForUserStringInput("Enter the book title: ", false);
        boolean returnSuccessful = bookList.returnByTitle(bookToReturn);
        if (returnSuccessful) {
            io.print("Thank you for returning the book.");
        } else {
            io.print("That is not a valid book to return.");
        }
    }

    private void checkoutMedia(String media, MediaList list) {
        String mediaToCheckout = io.waitForUserStringInput("Enter the " + media + " title: ", false);
        boolean mediaCheckoutSuccessful = list.checkoutByTitle(mediaToCheckout);
        if (mediaCheckoutSuccessful) {
            io.print("Thank you! Enjoy the " + media + ".");
        } else {
            io.print("That " + media + " is not available.");
        }
    }

    public void printLoggedUsersData() {
        io.print(loggedUser.toString());
    }
}
