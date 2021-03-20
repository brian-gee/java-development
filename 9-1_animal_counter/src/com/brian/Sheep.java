package com.brian;

public class Sheep extends Animal implements Cloneable {
    private String name;

    @Override
    public String getCountString() {
        return getCount() + " " + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}