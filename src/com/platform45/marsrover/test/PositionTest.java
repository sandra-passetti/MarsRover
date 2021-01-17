package com.platform45.marsrover.test;

import com.platform45.marsrover.main.FileInputProcessor;
import com.platform45.marsrover.main.Grid;
import com.platform45.marsrover.main.Position;
import com.platform45.marsrover.main.Rover;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void testCalculateNewPosition() {
        Grid grid = new Grid(5,5);
        Position startingPosition = new Position(1,2, 'N',grid);
        String moveCommands = "LMLMLMLMM";
        Position newPosition = startingPosition.calculateNewPosition(moveCommands);
        Position expectedPosition = new Position(1,3,'N',grid);
        assertEquals(expectedPosition, newPosition);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateNewPositionWithInvalidMoveCommands() {
        Grid grid = new Grid(5,5);
        Position startingPosition = new Position(1,2, 'N',grid);
        String moveCommands = "LQLMLMLMM";
        startingPosition.calculateNewPosition(moveCommands);
    }

}