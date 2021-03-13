package com.singleton;

public class Circle {
    public static void main(String[] args) {
        GetCircle get = new GetCircle();
        get.setRadius(5);
        System.out.println(get.getArea());
    }
}

class GetCircle{
    private final double PI = 3.14;
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * PI;
    }
}