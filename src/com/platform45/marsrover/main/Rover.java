package com.platform45.marsrover.main;

import com.platform45.marsrover.main.Position;

/**
 * The rover, which has a position on a grid representing a spot in the physical space of a plateau on Mars.
 */
public class Rover {
    private Position position;

    public Rover(Position initialPosition) {
        position = initialPosition;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position newPosition){
        position = newPosition;
    }
}
