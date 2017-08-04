package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CostumerTest {
    Costumer costumer = new Costumer("xxx-xxxx", "123", "name","email", "phone");

    @Test
    public void CostumerHasName() throws Exception {
        assertEquals("name", costumer.getName());
    }

    @Test
    public void CostumerHasEmail() throws Exception {
        assertEquals("email", costumer.getEmail());
    }

    @Test
    public void CostumerHasPhone() throws Exception {
        assertEquals("phone", costumer.getPhone());
    }
}
