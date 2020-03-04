package com.company;

public class HighScores {

    private String name;
    private int score;

    public HighScores(String n, int s) {
        name = n;
        score = s;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setScore(int s) {
        score = s;
    }

    public int getScore() {
        return score;
    }
}
