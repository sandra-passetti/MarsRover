package com.platform45.marsrover.test;

import static org.junit.Assert.*;

import com.platform45.marsrover.main.FileInputProcessor;
import com.platform45.marsrover.main.Grid;
import com.platform45.marsrover.main.Position;
import com.platform45.marsrover.main.Rover;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class FileInputProcessorTest {

    @Test
    public void testProcessFileForValidInput() throws IOException {
        ArrayList<Rover> rovers = FileInputProcessor.processFile("./resources/validInputExample.txt");
        assertEquals(2, rovers.size());
        Grid expectedGrid = new Grid(5,5);
        Position expectedPosition1 = new Position(1,3, 'N',expectedGrid);
        Rover expectedRover1 = new Rover(1, expectedPosition1);
        assertEquals(expectedRover1, rovers.get(0));
    }

}