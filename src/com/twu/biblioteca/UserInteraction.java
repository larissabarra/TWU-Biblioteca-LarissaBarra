package com.twu.biblioteca;

import com.twu.biblioteca.domain.BookList;
import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.domain.WelcomeMessage;

public class UserInteraction {
    private final WelcomeMessage welcomeMessage;
    private final BookList bookList;
    private final IO display;
    private final Menu menu;

    public UserInteraction(WelcomeMessage welcomeMessage, BookList bookList, IO display, Menu menu) {
        this.welcomeMessage = welcomeMessage;
        this.bookList = bookList;
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
                    boolean checkoutSuccessful = bookList.checkoutByTitle(bookToCheckout);
                    if (checkoutSuccessful) {
                        display.print("Thank you! Enjoy the book.");
                    } else {
                        display.print("That book is not available.");
                    }
                    break;
                case 3: String bookToReturn = display.waitForUserStringInput();
                    boolean returnSuccessful = bookList.returnByTitle(bookToReturn);
                    /*if (returnSuccessful) {
                        display.print("Thank you! Enjoy the book.");
                    } else {
                        display.print("That book is not available.");
                    }*/
                    break;
                case 9: display.print("Bye!");
                    break;
                default: display.print("Select a valid option!");
                    break;
            }
        }
    }
}
