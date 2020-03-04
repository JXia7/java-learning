package com.company;

import java.util.Random;

public class RandomNumberGuesser extends NumberGuesser {

    public RandomNumberGuesser(int min, int max) {
        super(min, max);
    }

    public int getCurrentGuess() {
        if ((lowerBound == numberPoint + 1) || (upperBound == numberPoint - 1)) {
            Random randomNumber = new Random();
            numberPoint = randomNumber.nextInt((upperBound - lowerBound) + 1) + lowerBound;
        }

        return  numberPoint;
    }
}
