package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserListTest {
    @Test
    public void userLogin() throws Exception {
        UserList userList = new UserList();
        assertNotNull(userList.login("xxx-xxxx", "123"));
    }

    @Test
    public void loginDeniedForWrongPassword() throws Exception {
        UserList userList = new UserList();
        assertNull(userList.login("xxx-xxxx", "qwe"));
    }
}
