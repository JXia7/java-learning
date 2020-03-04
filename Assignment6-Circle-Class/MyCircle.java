package com.company;

/* Juanjuan Xia */

public class MyCircle {
    private double x;
    private double y;
    private double radius;

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public boolean doesOverlap(MyCircle otherCircle) {
        double distanceCenters = Math.sqrt(
                        Math.pow((otherCircle.y - this.y),2) + Math.pow((otherCircle.x - this.x),2)
        );

        if (distanceCenters <= (this.radius + otherCircle.radius)) {
            return true;
        }
        return false;
    }
}
