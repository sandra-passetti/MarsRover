package com.platform45.marsrover.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ToDo
 */
public class Position {
    private int x_position;
    private int y_position;
    private char orientation;
    private Grid grid; //ToDo - should this be on position or rover?
    
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

    public Position calculateNewPosition(String movements) {
        //validate movement commands
        if (areCommandsValid(movements)) {
            //update x,y and orientation
            //check that new positions are within map
            //return new position
            return new Position(1,1,'N', null);
        } else {
            throw new IllegalArgumentException("Invalid movement sequence provided as input. Please correct your inputs and try again");
        }
    }
    
}
