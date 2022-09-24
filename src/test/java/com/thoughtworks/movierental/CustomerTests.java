package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void test() {
    }

    @Test
    void ShouldPrintMovieRentalStatementForCustomer() {

        String  result = "Rental Record for " + "Vikram" + "\n"
                + "\t" + "Avengers\t4.5"+"\n"
                + "\t" + "Vikram\t6.5"+"\n"
                + "\t" + "Other\t15.0"+"\n"
                + "Amount owed is 26.0"+ "\n"
                + "You earned 4 frequent renter points";

        Customer customer = new Customer("Vikram");
        Rental rentalAvengers = new Rental(new Movie("Avengers", Movie.CHILDRENS), 5);
        Rental rentalVikram = new Rental(new Movie("Vikram", Movie.REGULAR), 5);
        Rental rentalOther = new Rental(new Movie("Other", Movie.NEW_RELEASE), 5);
        customer.addRental(rentalAvengers);
        customer.addRental(rentalVikram);
        customer.addRental(rentalOther);

        assertEquals(result, customer.statement());

    }

    @Test
    public void statementShouldReturnTextStmnt() {
        Customer customer = new Customer("Bob");

        customer.addRental(new Rental(new Movie("movie-1", Movie.REGULAR), 5));
        customer.addRental(new Rental(new Movie("movie-2", Movie.CHILDRENS), 10));
        customer.addRental(new Rental(new Movie("movie-2", Movie.NEW_RELEASE), 15));

        assertEquals("Rental Record for Bob\n" +
                "\tmovie-1\t6.5\n" +
                "\tmovie-2\t12.0\n" +
                "\tmovie-2\t45.0\n" +
                "Amount owed is 63.5\n" +
                "You earned 4 frequent renter points", customer.statement());
    }

    @Test
    public void statementShouldReturnHTMLStatement() {
        Customer customer = new Customer("Bob");

        customer.addRental(new Rental(new Movie("movie-1", Movie.REGULAR), 5));
        customer.addRental(new Rental(new Movie("movie-2", Movie.CHILDRENS), 10));
        customer.addRental(new Rental(new Movie("movie-2", Movie.NEW_RELEASE), 15));

        assertEquals("<html><body><h1>Rental Record for <b>Bob</b> " +
                "</h1><br>movie-1 6.5<br>movie-2 12.0<br>movie-2 45.0 <br>Amount owed is " +
                "<b>63.5</b> <br>You earned <b>4</b> frequent renter points " +
                "<br></body></html>",customer.htmlStatment());

    }
}