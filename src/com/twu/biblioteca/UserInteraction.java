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
        display.print(menu.showMenu());
    }

    public String printBookList() {
        String list = "";
        for (Object book : bookList.getBookList()) {
            list += book.toString() + "\n";
        }
        return list;
    }
}
