package com.brian;


public class BattingAverageCalc {
    String cont = "y";
    Console c = new Console();

    public void calc() {
        System.out.println("Welcome to the Batting Average Calculator\n");
        while (cont.equals("y") || cont.equals("Y")) {
            int num = c.getInt("Enter number of times at bat: ", 0, 30);
            calcArray(num);
            cont = c.getContinueString();
        }
    }

    public void calcArray(int x){
        int [] resultAtBat = new int[x];
        int total = 0;
        double onBase = 0;

        System.out.println("\n0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");
        for (int i=0; i<x; i++) {
            resultAtBat[i] = c.getInt(
                    "Result for at bat " + (i+1) + ": ", 0, 4);
            total += resultAtBat[i];
            if (resultAtBat[i] >= 1) {
                onBase++;
            }
        }
        System.out.println("\nBatting average: " + calcBattingAverage(x, onBase));
        System.out.println("Slugging percent: " + calcSluggingPercent(total, x));
    }

    public double calcBattingAverage(double totalAtBats, double onBase) {
        return  onBase / totalAtBats;
    }

    public double calcSluggingPercent(double totalBases, double atBats) {
        return totalBases / atBats;
    }
}