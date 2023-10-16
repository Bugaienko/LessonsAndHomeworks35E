package lesson_29.shapes;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;


    public Triangle(double sideA, double sideB, double sideC) {
        if (!isValidSides(sideA, sideB, sideC)) {
            this.sideA = 3;
            this.sideB = 3;
            this.sideC = 3;
            // throw new IllegalArgumentException("Невозможно создать треугольник с такими сторонами");
        } else {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
    }


    private boolean isValidSides() {
        return (sideA > sideB + sideC && sideB > sideA + sideC && sideC > sideA + sideB);
    }

    private boolean isValidSides(double sideA, double sideB, double sideC) {
        return (sideA < sideB + sideC && sideB < sideA + sideC && sideC < sideA + sideB);
    }

    @Override
    double area() {
        double area = 0;

        double p2 = perimeter() / 2;
        area = Math.sqrt(p2 * (p2 - sideA) * (p2 - sideB) * (p2 - sideC));


        return area;
    }

    @Override
    double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }

    @Override
    public void testPrint() {
        System.out.println("Realization fo Triangle");;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
}
