package com.platform45.marsrover.main;

import java.io.*;
import java.util.Scanner;

public class FileInputProcessor {

    public static void processFile(String fileLocation) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(fileLocation);
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
    }

}