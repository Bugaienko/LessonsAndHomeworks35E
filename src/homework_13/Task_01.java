package homework_13;

/*
@date 25.09.2023
@author Sergey Bugaienko
*/
/*
Написать метод, принимающий на вход целое число.
Метод должен вывести на экран 2 в степени этоЧисло

класс Math для нахождения степени числа использовать нельзя ;)
 */
public class Task_01 {
    public static void main(String[] args) {
//        int x = -2;

        powTwo(-2);
    }


    public static void powTwo(int x) {
        /*
        метод принимающий число X и распечатывающий в консоль 2^X;
        2^2 = 4;
        2^(-2) = 1 / 4;

        2^5 = 32;
        2^(-5) = 1/32;

        a^(-X) = 1 / (a^x)
         */

        boolean isPositive = x >= 0;

        if (x < 0) {
            x *= -1;
        }
        int result = 1;

        for (int i = 1; i <= x; i++) {
            result *= 2;
        }

        if (isPositive) {
            System.out.println(result);
        } else {
            System.out.println((double) 1 / result);
//            System.out.printf("%.2f\n", (double) 1 / result);
            System.out.printf("1/%d\n", result);
        }
    }
}
