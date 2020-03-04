package com.company;

import java.util.Scanner;

public class StringProcessorProgram {

    public static void main(String[] args) {
        do {
            System.out.print("Enter a line of text: ");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();

            StringProcessor strPro = new StringProcessor(s);
            System.out.println("words: " + strPro.wordCount());
            System.out.println("uppercase: " + strPro.uppercaseCount());
            System.out.println("digits: " + strPro.digitCount());
            System.out.println("digit words: " + strPro.digitWordCount());
            System.out.println("line with whitespace removed: “" + strPro.getNoSpaceString() + "”");
            System.out.println("line with vowels replaced: “" + strPro.getNoVowelString() + "”");
            System.out.println("line with digit words replaced: “" + strPro.getNoDigitWordString() + "”");
        } while (shouldPlayAgain());
    }

    public static boolean shouldPlayAgain() {
        System.out.printf("do you want to enter another? (y/n): ");
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
