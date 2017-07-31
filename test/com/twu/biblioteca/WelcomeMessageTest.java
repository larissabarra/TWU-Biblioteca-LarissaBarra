package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageTest {

    @Test
    public void displayWelcomeMessageWhenInitialized() throws Exception {
        WelcomeMessage message = new WelcomeMessage();
        assertEquals("Oi", message.returnWelcomeMessage());
    }

}
