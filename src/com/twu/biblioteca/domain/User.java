package com.twu.biblioteca.domain;

public class User {
    private final String name;
    private final String email;
    private final String password;
    private final String phone;
    private final String libraryNumber;

    public User(String name, String email, String password, String phone, String libraryNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
