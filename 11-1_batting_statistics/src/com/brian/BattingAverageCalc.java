package com.brian;

import java.util.Arrays;

public class BattingAverageCalc {
    String cont = "y";
    Console c = new Console();

    public void calc() {
        System.out.println("Welcome to the Batting Average Calculator\n");
        while (cont.equals("y") || cont.equals("Y")) {
            int num = c.getInt("Enter number of times at bat: ", 0);
            calcBattingAverage(num);
        }
    }

    public void calcBattingAverage(int x){
        double [] resultAtBat = new double[x];
        double total = 0;
        double onBase = 0;

        System.out.println("\n0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");
        for (int i=0; i<x; i++) {
            resultAtBat[i] = c.getDouble(
                    "Result for at bat " + (i+1) + ": ", 0, 4);
            total += resultAtBat[i];
            if (resultAtBat[i] > 0) {
                onBase++;
            }
        }

        System.out.println();
        System.out.println();
    }
}