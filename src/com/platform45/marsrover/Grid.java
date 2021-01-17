package com.platform45.marsrover;

/**
 * The grid defines the boundaries within which a rover can move (all valid positions must occur inside the grid).
 * The lower left coordinates on the grid is always designated as 0,0 (x_coordinate, y_coordinate).
 * The upper right coordinates on the grid must be supplied. A valid example would be 5,5 (x_coordinate, y_coordinate).
 */
public class Grid {
    private final int min_x_coordinate = 0;
    private final int min_y_coordinate = 0;
    private int max_x_coordinate;
    private int max_y_coordinate;

    public Grid(int max_x_coordinate, int max_y_coordinate) {
        this.max_x_coordinate = max_x_coordinate;
        this.max_y_coordinate = max_y_coordinate;
    }

    public boolean validateCoordinates(int x_coordinate, int y_coordinate) {
        //todo: determine if supplied coordinates are within the grid
        return true;
    }


}
