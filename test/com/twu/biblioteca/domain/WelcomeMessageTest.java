package com.twu.biblioteca.domain;

import com.twu.biblioteca.domain.WelcomeMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageTest {

    @Test
    public void displayWelcomeMessageWhenInitialized() throws Exception {
        WelcomeMessage message = new WelcomeMessage();
        assertEquals("Hi, welcome to Biblioteca!\n", message.returnWelcomeMessage());
    }

}
