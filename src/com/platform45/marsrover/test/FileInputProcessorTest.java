package com.platform45.marsrover.test;

import static org.junit.Assert.*;

import com.platform45.marsrover.main.FileInputProcessor;
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
        Position actualPosition = rovers.get(0).getPosition();
        assertEquals(1, actualPosition.getX_Coordinate());
        assertEquals(3, actualPosition.getY_Coordinate());
        assertEquals('N', actualPosition.getOrientation());
        assertEquals(1, rovers.get(0).getIdentifier());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProcessFileForInvalidGrid() throws IOException {
        FileInputProcessor.processFile("./resources/invalidGrid.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProcessFileForInvalidMovement() throws IOException {
        FileInputProcessor.processFile("./resources/invalidMovementRequest.txt");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testProcessFileForInvalidStartingPosition() throws IOException {
        FileInputProcessor.processFile("./resources/invalidStartingPosition.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProcessFileForInvalidFileFormat() throws IOException {
        FileInputProcessor.processFile("./resources/invalidFileFormat.txt");
    }
}