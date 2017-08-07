package com.twu.biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer = new Customer("xxx-xxxx", "123", "name","email", "phone");

    @Test
    public void CostumerHasName() throws Exception {
        assertEquals("name", customer.getName());
    }

    @Test
    public void CostumerHasEmail() throws Exception {
        assertEquals("email", customer.getEmail());
    }

    @Test
    public void CostumerHasPhone() throws Exception {
        assertEquals("phone", customer.getPhone());
    }
}
