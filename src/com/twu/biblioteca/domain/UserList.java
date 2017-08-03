package com.twu.biblioteca.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserList {
    private List<User> userList;

    public UserList() {
        this.userList = Arrays.asList(new User("user 1", "email 1", "123", "xxx", "xxx-xxxx"),
                new User("user 2", "email 2", "qwe", "zzz", "zzz-zzzz"));
    }

    public User login(String libraryNumber, String password) {
        Optional<User> userToLogin = userList.stream().filter(x -> x.getLibraryNumber().equalsIgnoreCase(libraryNumber) && x.getPassword().equals(password)).findFirst();
        return userToLogin.isPresent() ? userToLogin.get() : null;
    }
}
