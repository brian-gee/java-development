package com.brian;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Conversion {
    String fromUnit;
    String toUnit;
    double fromValue;
    double toValue;
    double conversionRatio;

    public Conversion() {
        this("", "", 0);
    }

    public Conversion(String fromUnit, String toUnit, double conversionRatio) {
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.fromValue = fromValue;
        this.toValue = toValue;
        this.conversionRatio = conversionRatio;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }

    public double getFromValue() {
        return fromValue;
    }

    public void setFromValue(int fromValue) {
        this.fromValue = fromValue;
    }

    public double getToValue() {
        return toValue;
    }

    public void setToValue(int toValue) {
        this.toValue = toValue;
    }

    public double getConversionRatio() {
        return conversionRatio;
    }

    public void setConversionRatio(double conversionRatio) {
        this.conversionRatio = conversionRatio;
    }

    public String convert(double fromValue) {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);

       double toValue = fromValue*conversionRatio;
        return fromValue + " " + fromUnit + " = " + df.format(toValue) + " " + toUnit;
    }
}