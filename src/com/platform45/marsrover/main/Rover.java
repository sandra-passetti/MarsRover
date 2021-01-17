package com.platform45.marsrover.main;

/**
 * The rover, which has a position on a grid representing its spot in the physical space of a plateau on Mars.
 */
public class Rover {
    private final int identifier;
    private Position position;

    public Rover(int identifier, Position initialPosition) {
        this.identifier = identifier;
        position = initialPosition;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position newPosition){
        position = newPosition;
    }

    public int getIdentifier(){
        return identifier;
    }
}
