package com.company;

import java.util.Scanner;

public class GuessingProgram {

    public static void main(String[] args) {

        NumberGuesser guesser = new NumberGuesser(1, 100);

        do {
            System.out.println("Think of a number Between 1 and 100.");
            boolean active = true;
            while (active){
                String yORn = getUserResponseToGuess(guesser.getCurrentGuess());
                if (yORn.equals("h")) {
                    guesser.higher();
                    guesser.getCurrentGuess();
                } else if (yORn.equals("l")) {
                    guesser.lower();
                    guesser.getCurrentGuess();
                } else if (yORn.equals("c")) {
                    System.out.printf("You picked %d? Great pick.\n", guesser.getCurrentGuess());
                    active = false;
                }
            }

            guesser.reset();

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
