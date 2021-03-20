package com.brian;

abstract public class Player {

    private String name;
    private String roshamboValue;

    abstract String generateRoshambo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoshamboValue() {
        return roshamboValue;
    }

    public void setRoshamboValue(String roshamboValue) {
        this.roshamboValue = roshamboValue;
    }
}