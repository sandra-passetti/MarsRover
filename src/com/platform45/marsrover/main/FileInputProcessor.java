package com.platform45.marsrover.main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileInputProcessor {

    public static ArrayList<Rover> processFile(String fileLocation) throws IOException {
        ArrayList<Rover> rovers = new ArrayList<>();

        List<String> instructions = Files.readAllLines(Paths.get(fileLocation));

        //there must be at least 3 instructions
        if (instructions.size() < 3) {
            throw new IllegalArgumentException("The provided input does not contain enough instructions to successfully navigate.");
        }

        //the first instruction must be the grid coordinates for the top right corner
        String[] gridCoordinates = instructions.get(0).split("[ ]");

        //there must be 2 inputs on the first line
        if (gridCoordinates.length != 2) {
            throw new IllegalArgumentException("The input must start with two numbers, indicating the top right x and y coordinates.");
        }
        int x_coordinate = Integer.parseInt(gridCoordinates[0]);
        int y_coordinate = Integer.parseInt(gridCoordinates[1]);
        Grid grid = new Grid(x_coordinate, y_coordinate);

        //the rest of the instructions must contain pairs of rover initial positions and movement commands.
        //each pair should be processed by reading it into a rover and then moving it as specified
        int roverCount = 1;
        for (int i = 1; i < instructions.size(); i+=2) {
            String[] initialPosition = instructions.get(i).split("[ ]");
            //there must be 3 inputs to indicate initial position
            if (initialPosition.length != 3) {
                throw new IllegalArgumentException("The initial position was not specified correctly for rover number " + roverCount);
            }
            int tmp_x = Integer.parseInt(initialPosition[0]);
            int tmp_y = Integer.parseInt(initialPosition[1]);
            char tmp_orientation = initialPosition[2].charAt(0);
            Position initialRoverPosition = new Position(tmp_x, tmp_y, tmp_orientation, grid );
            Position updatedRoverPosition = initialRoverPosition.calculateNewPosition(instructions.get(i+1));
            rovers.add(new Rover(roverCount, updatedRoverPosition));
            roverCount++;
        }

        return rovers;
    }

}