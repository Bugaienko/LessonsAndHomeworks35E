package homework_05;
/*
@date 12.09.2023
@author Sergey Bugaienko
*/

import java.util.Scanner;

/*
Task 01

Создайте переменную с типом String, в которой будет хранится ВАше имя.
Сколько букв в вашем имени? Выведите значение на экран
Создайте две переменные типа char. Одной присвойте первый символ имени, второй - последний символ
Выведите на экран десятичный код первого и последнего символа вашего имени
 */
public class Task_01 {
    public static void main(String[] args) {
        String name = "Sergey";

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите свое имя");
//        name = scanner.nextLine();


        System.out.println("В имени " + name.length() + " символов");
        char firstChar = name.charAt(0);
        char lastChar = name.charAt(name.length() -1);
        System.out.println("Первый символ: " + firstChar);
        System.out.println("Последний символ: " + lastChar);

        int indexFirst = firstChar; // используем переменную типа int для представления типа char в числе
        int indexLast = lastChar;

        System.out.println("Код первого символа: " + indexFirst);
        System.out.println("Код последнего символа: " + indexLast);

        // второй способ преобразовать char в число
        System.out.println("Код первого символа: " + (int)firstChar);
        System.out.println("Код последнего символа: " + (int)lastChar);

    }
}
