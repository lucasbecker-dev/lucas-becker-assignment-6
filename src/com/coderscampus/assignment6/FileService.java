package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import java.time.YearMonth;

public class FileService {
    public static List<SalesData> readFile(String filepath){
        List<SalesData> salesData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            Stream<String> lines = reader.lines().skip(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.US);
            lines.forEach(line -> {
                String[] splitLine = line.split(",");
                YearMonth yearMonth = YearMonth.parse(splitLine[0], formatter);
                Integer sales = Integer.parseInt(splitLine[1]);
                salesData.add(new SalesData(yearMonth, sales));
            });
        } catch (IOException e) {
            System.err.println("Unable to read file: " + filepath);
            System.err.println(e.getMessage());
        } catch (DateTimeParseException e) {
            System.err.println("Year and month in csv file: " + filepath + " could not be parsed.");
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Number of sales in: " + filepath + " could not be parsed.");
            System.err.println(e.getMessage());
        }

        return salesData;
    }
}
