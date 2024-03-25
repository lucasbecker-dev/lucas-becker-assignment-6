package com.coderscampus.assignment6;

import java.time.DateTimeException;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class SalesDataService {

    public static Optional<String> parseYearMonthToString(SalesData salesData, Optional<String> optionalFormatPattern) {
        final String DEFAULT_FORMATTER_PATTERN = "yyyy-MM";
        try {
            String formatPattern = optionalFormatPattern.orElse(DEFAULT_FORMATTER_PATTERN);
            return Optional.of(salesData.getDate().format(DateTimeFormatter.ofPattern(formatPattern)));
        } catch (NullPointerException | DateTimeException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    public static Optional<String> parseSalesToString(SalesData salesData) {
        try {
            return Optional.of(salesData.getSales().toString());
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    public static Optional<SalesData> findSalesDataBestMonth(List<SalesData> salesDataList) {
        try {
            return Optional.of(salesDataList
                            .stream()
                            .max(Comparator.comparingInt(SalesData::getSales)))
                    .orElse(Optional.empty());
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    public static Optional<SalesData> findSalesDataWorstMonth(List<SalesData> salesDataList) {
        try {
            return Optional.of(salesDataList
                            .stream()
                            .min(Comparator.comparingInt(SalesData::getSales)))
                    .orElse(Optional.empty());
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    public static Optional<Map<Year, Integer>> groupSalesByYear(List<SalesData> salesDataList) {
        try {
            Map<Year, Integer> salesPerYear = salesDataList
                    .stream()
                    .collect(Collectors.groupingBy(
                            salesData -> Year.of(salesData.getDate().getYear()),
                            Collectors.summingInt(SalesData::getSales)
                    ));
            return Optional.of(salesPerYear);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }
}