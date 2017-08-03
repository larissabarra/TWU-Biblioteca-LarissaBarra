package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void userHasLibraryNumber() throws Exception {
        User user = new User("name", "email", "123","phone", "xxx-xxxx");
        assertEquals("xxx-xxxx", user.getLibraryNumber());
    }
}
