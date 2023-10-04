package lesson_21;
/*
@date 04.10.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;

public class Main21 {

    public static void main(String[] args) {

        // Мы можем вызвать статический метод без создания объекта
        int sum = MathUtil.symOfInts(1, 2, 3);
        System.out.println("Сумма: " + sum);

        System.out.println(Math.sqrt(16));


    }
}
