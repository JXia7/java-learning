package com.company;

/* Juanjuan Xia */

public class MyCircleTester {

    public static void main(String[] args) {

        //Allocate and initialize five MyCircle objects.
        //Two of them should overlap, and two should not.
        MyCircle[] circles = new MyCircle[5];

        circles[0] = new MyCircle();
        circles[0].setX(0);
        circles[0].setY(0);
        circles[0].setRadius(10);

        circles[1] = new MyCircle();
        circles[1].setX(100);
        circles[1].setY(100);
        circles[1].setRadius(50);

        circles[2] = new MyCircle();
        circles[2].setX(200);
        circles[2].setY(100);
        circles[2].setRadius(100);

        circles[3] = new MyCircle();
        circles[3].setX(600);
        circles[3].setY(300);
        circles[3].setRadius(160);

        circles[4] = new MyCircle();
        circles[4].setX(750);
        circles[4].setY(900);
        circles[4].setRadius(100);

        //Display the areas of the five circles.
        System.out.println("The area of the circle 1 is " + circles[0].getArea());
        System.out.println("The area of the circle 2 is " + circles[1].getArea());
        System.out.println("The area of the circle 3 is " + circles[2].getArea());
        System.out.println("The area of the circle 4 is " + circles[3].getArea());
        System.out.println("The area of the circle 5 is " + circles[4].getArea());

        //Invoke doesOverlap on MyCircles to show which circles overlap.
        circles[0].doesOverlap(circles[1]);
        for (int i = 0; i < circles.length; i++) {
            for (int j = i+1; j< circles.length-1; j++) {
                if (circles[i].doesOverlap(circles[j]) == true) {
                    System.out.printf("Overlap Circles:");
                    System.out.printf("The circle %d overlap with the cirlce %d\n", i+1, j+1);
                }
            }
        }
    }
}
