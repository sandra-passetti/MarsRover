package com.platform45.marsrover.main;

import java.util.ArrayList;

/**
 * This is the entry point for the Mars Rover implementation built by Sandra Passetti for Platform45. For more information
 * on the Mars Rover challenge, please see https://code.google.com/archive/p/marsrovertechchallenge/.
 *
 * Main will take an input file and print out the final rover positions based on the initial positions and movements
 * specified in the file. Optionally, you may also specify a second input to indicate that you would like the final
 * locations of the mars rovers displayed on a grid.
 */
public class Main {

    private static void printRovers(ArrayList<Rover> rovers) {
        for (Rover rover: rovers) {
            System.out.println("Rover #" + rover.getIdentifier()+ " is at position "
                    + rover.getPosition().getX_Coordinate() + " "
                    + rover.getPosition().getY_Coordinate() + " "
                    + rover.getPosition().getOrientation());
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length == 1) {
                ArrayList<Rover> rovers = FileInputProcessor.processFile(args[0]);
                printRovers(rovers);
            } else if (args.length == 2) {
                ArrayList<Rover> rovers = FileInputProcessor.processFile(args[0]);
                printRovers(rovers);
                if (Boolean.parseBoolean(args[1])) {
                    //render the grid with final locations of the mars rovers graphically
                    RoverMap roverMap = new RoverMap(rovers);
                    roverMap.renderMap();
                }
            } else {
                System.err.println("Please provide one or two arguments to run MarsRover with.");
            }

        } catch (Exception ex) {
            //All exceptions in the system bubble up to this point
            System.err.println(ex.getMessage());
        }
    }
}
