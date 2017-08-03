package com.twu.biblioteca;

import com.twu.biblioteca.domain.*;

public class UserInteraction {
    private final WelcomeMessage welcomeMessage;
    private final BookList bookList;
    private final MovieList movieList;
    private final IO display;
    private final Menu menu;

    public UserInteraction(WelcomeMessage welcomeMessage, BookList bookList, MovieList movieList, IO display, Menu menu) {
        this.welcomeMessage = welcomeMessage;
        this.bookList = bookList;
        this.movieList = movieList;
        this.display = display;
        this.menu = menu;
    }

    public void execute() {
        display.print(welcomeMessage.returnWelcomeMessage());
        int choice = 0;
        while (choice != 9) {
            display.print(menu.showMenu());
            choice = display.waitForUserIntInput();
            switch (choice) {
                case 1: display.print(bookList.printAvailableBooks());
                    break;
                case 2: String bookToCheckout = display.waitForUserStringInput();
                    boolean bookCheckoutSuccessful = bookList.checkoutByTitle(bookToCheckout);
                    if (bookCheckoutSuccessful) {
                        display.print("Thank you! Enjoy the book.");
                    } else {
                        display.print("That book is not available.");
                    }
                    break;
                case 3: String bookToReturn = display.waitForUserStringInput();
                    boolean returnSuccessful = bookList.returnByTitle(bookToReturn);
                    if (returnSuccessful) {
                        display.print("Thank you for returning the book.");
                    } else {
                        display.print("That is not a valid book to return.");
                    }
                    break;
                case 4: display.print(movieList.printAvailableMovies());
                    break;
                case 5: String movieToCheckout = display.waitForUserStringInput();
                    boolean movieCheckoutSuccessful = movieList.checkoutByName(movieToCheckout);
                case 9: display.print("Bye!");
                    break;
                default: display.print("Select a valid option!");
                    break;
            }
        }
    }
}
