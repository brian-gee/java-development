package com.brian;

public class Employee extends Person {
    private String ssn;


    @Override
    public String toString() {
        String numbers[] = ssn.split("[^0-9]+");
        return "Name: " + getFirstName() + " " + getLastName() + "\n" +
                "SSN:  xxx-xx-" + numbers[2];

    }


     public Employee(String first, String last, String ssn) {
         super(first, last);
         this.ssn = ssn;
     }

     public void setSsn(String ssn) {
         this.ssn = ssn;
     }

     public String getSsn() {
         return ssn;
     }
}