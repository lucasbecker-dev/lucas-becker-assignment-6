package com.coderscampus.assignment6;

import java.util.List;

public class Assignment6Application {
    public static void main(String[] args) {
        List<SalesData> model3 = FileService.readFile("src/com/coderscampus/assignment6/model3.csv");
        List<SalesData> modelS = FileService.readFile("src/com/coderscampus/assignment6/modelS.csv");
        List<SalesData> modelX = FileService.readFile("src/com/coderscampus/assignment6/modelX.csv");

        ReportPrinterService.printReport(ModelType.MODEL_3, model3);
        ReportPrinterService.printReport(ModelType.MODEL_S, modelS);
        ReportPrinterService.printReport(ModelType.MODEL_X, modelX);
    }
}