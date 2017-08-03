package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CostumerTest {
    @Test
    public void CostumerHasName() throws Exception {
        Costumer costumer = new Costumer("name", "email", "123","phone", "xxx-xxxx");
        assertEquals("name", costumer.getName());
    }

    @Test
    public void CostumerHasEmail() throws Exception {
        Costumer costumer = new Costumer("name", "email", "123","phone", "xxx-xxxx");
        assertEquals("email", costumer.getEmail());
    }

    @Test
    public void CostumerHasPhone() throws Exception {
        Costumer costumer = new Costumer("name", "email", "123","phone", "xxx-xxxx");
        assertEquals("phone", costumer.getPhone());
    }
}
