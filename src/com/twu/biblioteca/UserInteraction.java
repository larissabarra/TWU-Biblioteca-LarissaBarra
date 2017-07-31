package com.twu.biblioteca;

public class UserInteraction {
    private final WelcomeMessage welcomeMessage;
    private final BookList bookList;
    private final Display display;

    public UserInteraction(WelcomeMessage welcomeMessage, BookList bookList, Display display) {
        this.welcomeMessage = welcomeMessage;
        this.bookList = bookList;
        this.display = display;
    }

    public void execute() {
        display.print(welcomeMessage.returnWelcomeMessage());
        display.print(bookList.getBookList().toString());
    }
}
