package com.brian;

public abstract class Animal implements Countable {

    private int count;

    @Override
    public void incrementCount() {
        count++;
    }

    @Override
    public void resetCount() {
        count = 0;
    }

    @Override
    public int getCount() {
        incrementCount();
        return count;
    }

    @Override
    public String getCountString() {
        incrementCount();
        return  getCount() + "Counting ";
    }
}