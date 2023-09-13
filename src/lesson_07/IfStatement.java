package lesson_07;
/*
@date 13.09.2023
@author Sergey Bugaienko
*/


import java.util.Random;
import java.util.Scanner;

public class IfStatement {
    public static void main(String[] args) {
        int x = 10;

        {
            int y = 5; // объявлена и инициализирована в отдельном блоке
            x = 11;
            x = x + y;
        }

        // x = x + y; // ошибка компиляции. Переменная y не видна (не доступна) вне "своего" блока.
        System.out.println(x);

//        if (x > 25) System.out.println("Всем привет!");

        x = 8;

//        if (x > 11) {
//            System.out.println("Всем привет!");
//            System.out.println("Сейчас x равен " + x);
//        } else if (x < 5) {
//            System.out.println("Мы находимся в блоке else if");
//            System.out.println("Сейчас x равен " + x);
//        } else {
//            System.out.println("Мы находимся в блоке else");
//        }
//
//        System.out.println("Продолжение программы");

        /*
        Необходимо написать программу,
        где бы пользователю предлагалось
        ввести число 1 или 10.
        Если ввёл число 1, программа должна вывести сообщение: "Вы ввели число один" или "Вы ввели число десять"
         */

        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Введите число 1 или 10: ");

        number = scanner.nextInt();

        if (number == 1) {
            System.out.println("Вы ввели число один");
        } else if (number == 10) {
            System.out.println("Вы ввели число десять");
        } else {
            System.out.println("Вы ввели не верное число");
        }

        System.out.println("=========================");

        /*
        У ребенка есть карманные деньги. Допустим 100 денег.
        Ребенок получил оценку в школе. (от 1 до 5)
        за хорошие оценки получает деньги, за плохие отбирают
            5 -> + 20
            4 -> 10
            3 -> 0;
            2 -> - 20
            1 -> все
         */

        int money = 100;
        int note;

        Random random = new Random();

        // Генерация случайного числа в диапазоне от 0 до (bound - 1).
        note = random.nextInt(5) + 1; // (0, 1, 2, 3, 4) + 1 -> (1, 2, 3, 4, 5)

        System.out.println("Ребенок получил оценку: " + note);

        note = 3;

        if (note == 5) {
            money += 20;
        } else if (note == 4) {
            money += 10; // money = money + 10;
        } else if (note == 2) {
            money -= 20;
        } else if (note == 1) {
//            money -= money; // money = money - money;
            money = 0;
        }

        System.out.println("У ребенка теперь: " + money + " денег");

        /*
        Попросите пользователя ввести число
        Если это число больше 10, прибавьте к числу 20
        Если число меньше -10 - присвойте числу модуль числа (т.е. убрать знак минус)
        Если число равно 4 - умножьте число на 4
        В остальных случаях поменяйте знак числа

        Выведите в консоль значение числа после манипуляций
         */

        System.out.println("Введите число: ");
        int number1 = scanner.nextInt();

        if (number1 > 10) {
            number1 += 20;
        } else if (number1 == 4) {
            number1 *= 4; // number1 = number1 * -4;
        } else {
            number1 = number1 * -1;
        }

        System.out.println("Число равно: " + number1);

//        } else if (number1 < -10) {
//            number1 *= -1; // number1 = number1 * -1;
//        }

        /*
        Пользователь вводит число. Если число больше или равно 0 - прибавить к нему 20, если меньше - умножить на 2.
         */

        int n = -5;

//        n = (n >= 0) ? n + 20 : n * 2;
        n = (n >= 0) ? 10 : -10;

//        n = (n >= 0) ? n + 20 : n * 2; // true n = n + 20 ; false n = n * 2;

        // равнозначны по логике выполнения присвоения

//        if (n >= 0) {
//            n += 20;
//        } else {
//            n *= 2;
//        }

        System.out.println(n);
        String strRes = ((n >= 0) ? "больше нуля" : "меньше нуля");
        System.out.println("n сейчас " + strRes);

    }
}
