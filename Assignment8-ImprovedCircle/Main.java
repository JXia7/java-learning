package com.company;

/* Juanjuan Xia */

public class Main {

    public static void main(String[] args) {

        Point myPoint = new Point(100, 120);

        // construct circles using all four constructors.
        Circle myCircle1 = new Circle(myPoint, 10);
        Circle myCircle2 = new Circle(150, 120, 45);
        Circle myCircle3 = new Circle();
        Circle myCircle4 = new Circle(myCircle1);

        // test the doesOverlap method.
        if ( myCircle1.doesOverlap(myCircle2) ) {
            System.out.println("The circle 1 overlap with the cirlce 2.");
        } else {
            System.out.println("The circle 1 does not overlap with the cirlce 2.");
        }

        // test the toString method.
        System.out.println(myCircle1.toString());

        // test the equal method.
        if ( myCircle1.equals(myCircle4) ) {
            System.out.println("The Circle 1 equals with the Circle 4.");
        } else {
            System.out.println("The Circle 1 does not equal with the Circle 4.");
        }
    }
}
