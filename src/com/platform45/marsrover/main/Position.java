package com.platform45.marsrover.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ToDo
 */
public class Position {
    private int x_position;
    private int y_position;
    private char orientation; //Todo introduce constants for N,S,W,E
    private Grid grid;
    
    public Position(int x_position, int y_position, char orientation, Grid grid) {
        this.x_position = x_position;
        this.y_position = y_position;
        this.orientation = orientation;
        this.grid = grid;
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
            y_position += 1;
        } else if (orientation == 'S') {
            y_position -= 1;
        } else if (orientation == 'W') {
            x_position -= 1;
        } else {
            x_position += 1;
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
            return new Position(x_position,y_position,orientation, grid);
        } else {
            throw new IllegalArgumentException("Invalid movement sequence provided as input. Please correct your inputs and try again");
        }
    }
    
}
