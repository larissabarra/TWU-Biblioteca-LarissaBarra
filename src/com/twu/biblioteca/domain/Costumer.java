package com.twu.biblioteca.domain;

public class Costumer extends User {
    private final String name;
    private final String email;
    private final String phone;

    public Costumer(String libraryNumber, String password, String name, String email, String phone) {
        super(libraryNumber, password);
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
