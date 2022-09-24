package com.thoughtworks.movierental;

import java.util.ArrayList;

public class RentalList extends ArrayList<Rental> {

    RentalList () {

    }

    public double sum() {
        return this.stream().mapToDouble(Rental::amount).sum();
    }

    int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this) {
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    &&
                    rental.getDaysRented() > 1) frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
