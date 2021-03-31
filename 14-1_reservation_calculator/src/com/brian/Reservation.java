package com.brian;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Reservation {
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, YYYY");

    private LocalDate arrivalDate, departureDate;
    private final double NIGHTLY_RATE = 145.00;



    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfNights() {
        return Period.between(arrivalDate, departureDate).getDays();
    }

    public double getTotalPrice() {
        return getNumberOfNights() * NIGHTLY_RATE;
    }

    public String getArrivalDateFormatted() {
        return "Arrival Date: " + dtf.format(arrivalDate);

    }

    public String getDepartureDateFormatted() {
        return "Departure Date: " + dtf.format(departureDate);
    }

    public String getPricePerNightFormatted() {
       return "Price: " + nf.format(NIGHTLY_RATE) + " per night";
    }

    public String getTotalPriceFormatted() {
        return "Total price: " + nf.format(getTotalPrice()) + " for " + getNumberOfNights() + " nights";
    }
}