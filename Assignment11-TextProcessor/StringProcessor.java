package com.company;

public class StringProcessor {

    private String str;
    private char[] charsStr;
    private String[] wordsStr;

    public StringProcessor() {
        str = "";
        charsStr = str.toCharArray();
        wordsStr = str.split(" ");
    }

    public StringProcessor(String s) {
        str = s;
        charsStr = str.toCharArray();
        wordsStr = str.split(" ");
    }

    public void setString(String s) {
        str = s;
    }

    public String getString() {
        return str;
    }

    public int wordCount() {
        int wordCount = 0;
        for (int i=0; i < wordsStr.length; i++) {
            wordCount ++;
        }
        return wordCount;
    }

    public int uppercaseCount() {
        int uppercaseCount = 0;
        for (int i=0; i < charsStr.length; i++) {
            if (Character.isUpperCase(charsStr[i])) {
                uppercaseCount ++;
            }
        }
        return uppercaseCount;
    }

    public int digitCount() {
        int digitCount = 0;
        for (int i=0; i < charsStr.length; i++) {
            if (Character.isDigit(charsStr[i])) {
                digitCount ++;
            }
        }
        return digitCount;
    }

    public int digitWordCount() {
        int digitWordCount = 0;
        String[] digitWords1 = new String[]{"zero", "Zero", "one", "One", "two", "Two", "three", "Three", "four", "Four", "five", "Five", "six", "Six", "seven", "Seven", "eight", "Eight", "nine", "Nine"};
        for (int i=0; i < wordsStr.length; i++) {
            for (int j=0; j < digitWords1.length; j++) {
                if (wordsStr[i].equals(digitWords1[j])) {
                    digitWordCount ++;
                }
            }
        }
        return digitWordCount;
    }


    public String getNoSpaceString() {
        String noSpaceStr = "";
        for (int i=0; i < wordsStr.length; i++) {
            noSpaceStr += wordsStr[i];
        }
        return noSpaceStr;
    }

    public String getNoVowelString() {
        StringBuilder strB = new StringBuilder(str);
        char[] charsVowel = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        for (int i=0; i < str.length(); i++) {
            for (int j=0; j < charsVowel.length; j++) {
                if (charsVowel[j] == str.charAt(i)) {
                    strB.setCharAt(i, '-');
                }
            }
        }
        return strB.toString();
    }

    public String getNoDigitWordString() {
        String[] digitWords2 = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        StringBuilder strB = new StringBuilder(str);
        for (int i=0; i < strB.length(); i++) {
            if (strB.charAt(i) >= 'A' && strB.charAt(i) <= 'Z') {
                strB.setCharAt(i, (char) (strB.charAt(i)+32));
            }
        }

        String str2 = strB.toString();
        String[] wordsStr2 = str2.split(" ");

        for (int i=0; i < wordsStr2.length; i++) {
            for (int j=0; j < digitWords2.length; j++) {
                if (digitWords2[j].equals(wordsStr2[i])) {
                    wordsStr2[i] = String.valueOf(j);
                }
            }
        }

        String noDigitWordString = "";
        for (int i=0; i < wordsStr2.length; i++) {
            noDigitWordString += (wordsStr2[i] + " ");
        }

        return noDigitWordString;
    }
}
