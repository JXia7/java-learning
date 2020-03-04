package com.company;

import java.util.Random;
import java.util.Scanner;

public class GuessingProgram {

    public static void main(String[] args) {

        RandomNumberGuesser rng = new RandomNumberGuesser(1, 100);

//        System.out.println(rng.getCurrentGuess());
//        System.out.println(rng.getCurrentGuess());
//        System.out.println(rng.getCurrentGuess());

        do {
            System.out.println("Think of a number Between 1 and 100.");
            boolean active = true;
            while (active){
                String yORn = getUserResponseToGuess(rng.getCurrentGuess());
                if (yORn.equals("h")) {
                    rng.higher();
                    rng.getCurrentGuess();
                } else if (yORn.equals("l")) {
                    rng.lower();
                    rng.getCurrentGuess();
                } else if (yORn.equals("c")) {
                    System.out.printf("You picked %d? Great pick.\n", rng.getCurrentGuess());
                    active = false;
                }
            }

            rng.reset();

        } while (shouldPlayAgain());
    }

    public static String getUserResponseToGuess(int guess) {
        System.out.printf("Is the number %d?  (h/l/c): ", guess);
        Scanner userResponse = new Scanner(System.in);
        String yORn = userResponse.next();
        return yORn;
    }

    public static boolean shouldPlayAgain() {
        System.out.printf("Do you want to play again? (y/n): ");
        Scanner playAgainScan = new Scanner(System.in);
        String yORn = playAgainScan.next();
        boolean keepplay = false;
        if (yORn.equals("y")) {
            keepplay = true;
        } else if (yORn.equals("n")) {
            System.out.println("Good bye.");
        }
        return keepplay;
    }
}
