package com.platform45.marsrover.main;

import java.io.IOException;
import java.util.ArrayList;

/**
 * See https://code.google.com/archive/p/marsrovertechchallenge/ for more information.
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
