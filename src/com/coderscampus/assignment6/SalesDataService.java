package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class SalesDataService {
    public static YearMonth getDateAsYearMonth(SalesData salesData) {
        String month = salesData.getDate().split("-")[0];
        String year = "20" + salesData.getDate().split("-")[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM", Locale.getDefault());
        return YearMonth.parse(year + "-" + month, formatter);
    }

    public static Integer getSalesAsInteger(SalesData salesData) {
        Integer convertedSales = null;
        try {
            convertedSales = Integer.parseInt(salesData.getSales());
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return convertedSales;
    }

    public static SalesData findSalesDataBestMonth(List<SalesData> salesDataList) {
        Optional<SalesData> bestMonthOpt = salesDataList
                .stream()
                .max(Comparator.comparingInt(SalesDataService::getSalesAsInteger));
        return bestMonthOpt.orElse(null);
    }

    public static SalesData findSalesDataWorstMonth(List<SalesData> salesDataList) {
        Optional<SalesData> worstMonthOpt = salesDataList
                .stream()
                .min(Comparator.comparingInt(SalesDataService::getSalesAsInteger));
        return worstMonthOpt.orElse(null);
    }

    public static String formatSalesData(List<SalesData> salesDataList) {
        // TODO: complete this message
        salesDataList.stream().forEach(data -> {
            String formattedData;
        });
    }
}
