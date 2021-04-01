package com.brian;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Departure {
    DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, YYYY");
    DateTimeFormatter time = DateTimeFormatter.ofPattern("h:m a");

    private LocalDate departureDate;
    private LocalTime departureTime, arrivalTime;
    private int numOfMiles, milesPerHour;

    public String getDepartureDateFormatted() {
        return date.format(departureDate);
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return  departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTimeFormatted() {
        return time.format(arrivalTime);
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getNumOfMiles() {
        return numOfMiles;
    }

    public void setNumOfMiles(int numOfMiles) {
        this.numOfMiles = numOfMiles;
    }

    public int getMilesPerHour() {
        return milesPerHour;
    }

    public void setMilesPerHour(int milesPerHour) {
        this.milesPerHour = milesPerHour;
    }


}