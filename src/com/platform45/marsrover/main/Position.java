package com.platform45.marsrover.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ToDo
 */
public class Position {
    private int x_coordinate;
    private int y_coordinate;
    private char orientation; //Todo introduce constants for N,S,W,E
    private Grid grid;
    
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
        if (orientation == 'N') {
            orientation = 'W';
        } else if (orientation == 'W') {
            orientation = 'S';
        } else if (orientation == 'S') {
            orientation = 'E';
        } else {
            orientation = 'N';
        }
    }

    private void rotateOrientationRight(){
        if (orientation == 'N') {
            orientation = 'E';
        } else if (orientation == 'E') {
            orientation = 'S';
        } else if (orientation == 'S') {
            orientation = 'W';
        } else {
            orientation = 'N';
        }
    }

    private void moveForward(){
        if (orientation == 'N') {
            y_coordinate += 1;
        } else if (orientation == 'S') {
            y_coordinate -= 1;
        } else if (orientation == 'W') {
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
            //return new position
            return new Position(x_coordinate, y_coordinate,orientation, grid);
        } else {
            throw new IllegalArgumentException("Invalid movement sequence provided as input. Please correct your inputs and try again");
        }
    }
    
}
