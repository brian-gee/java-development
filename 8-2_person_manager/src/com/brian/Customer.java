package com.brian;

public class Customer extends Person {
    private String number;

    @Override
    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName() + "\n" +
                "Customer Number: " + number;

    }

    public Customer(String first, String last, String number) {
        super(first, last);
        this.number = number;
    }

    public void setCustomerNumber(String number) {
        this.number = number;

    }

    public String getCustomerNumber() {
        return number;
    }
}