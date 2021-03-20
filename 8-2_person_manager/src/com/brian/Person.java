package com.brian;

public class Person {
    Console c = new Console();
    private String first;
    private String last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return "Name: " + first + " " + last;
    }

    public void setFirstName(String first) {
        this.first = first;
    }

    public String getFirstName() {
        return first;
    }

    public void setLastName(String last) {
        this.last = last;
    }

    public String getLastName() {
        return last;
    }

}