package com.twu.biblioteca.domain;

public class User {
    protected final String password;
    protected final String libraryNumber;

    public User(String libraryNumber, String password) {
        this.password = password;
        this.libraryNumber = libraryNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }
}
