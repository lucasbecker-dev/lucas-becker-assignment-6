package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.util.List;

public class ReportPrinterService {
    public static void printReport (ModelType modelType, List<String> reportData, YearMonth bestMonth, YearMonth worstMonth) {
        if (modelType == null || reportData == null || bestMonth == null || worstMonth == null) {
            System.err.println("ReportPrinterService.printReport cannot accept null data.");
            return;
        }
        System.out.println(modelType + " Yearly Sales Report");
        System.out.println("---------------------------");
        reportData.forEach(System.out::println);
        System.out.println();
        System.out.println("The best month for " + modelType + " was: " + bestMonth);
        System.out.println("The worst month for " + modelType + " was: " + worstMonth);
        System.out.println();
    }

    public static void printReport (ModelType modelType, List<SalesData> reportData) {
        if (modelType == null || reportData == null) {
            System.err.println("ReportPrinterService.printReport cannot accept null data.");
            return;
        }
        YearMonth bestMonth = SalesDataService.getDateAsYearMonth(SalesDataService.findSalesDataBestMonth(reportData));
        YearMonth worstMonth = SalesDataService.getDateAsYearMonth(SalesDataService.findSalesDataWorstMonth(reportData));

        System.out.println(modelType + " Yearly Sales Report");
        System.out.println("---------------------------");
        // TODO: print report data (implement function in SalesDataService first)
        System.out.println();
        System.out.println("The best month for " + modelType + " was: " + bestMonth);
        System.out.println("The worst month for " + modelType + " was: " + worstMonth);
        System.out.println();
    }
}
