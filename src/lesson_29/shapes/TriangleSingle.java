package lesson_29.shapes;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public class TriangleSingle extends Shape{
    private double sideA;
    private double sideB;
    private double sideC;

    private static TriangleSingle instance;

    private TriangleSingle(){

    }

    public static TriangleSingle getInstance(double side1, double side2, double side3) {
        if (instance == null) {
            instance = new TriangleSingle();
        }

        if (isValidTriangle(side1, side2, side3)) {
            instance.sideA = side1;
            instance.sideB  = side2;
            instance.sideC = side3;
        } else {
            instance = null;
            System.out.println("Недействительные стороны треугольника. Треугольник не был создан.");
        }

        return instance;
    }

    private static boolean isValidTriangle(double side1, double side2, double side3) {
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }

    @Override
    public String toString() {
        return "TriangleSingle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }

    @Override
    double area() {
        return 10;
    }

    @Override
    double perimeter() {
        return 5;
    }
}
