package com.brian;

public class Square extends Shape{
    private double width;

    @Override
    double getArea() {
        return (width*width);
    }

    public Square(double width) {

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

}