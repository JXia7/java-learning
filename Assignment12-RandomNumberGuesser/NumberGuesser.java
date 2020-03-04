package com.company;

public class NumberGuesser {

    protected int origLowerBound;
    protected int origUpperBound;
    protected int lowerBound;
    protected int upperBound;
    protected int numberPoint;

    public NumberGuesser(int lowerBound, int upperBound) {
        origLowerBound = lowerBound;
        origUpperBound = upperBound;
        this.lowerBound = origLowerBound;
        this.upperBound = origUpperBound;
    }

    public int getCurrentGuess() {
        numberPoint = (lowerBound + upperBound)/2;
        return numberPoint;
    }

    public void higher() {
        lowerBound = numberPoint + 1;
    }

    public void lower() {
        upperBound = numberPoint - 1;
    }

    public void reset() {
        this.lowerBound = origLowerBound;
        this.upperBound = origUpperBound;
    }
}
