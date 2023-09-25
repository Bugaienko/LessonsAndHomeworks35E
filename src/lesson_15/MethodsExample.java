package lesson_15;
/*
@date 25.09.2023
@author Sergey Bugaienko
*/

public class MethodsExample {
    public static void main(String[] args) {


        int var = 5;
        var = 10 + 5;

        int sumAB = calculateSum(10, 5);

        System.out.println("sumAB: " + sumAB);

        printSum(10, 5);

        int pow = -4;

        double var1 = 2;
        var1 = powTwo(-4); // 0.0625
        // var1 = 10 + 5;
        var1 = powTwo(5) + var1; // 32 + 0.0625

        System.out.println("2 в с степени " + pow + " = " + var1);

        System.out.println("=======================");

        int number = -2;
        int sqrNumber = squaredNumber(number);
        System.out.println("sqrNumber: " + sqrNumber);

        double number2 = 4.5;
        System.out.println("sqrNumber double: " + squaredNumber(number2));

        int[] numbers = {4, 5, 6, 3, 7, 8, 3, 33, 32};

        int minNumber = minArray(numbers);
        System.out.println("Минимальное значение в массиве: " + minNumber);



        // {4, 5, 6, 3, 7, 8, 3, 33, 32};
        int searchMe = 3;

        boolean isInArray = isNumberInArray(numbers, searchMe);
        System.out.println(isInArray);

        int idxFounded = searchNumber(numbers, searchMe);
        System.out.println("idxFounded:  " + idxFounded);




    } // Methods area

    // написать метод, определяющий присутствует ли число в массиве
    // тип возвращаемого значения boolean
    // параметры метода? массив, и число (int)
    public static boolean isNumberInArray(int[] ints, int number) {
        for (int value: ints) {
            if (value == number) return true;
        }
        return false;
    }

    // написать метод поиска числа в массиве
    // Если число в массиве присутствует - метод возвращает его индекс
    // Если числа нет - метод возвращает минус 1.

    public static int searchNumber(int[] ints, int searchMe) {
        int result = -1;

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == searchMe) return i;
        }
        return result;
    }

    //// {4, 5, 6, 3, 7, 8, 3, 33, 32};
    // метод поиска индекса последнего вхождения элемента
    public static int searchLastNumber(int[] ints, int searchMe) {
        int result = -1;

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == searchMe) {
                result = i;
            }
        }
        return result;
    }

    public static int searchLastNumber2(int[] ints, int searchMe) {

        for (int i = ints.length -1; i >= 0; i--) {
            if (ints[i] == searchMe) return i;
        }

        return -1;
    }





    // написать метод, принимающий массив и возвращающий минимальное значение в этом массиве
    public static int minArray(int[] ints) {
        if (ints.length < 1) return Integer.MIN_VALUE;

        int min = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] < min) {
                min = ints[i];
            }
        }

        return min;
    }





    //напишите метод, принимающий в параметры число и возвращающего квадрат этого числа

    public static double squaredNumber(double number) {
        return number * number;
    }

    public static int squaredNumber(int number) {
        int result = number * number;
        return result;
    }


    public static double powTwo(int x) {
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
 /* эта часть кода была в void методе. Мы результат выводили в консоль
        if (isPositive) {
            System.out.println(result);
        } else {
             System.out.println((double) 1 / result);
             System.out.printf("1/%d\n", result);
        }
  */
        // вместо выводов результата в консоль мы возвращаем его из метода
        if (isPositive) {
            return result;
        } else {
            return ((double) 1 / result);
        }
    }

    public static void printSum(int a, int b) {
        int sum = a + b;
        System.out.println(sum);
    }


    public static int calculateSum(int a, int b) {
        printSum(a, b);

        int sum = a + b;

        // В методе с возвращаемым значением, при любых разветвлениях кода должен приcутствовать оператор return
        //
//        if (sum > 10) {
//            return sum;
//        }
//        return (int) 2.0;

        return sum;
    }


}
