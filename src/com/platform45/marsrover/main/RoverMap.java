package com.platform45.marsrover.main;

import java.util.ArrayList;

public class RoverMap {
    private final ArrayList<Rover> rovers;

    public RoverMap(ArrayList<Rover> rovers) {
        this.rovers = rovers;
    }

    public void renderMap() {
        if (rovers.isEmpty()) {
            throw new IllegalStateException("Cannot render map if no rovers were supplied.");
        }

        System.out.println("\nRover Map: \n==========");

        Grid grid = rovers.get(0).getGrid();
        int max_x_coordinate = grid.getMaxXCoordinate();
        int max_y_coordinate = grid.getMaxYCoordinate();

        String[][] roverMap = new String[max_x_coordinate + 1][max_y_coordinate + 1];

        for (Rover rover : rovers) {
            Position roverPosition = rover.getPosition();
            int gridColumnNumber = roverPosition.getX_Coordinate() ;
            int gridRowNumber = roverPosition.getY_Coordinate();
            roverMap[gridRowNumber][gridColumnNumber] = "|" + rover.getIdentifier() + roverPosition.getOrientation() + "|";
        }

        for(int i = max_y_coordinate; i >= 0; i--) {
            for (int j = 0; j <= max_x_coordinate; j++) {
                if (roverMap[i][j] == null || roverMap[i][j].isEmpty()) {
                    System.out.print("|--|");
                } else {
                    System.out.print(roverMap[i][j]);
                }
            }
            System.out.println();
        }


    }
}
