package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Assignment6Application {
    public static void main(String[] args) {
        List<SalesData> model3 = FileService.readFile("src/com/coderscampus/assignment6/model3.csv");
        List<SalesData> modelS = FileService.readFile("src/com/coderscampus/assignment6/modelS.csv");
        List<SalesData> modelX = FileService.readFile("src/com/coderscampus/assignment6/modelX.csv");

        System.out.println(SalesDataService.groupSalesByYear(model3));

        Optional<SalesData> model3WorstMonthOpt = modelX.stream().min(Comparator.comparingInt(SalesDataService::getSalesAsInteger));
        Optional<SalesData> modelSWorstMonthOpt = modelX.stream().min(Comparator.comparingInt(SalesDataService::getSalesAsInteger));
        Optional<SalesData> modelXWorstMonthOpt = modelX.stream().min(Comparator.comparingInt(SalesDataService::getSalesAsInteger));

        Stream<YearMonth> yearMonthModel3 = model3.stream().map(SalesDataService::getDateAsYearMonth);
        Stream<YearMonth> yearMonthModelS = modelS.stream().map(SalesDataService::getDateAsYearMonth);
        Stream<YearMonth> yearMonthModelX = modelX.stream().map(SalesDataService::getDateAsYearMonth);

//        yearMonthModel3.forEach(System.out::println);
//
//        System.out.println("Model 3 Yearly Sales Report");
//        System.out.println("---------------------------");

    }
}