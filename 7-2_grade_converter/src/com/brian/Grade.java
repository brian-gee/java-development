package com.brian;

public class Grade {
    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber(){
        setNumber(Console.getInt("Enter numerical grade: "));
        return number;
    }

    public String getLetter() {
        while (true) {
            number = getNumber();
            // if/else statement to get letter grade for enter number
            if (number<= 100 &&  number >= 88) {
                return ("Letter Grade: A");
            } else if (number <= 87 && number >= 80) {
                return ("Letter Grade: B");
            } else if (number <= 79 && number >= 67) {
                return ("Letter Grade: C");
            } else if (number <= 66 && number >= 60) {
                return ("Letter Grade: D");
            } else if (number <= 59 && number >= 0){
                return ("Letter Grade: F");
            }
        }
    }
}