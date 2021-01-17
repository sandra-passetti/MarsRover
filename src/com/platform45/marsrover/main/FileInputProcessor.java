package com.platform45.marsrover.main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInputProcessor {

    public static ArrayList<Rover> processFile(String fileLocation) throws IOException {
        ArrayList<Rover> rovers = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(fileLocation);
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
        return rovers;
    }

}