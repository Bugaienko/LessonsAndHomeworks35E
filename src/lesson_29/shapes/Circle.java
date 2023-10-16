package lesson_29.shapes;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public class Circle extends Shape {

    private double radius;

    @Override
    double area() {
        // pi * r * r
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        // pi * 2r
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
