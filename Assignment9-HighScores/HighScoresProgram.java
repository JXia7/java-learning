package com.company;

import java.util.Scanner;

/* Juanjuan Xia */

public class HighScoresProgram {

    public static void main(String args[]) {

        final int NUM_SCORES = 5;
        HighScores[] myScores = new HighScores[NUM_SCORES];

        initialize(myScores);
        sort(myScores);
        display(myScores);
    }

    public static void initialize(HighScores[] scores) {
        Scanner input = new Scanner(System.in);

        int scoreNumber;
        String name;

        for (int index = 0; index < scores.length; index++) {
            System.out.printf("Enter the name for score #%d: ", index+1);
            name = input.next();
            System.out.printf("Enter the score for score #%d: ", index+1);
            scoreNumber = input.nextInt();

            scores[index] = new HighScores(name, scoreNumber);
        }

    }

    public static void sort(HighScores[] scores) {

        int tempScore;
        for (int i = 0; i < (scores.length - 1); i++) {
            for (int j = i+1; j < scores.length; j++) {
                if (scores[i].getScore() < scores[j].getScore()) {
                    tempScore = scores[i].getScore();
                    scores[i].setScore(scores[j].getScore());
                    scores[j].setScore(tempScore);
                }
            }
        }
    }

    public static void display(HighScores[] scores) {
        System.out.println();
        System.out.println("Top Scorers:");
        for (int index = 0; index < scores.length; index++) {
            System.out.println(scores[index].getName() + ": " + scores[index].getScore());
        }
    }
}
