package com.teachmeskills.lesson_25.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Logger {

    public static void log(String message) throws IOException {

        try{

            String logMessage = LocalDateTime.now() + ": " + message;
            Files.write(Paths.get("log.txt"),logMessage.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }
    }
}
