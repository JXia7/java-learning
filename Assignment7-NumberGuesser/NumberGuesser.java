package com.company;

public class NumberGuesser {

    private int origLowerBound;
    private int origUpperBound;
    private int lowerBound;
    private int upperBound;
    private int midPoint;

    public NumberGuesser(int lowerBound, int upperBound) {
        origLowerBound = lowerBound;
        origUpperBound = upperBound;
        this.lowerBound = origLowerBound;
        this.upperBound = origUpperBound;
    }

    public int getCurrentGuess() {
        midPoint = (lowerBound + upperBound)/2;
        return midPoint;
    }

    public void higher() {
        lowerBound = midPoint + 1;
    }

    public void lower() {
        upperBound = midPoint - 1;
    }

    public void reset() {
        this.lowerBound = origLowerBound;
        this.upperBound = origUpperBound;
    }
}
