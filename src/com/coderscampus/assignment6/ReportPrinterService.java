package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.util.List;

public class ReportPrinterService {
    public static void printReport (String model, List<String> reportData, YearMonth bestMonth, YearMonth worstMonth) {
        if (model == null || reportData == null || bestMonth == null || worstMonth == null) {
            System.err.println("ReportPrinterService.printReport cannot accept null data.");
            return;
        }
        System.out.println(model + " Yearly Sales Report");
        System.out.println("---------------------------");
        reportData.forEach(System.out::println);
        System.out.println();
        System.out.println("The best month for " + model + " was: " + bestMonth);
        System.out.println("The worst month for " + model + " was: " + worstMonth);
        System.out.println();
    }
}
