package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileService {
    public static List<SalesData> readFile(String filepath){
        List<SalesData> salesData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            Stream<String> lines = reader.lines().skip(1);
            lines.forEach(line -> {
                String[] splitLine = line.split(",");
                salesData.add(new SalesData(splitLine[0], splitLine[1]));
            });
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return salesData;
    }
}
