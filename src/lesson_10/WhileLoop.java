package lesson_10;
/*
@date 18.09.2023
@author Sergey Bugaienko
*/

import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {

//        while (true) { // Бесконечный цикл
//            System.out.println("Hello");
//        }

// Распечатать все числа от 0 до 10 включительно
        int x = 0;

        while (x <= 10) {
            // тело цикла
            // System.out.println("X равен: " + x);
            x++; // x = x + 1; увеличиваем значение х на единицу.
        }
// x = 11;
        System.out.println("Конец цикла while");

// Распечатать все числа от 100 до 90 - в порядке убывания

        int y = 100;

        while (y >= 90) {
            System.out.println(y--); // выводим в консоль y, затем уменьшаем у на 1
            //  y = y - 3;
        }
        System.out.println("y после цикла равен: " + y);

        // Вывести все четные числа в диапазоне от 0 до 21

        /*
        1. Запустить перебор чисел (цикл) от 0 до 21
        2. Проверять является ли число четным
            2.1. Если является - распечатать
            2.2. если нет - никаких действий не требуется. Переходим к следующему
        3. Увеличить счетчик цикла (перебираемое число)
*/
        int i = 0;

        while (i <= 21) { // перебираю все числа меньше 22
            if (i != 0 && i % 2 == 0) { // является ли число четным
                System.out.print(i + "; ");
            }

            i++; // увеличиваю счетчик
        }

       System.out.println();
        System.out.println("i после цикла: " + i);

        // do-while цикл с постусловием. Сначала выполняется тело цикла (как минимум 1 раз),
        // потом проверяется условие. Если true - еще раз выполняется тело цикла. Потом проверка условия

        int a1 = 0;

//        while (a1 < 0) {
//            System.out.println(a1);
//        }

        do {
            System.out.println("Внутри цикла do-while " + a1);
            a1 = a1 + 1;
        } while (a1 < 2); // false (0 < 0 )

        System.out.println("a1 после цикла: " + a1);


        System.out.println("End! ========");


        Scanner scanner = new Scanner(System.in);

        int number = 0;

        System.out.println("Введите число 1, 2");
        number = scanner.nextInt();

        while (number != 2 && number != 1) {
            System.out.println("Введите число 1, 2");
            number = scanner.nextInt();
        }

        System.out.println("После while. Спасибо, вы ввели один или два");



        do {
            System.out.println("Введите число 1, 2");
            number = scanner.nextInt();

        } while (number != 2 && number != 1);

        System.out.println("После do-while. Спасибо, вы ввели один или два");

        // Вывести на экран все нечетные числа в диапазоне от 10 до 21 включительно и посчитать их количество.
        // Вывести кол-во нечетных чисел на экран
        // Сумму всех нечетных чисел и их среднее арифметическое (сумма деленная на количество чисел)


        int i1 = 10;
        int countOdd = 0;
        int sumOdd = 0;

        while (i1 <= 21) {

            if (i1 % 2 == 1) { // проверка на нечетность числа
                System.out.print(i1 + "; ");
                countOdd = countOdd + 1; // countOdd++;
                sumOdd += i1;
            }

            i1++;
        }

        System.out.println();
        System.out.println("Количество нечетных чисел: " + countOdd);
        System.out.println("Сумма нечетных чисел: " + sumOdd);
        System.out.println("Среднее арифметическое: " + (double)sumOdd / countOdd);
        System.out.println("End loop!");


    }
}
