package com.platform45.marsrover.test;

import static org.junit.Assert.*;

import com.platform45.marsrover.main.FileInputProcessor;
import org.junit.Test;

import java.io.IOException;

public class FileInputProcessorTest {

    @Test
    public void testProcessFileForValidInput() throws IOException {
        FileInputProcessor.processFile("./resources/validInputExample.txt");
    }

}