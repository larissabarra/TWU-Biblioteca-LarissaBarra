package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CostumerTest {
    @Test
    public void CostumerHasName() throws Exception {
        Costumer costumer = new Costumer("xxx-xxxx", "123", "name","email", "phone");
        assertEquals("name", costumer.getName());
    }

    @Test
    public void CostumerHasEmail() throws Exception {
        Costumer costumer = new Costumer("xxx-xxxx", "123", "name","email", "phone");
        assertEquals("email", costumer.getEmail());
    }

    @Test
    public void CostumerHasPhone() throws Exception {
        Costumer costumer = new Costumer("xxx-xxxx", "123", "name","email", "phone");
        assertEquals("phone", costumer.getPhone());
    }
}
