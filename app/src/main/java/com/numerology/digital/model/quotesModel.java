package com.numerology.digital.model;

public class quotesModel {
    String date;
    String quotes;

    public quotesModel(String date, String quotes) {
        this.date = date;
        this.quotes = quotes;
    }

    public quotesModel() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }
}
