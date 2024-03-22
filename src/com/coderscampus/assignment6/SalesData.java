package com.coderscampus.assignment6;

public class SalesData {
    private String date;
    private String sales;

    public SalesData(String date, String sales) {
        this.date = date;
        this.sales = sales;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "SalesData{" +
                "date='" + date + '\'' +
                ", sales='" + sales + '\'' +
                '}';
    }
}
