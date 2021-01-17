package com.platform45.marsrover.main;

import java.util.ArrayList;

/**
 * This is the entry point for the Mars Rover implementation built by Sandra Passetti for Platform45. For more information
 * on the Mars Rover challenge, please see https://code.google.com/archive/p/marsrovertechchallenge/ for more information.
 *
 * Main will take an input file and print out the final rover positions based on the initial positions and movements
 * specified in the file.
 *
 * @param args Args must contain one or more files to use as input..
 */
public class Main {

    public static void main(String[] args) {
        try {
            ArrayList<Rover> rovers = new ArrayList<>();
            for (String arg: args) {
                rovers = FileInputProcessor.processFile(arg);
            }

            for (Rover rover: rovers) {
                System.out.println("Rover #" + rover.getIdentifier()+ " is at position "
                        + rover.getPosition().getX_Coordinate() + " "
                        + rover.getPosition().getY_Coordinate() + " "
                        + rover.getPosition().getOrientation());
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
