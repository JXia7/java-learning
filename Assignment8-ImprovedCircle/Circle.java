package com.company;

public class Circle {

    Point center;
    double radius;

    public Circle(Point o, double r) {
        center = new Point(o);
        radius = r;
    }

    public Circle(double xValue, double yValue, double r) {
        center = new Point(xValue, yValue);
        radius = r;
    }

    public Circle() {
        center = new Point(0, 0);
        this.radius = 1;
    }

    public Circle(Circle c) {
        this.center = new Point(c.center);
        this.radius = c.radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point p) {
        center = new Point(p);
    }

    public void setRadius(double value) {
        this.radius = value;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public String toString() {
        return "The Circle's center: " + center.toString() + "\nThe Circle's radius: " + radius;
    }

    public boolean equals(Circle c) {
        if (radius == c.radius && center.equals(c.center)) {
            return true;
        }
        return false;
    }

    public boolean doesOverlap(Circle c) {
        double distanceCenter = this.center.distance(c.center);
        if (distanceCenter <= (this.radius + c.radius)) {
            return true;
        }
        return false;
    }
}
