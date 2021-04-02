package com.brian;


import java.time.LocalDate;
import java.time.LocalTime;

public class ArrivalTimeEstimator {
    Departure d = new Departure();
    Console c = new Console();
    String cont = "y";

    public void estimateArrival() {
        System.out.println("Arrival Time Estimator");
        while (cont.equals("y") || cont.equals("Y")) {
            departure();
            arrival();
            cont = c.getContinueString("Continue? (y/n)");
        }
        System.out.println("\nBye!");
    }

    public void departure() {
        d.setDepartureDate(LocalDate.parse(c.getString("\nDeparture date (YYYY-MM-DD): ").trim()));
        d.setDepartureTime(LocalTime.parse(c.getString("Departure time (HH:MM): ").trim()));
        d.setNumOfMiles(c.getInt("Number of miles: ", 1, 99999));
        d.setMilesPerHour(c.getInt("Miles per hour: ", 1, 1337));
    }

    public void arrival() {
        int hours = (d.getNumOfMiles()/d.getMilesPerHour());
        int minutes = (d.getNumOfMiles()%d.getMilesPerHour());
        d.setArrivalTime(d.getDepartureTime().plusHours(hours).plusMinutes(minutes));

        System.out.println("\nEstimated travel time");
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.println("Estimated date of arrival: " + d.getDepartureDateFormatted());
        System.out.println("Estimate time of arrival: " + d.getArrivalTimeFormatted());
    }


}