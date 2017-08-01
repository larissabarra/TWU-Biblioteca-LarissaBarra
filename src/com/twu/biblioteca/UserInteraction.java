package com.twu.biblioteca;

import java.util.Scanner;

public class UserInteraction {
    private final WelcomeMessage welcomeMessage;
    private final BookList bookList;
    private final Display display;
    private final Menu menu;

    public UserInteraction(WelcomeMessage welcomeMessage, BookList bookList, Display display, Menu menu) {
        this.welcomeMessage = welcomeMessage;
        this.bookList = bookList;
        this.display = display;
        this.menu = menu;
    }

    public void execute() {
        display.print(welcomeMessage.returnWelcomeMessage());
        display.print(menu.showMenu());
        int choice = display.waitForUserInput();
        switch(choice) {
            case 1: display.print(bookList.printBookList());
                break;
        }
    }
}
