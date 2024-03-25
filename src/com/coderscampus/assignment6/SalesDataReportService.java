package com.coderscampus.assignment6;

import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class SalesDataReportService {

    public static void printReport(ModelType modelType, List<SalesData> reportData) {
        try {
            BestAndWorstMonth bestAndWorstMonths = getBestAndWorstMonths(reportData);
            List<String> reportToPrint = formatSalesByYearToPrint(reportData);

            System.out.println();
            System.out.println(modelType + " Yearly Sales Report");
            System.out.println("---------------------------");
            reportToPrint.forEach(System.out::println);
            System.out.println();
            System.out.println("The best month for " + modelType + " was: " + bestAndWorstMonths.BEST_MONTH);
            System.out.println("The worst month for " + modelType + " was: " + bestAndWorstMonths.WORST_MONTH);
        } catch (NoSuchElementException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

    private static BestAndWorstMonth getBestAndWorstMonths(List<SalesData> reportData) throws NoSuchElementException {
        SalesData salesDataWithBestMonth = SalesDataService.findSalesDataBestMonth(reportData).orElseThrow();
        String bestMonth = SalesDataService.parseYearMonthToString(salesDataWithBestMonth).orElseThrow();
        SalesData salesDataWithWorstMonth = SalesDataService.findSalesDataWorstMonth(reportData).orElseThrow();
        String worstMonth = SalesDataService.parseYearMonthToString(salesDataWithWorstMonth).orElseThrow();

        return new BestAndWorstMonth(bestMonth, worstMonth);
    }

    private static List<String> formatSalesByYearToPrint(List<SalesData> reportData) throws NoSuchElementException {
        Map<Year, Integer> groupedData = SalesDataService.groupSalesByYear(reportData).orElseThrow();
        return groupedData.entrySet().stream()
                .map(entry -> entry.getKey().toString() + " -> " + entry.getValue())
                .collect(Collectors.toList());
    }

    private static class BestAndWorstMonth {
        private final String BEST_MONTH;
        private final String WORST_MONTH;

        private BestAndWorstMonth(String bestMonth, String worstMonth) {
            this.BEST_MONTH = bestMonth;
            this.WORST_MONTH = worstMonth;
        }
    }

}
