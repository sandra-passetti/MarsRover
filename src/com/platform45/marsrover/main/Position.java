package com.platform45.marsrover.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Position class tracks the coordination and orientation of an object on a specified grid. This class also facilitates
 * movement within the grid, by accepting commands to rotate left and right; and to move forward one space in the current
 * orientation.
 */
public class Position {
    private int x_coordinate;
    private int y_coordinate;
    private char orientation;
    private final Grid grid;

    private final char NORTH = 'N';
    private final char SOUTH = 'S';
    private final char EAST = 'E';
    private final char WEST = 'W';

    /**
     * Constructor for position.
     * @param x_coordinate The horizontal coordinate indicating position on the grid.
     * @param y_coordinate The vertical coordinate indicating position on the grid.
     * @param orientation Must be a single character from the set {N, E, S, W}.
     * @param grid The grid relative to which position is being specified.
     */
    public Position(int x_coordinate, int y_coordinate, char orientation, Grid grid) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.orientation = orientation;
        this.grid = grid;
    }

    public int getX_Coordinate() {
        return x_coordinate;
    }

    public int getY_Coordinate() {
        return y_coordinate;
    }

    public char getOrientation() {
        return orientation;
    }

    private boolean areCommandsValid(String movements){
        Pattern pattern = Pattern.compile("^[LRM]*$");
        Matcher matcher = pattern.matcher(movements);
        return matcher.find();
    }

    private void rotateOrientationLeft(){
        if (orientation == NORTH) {
            orientation = WEST;
        } else if (orientation == WEST) {
            orientation = SOUTH;
        } else if (orientation == SOUTH) {
            orientation = EAST;
        } else {
            orientation = NORTH;
        }
    }

    private void rotateOrientationRight(){
        if (orientation == NORTH) {
            orientation = EAST;
        } else if (orientation == EAST) {
            orientation = SOUTH;
        } else if (orientation == SOUTH) {
            orientation = WEST;
        } else {
            orientation = NORTH;
        }
    }

    private void moveForward(){
        if (orientation == NORTH) {
            y_coordinate += 1;
        } else if (orientation == SOUTH) {
            y_coordinate -= 1;
        } else if (orientation == WEST) {
            x_coordinate -= 1;
        } else {
            x_coordinate += 1;
        }
    }

    public Position calculateNewPosition(String movements) {
        //validate movement commands
        if (areCommandsValid(movements)) {
            //update x,y and orientation
            for (char move: movements.toCharArray()) {
                if (move == 'L') {
                    rotateOrientationLeft();
                } else if (move == 'R') {
                    rotateOrientationRight();
                } else {
                    moveForward();
                }
            }
            //check that new positions are within map
            if (grid.validateCoordinates(x_coordinate, y_coordinate)) {
                //return new position
                return new Position(x_coordinate, y_coordinate,orientation, grid);
            } else {
                throw new IndexOutOfBoundsException("Requested movement sequence leads to a position outside the grid boundaries. " +
                        "Please correct your inputs and try again");
            }
        } else {
            throw new IllegalArgumentException("Invalid movement sequence provided as input. " +
                    "Please correct your inputs and try again");
        }
    }
    
}
