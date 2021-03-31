package com.brian;

import java.time.LocalDate;

public class ReservationCalculator {
    Console c = new Console();
    Reservation r = new Reservation();
    private String cont = "y";

    public void calc() {
        System.out.println("Reservation Calculator");
        while (cont.equals("y") || cont.equals("Y")) {
            arrival();
            departure();
            printCalc();

            cont = c.getContinueString("Continue? (y/n)");
        }
        System.out.println("\nBye!");
    }

    public void arrival() {
        int arrivalMonth, arrivalDay, arrivalYear;
        arrivalMonth = c.getInt("\nEnter the arrival month(1-12): ", 1, 12);
        arrivalDay= c.getInt("Enter the arrival day(1-31): ", 1, 31);
        arrivalYear= c.getInt("Enter the arrival year): ", 0, 3000);
        LocalDate arrivalDate = LocalDate.of(arrivalYear, arrivalMonth, arrivalDay);
        r.setArrivalDate(arrivalDate);
    }

    private void departure() {
        int departureMonth, departureDay, departureYear;
        departureMonth= c.getInt("\nEnter the departure month(1-12): ", 1, 12);
        departureDay = c.getInt("Enter the departure day(1-31): ", 1, 31);
        departureYear = c.getInt("Enter the departure year: ", 0, 3000);
        LocalDate departureDate = LocalDate.of(departureYear, departureMonth, departureDay);
        r.setDepartureDate(departureDate);
    }

    private void printCalc() {
        System.out.println("\n" + r.getArrivalDateFormatted() +
                "\n" + r.getDepartureDateFormatted() +
                "\n" + r.getPricePerNightFormatted() +
                "\n" + r.getTotalPriceFormatted());
    }
}