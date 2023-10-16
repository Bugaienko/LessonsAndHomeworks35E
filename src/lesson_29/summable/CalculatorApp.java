package lesson_29.summable;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new int[]{3, 4, 5});

        System.out.println("сумма values: " + calculator.sum(calculator.getValues()));
        System.out.println("сумма values: " + calculator.sum(1, 2, 3, 4));

        System.out.println(calculator.getPi());
        System.out.println(calculator.areaCircle(15.0));

        System.out.println(Summable.PI);
    }
}
