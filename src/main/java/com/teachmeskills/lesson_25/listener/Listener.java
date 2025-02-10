package com.teachmeskills.lesson_25.listener;

import com.teachmeskills.lesson_25.services.Logger;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

import java.io.IOException;

@WebListener
public class Listener implements HttpSessionAttributeListener {

    public void sessionCreated(HttpSessionBindingEvent event) throws IOException {
        if (event.getName().equals("username")) {
            Logger.log("User with username : '" + event.getValue() + "' has logged in.");
        }
    }

    public void sessionDestroyed(HttpSessionBindingEvent event) throws IOException {
        if (event.getName().equals("username")) {
            Logger.log("User with username: '" + event.getValue() + "' has logged out.");
        }
    }
}
