package com.coderscampus.assignment6;

public class Assignment6Application {
    public static void main(String[] args) {
        SalesDataReportService.printReport(ModelType.MODEL_3, "src/com/coderscampus/assignment6/model3.csv");
        SalesDataReportService.printReport(ModelType.MODEL_S, "src/com/coderscampus/assignment6/modelS.csv");
        SalesDataReportService.printReport(ModelType.MODEL_X, "src/com/coderscampus/assignment6/modelX.csv");
    }
}