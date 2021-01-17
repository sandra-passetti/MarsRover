package com.platform45.marsrover.test;

import com.platform45.marsrover.main.Grid;
import com.platform45.marsrover.main.Position;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void testCalculateNewPosition() {
        Grid grid = new Grid(5,5);
        Position startingPosition = new Position(1,2, 'N',grid);
        String moveCommands = "LMLMLMLMM";
        Position newPosition = startingPosition.calculateNewPosition(moveCommands);
        assertEquals(1, newPosition.getX_Coordinate());
        assertEquals(3, newPosition.getY_Coordinate());
        assertEquals('N', newPosition.getOrientation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateNewPositionWithInvalidMoveCommands() {
        Grid grid = new Grid(5,5);
        Position startingPosition = new Position(1,2, 'N',grid);
        String moveCommands = "LQLMLMLMM";
        startingPosition.calculateNewPosition(moveCommands);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateNewPositionMovingOffMap() {
        Grid grid = new Grid(5,5);
        Position startingPosition = new Position(1,5, 'N',grid);
        String moveCommands = "MM";
        startingPosition.calculateNewPosition(moveCommands);
    }

}