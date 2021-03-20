package com.brian;


public class Circle extends Shape{
    private double radius;


    @Override
    double getArea() {
        return (radius*radius)*(Math.PI);

    }

    public Circle(double radius) {

    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}