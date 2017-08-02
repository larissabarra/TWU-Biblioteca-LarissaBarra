package com.twu.biblioteca;

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
        int choice = 0;
        while (choice != 9) {
            display.print(menu.showMenu());
            choice = display.waitForUserIntInput();
            switch (choice) {
                case 1: display.print(bookList.printAvailableBooks());
                    break;
                case 2: String bookTitle = display.waitForUserStringInput();
                    display.print(bookTitle);
                    break;
                case 9: display.print("Bye!");
                    break;
                default: display.print("Select a valid option!");
                    break;
            }
        }
    }
}
