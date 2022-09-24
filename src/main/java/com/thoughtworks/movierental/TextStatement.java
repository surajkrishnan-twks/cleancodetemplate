package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    public TextStatement() {
    }

    String statement(String customerName, RentalList rentals) {
        return header(customerName) + body(rentals) + footer(rentals.sum(), rentals.frequentRenterPoints());
    }

    String body(List<Rental> rentals) {
        String result = "";
        for (Rental rental : rentals) {
            double figures = rental.amount();
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    figures + "\n";
        }
        return result;
    }

    String header(String customerName) {
        return "Rental Record for " + customerName + "\n";
    }

    String footer(double totalAmount, int frequentRenterPoints) {
        return ("Amount owed is " + totalAmount + "\n") + ("You earned " + frequentRenterPoints
                + " frequent renter points");
    }

}