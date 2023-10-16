package lesson_29.summable;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public class Calculator implements Summable{

    private int[] values;

    public Calculator(int[] values) {
        this.values = values;
    }

    public int[] getValues() {
        return values;
    }

    public double getPi() {
        return PI;
    }

    public double areaCircle(double radius) {
        return radius * radius * PI;
    }




}
