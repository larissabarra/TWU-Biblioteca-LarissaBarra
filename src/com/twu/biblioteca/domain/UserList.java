package com.twu.biblioteca.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserList {
    private List<User> userList;

    public UserList() {
        this.userList = Arrays.asList(new User("xxx-xxxx", "123"),
                new Customer("zzz-zzzz", "qwe", "name","email", "phone"));
    }

    public User login(String libraryNumber, String password) {
        Optional<User> userToLogin = userList.stream().filter(x -> x.getLibraryNumber().equalsIgnoreCase(libraryNumber) && x.getPassword().equals(password)).findFirst();
        return userToLogin.isPresent() ? userToLogin.get() : null;
    }
}
