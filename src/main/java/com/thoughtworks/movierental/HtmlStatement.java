package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement {
    public HtmlStatement() {
    }

    String htmlStatement(String customerName, RentalList rentals) {
        return "<html><body>" + htmlHeader(customerName) + htmlBody(rentals) + " <br>" + htmlFooter(rentals.sum(), rentals.frequentRenterPoints()) + "</body></html>";
    }

    String htmlBody(List<Rental> rentals) {
        String rentalsHtmlOutput = "";
        for (Rental each : rentals) {
            rentalsHtmlOutput += "<br>" + each.getMovie().getTitle() + " " +
                    each.amount();
        }
        return rentalsHtmlOutput;
    }

    String htmlFooter(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is <b>" + totalAmount + "</b> <br>" +
                "You earned <b>" + frequentRenterPoints + "</b> frequent renter points <br>";
    }

    String htmlHeader(String customerName) {
        return "<h1>Rental Record for <b>" + customerName + "</b> </h1>";
    }
}