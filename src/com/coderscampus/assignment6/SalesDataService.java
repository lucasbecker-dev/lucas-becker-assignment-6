package com.coderscampus.assignment6;

import java.time.DateTimeException;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesDataService {

    public static Optional<String> parseYearMonthToString(SalesData salesData) {
        final String DEFAULT_FORMAT_PATTERN = "yyyy-MM";
        try {
            return Optional.of(salesData.getDate().format(DateTimeFormatter.ofPattern(DEFAULT_FORMAT_PATTERN)));
        } catch (NullPointerException | DateTimeException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    public static Optional<String> parseYearMonthToString(SalesData salesData, String formatPattern) {
        try {
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