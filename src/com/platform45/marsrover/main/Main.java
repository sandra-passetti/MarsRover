package com.platform45.marsrover.main;

import com.platform45.marsrover.main.FileInputProcessor;

import java.io.IOException;

/**
 * See https://code.google.com/archive/p/marsrovertechchallenge/ for more information.
 */
public class Main {

    public static void main(String[] args) {
        try {
            for (String arg: args) {
                FileInputProcessor.processFile(arg);
            }
        } catch (IOException ioException) {

        }
    }
}
