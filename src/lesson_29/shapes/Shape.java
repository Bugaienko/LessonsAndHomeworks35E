package lesson_29.shapes;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public abstract class Shape {
    abstract double area();
    abstract double perimeter();

    public void testPrint() {
        System.out.println("I have default realization");
    }
}
