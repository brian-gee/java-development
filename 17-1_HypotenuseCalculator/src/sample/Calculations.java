package sample;

import java.text.DecimalFormat;

public class Calculations{


    public static double calculateHypotenuse(double a, double b) {
        String pattern="#.###";
        DecimalFormat df = new DecimalFormat(pattern);
        double c = Math.sqrt((Math.pow(a, 2)) + (Math.pow(b, 2)));
        double formattedC = Double.parseDouble(df.format(c));
        return formattedC;
    }
}