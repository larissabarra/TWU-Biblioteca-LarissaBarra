package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserListTest {
    UserList userList = new UserList();

    @Test
    public void userLogin() throws Exception {
        assertNotNull(userList.login("xxx-xxxx", "123"));
    }

    @Test
    public void loginDeniedForWrongPassword() throws Exception {
        assertNull(userList.login("xxx-xxxx", "qwe"));
    }
}
