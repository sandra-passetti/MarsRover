package com.platform45.marsrover.test;

import com.platform45.marsrover.main.Grid;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GridTest {

    @Test
    public void testValidateCoordinates() {
        Grid grid = new Grid(5,5);
        assertTrue(grid.validateCoordinates(5,4));
    }

    @Test
    public void testValidateCoordinatesWithInvalidExample() {
        Grid grid = new Grid(5,5);
        assertFalse(grid.validateCoordinates(5,6));
    }

    @Test
    public void testValidateCoordinatesWithNegativeExample() {
        Grid grid = new Grid(6,7);
        assertFalse(grid.validateCoordinates(-1,7));
    }
}
