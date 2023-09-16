package homework_07;

import java.util.Scanner;

/*
@date 14.09.2023
@author Sergey Bugaienko
*/
/*
программа предлагает пользователю ввести четырехзначное число
Причем: мы можем получать от пользователя ТОЛЬКО строки. Данные в формате String
Если число не четырехзначное, должно вывестись на экран сообщение об ошибке и работа программы завершается
Проверить, является ли число "счастливым билетом". Т.е. совпадает ли сумма цифр первых двух цифр числа с суммой третьей и четвертой цифры
 */
public class Task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите четырехзначное число:");
        String inputStr = scanner.next();

        // "1234"

        //Выполняем проверку, что в строке 4 символа
        if (inputStr.length() != 4) {
            System.out.println("Ошибка! Число не 4-х значное");
        } else {
            // System.out.println((int)inputStr.charAt(0)); // получаю код символа в 10-й системе
            // int char1 = (int)inputStr.charAt(0) - 48; // из кода символа получаю числовое значение этого символа (код 1 = 49, значение 49-48 = 1)
            // System.out.println(char1);


            System.out.println((int) inputStr.charAt(1));
            if (inputStr.charAt(0) + inputStr.charAt(1) == inputStr.charAt(2) + inputStr.charAt(3)) {
                System.out.println("Число счастливое! Ура!");
            } else {
                System.out.println("Число НЕ являктся \"счастливым\"");
            }
        }

        if (inputStr.length() != 4) {
            System.out.println("Ошибка! Число не 4-х значное");
        } else {

            int inputInt = Integer.parseInt(inputStr);
            System.out.println(inputInt);

            // 1234
            int digit0 = inputInt % 10;
            inputInt = inputInt / 10;

            //123
            int digit1 = inputInt % 10;
            inputInt /= 10;

            //12
            int digit2 = inputInt % 10;
            int digit3 = inputInt / 10;

            System.out.println("Числа: " + digit0 + " : " + digit1 + " : " + digit2 + " : " + digit3);

            if (digit0 + digit1 == digit2 + digit3) {
                System.out.println("Число счастливое! Ура!");
            } else {
                System.out.println("Число НЕ является \"счастливым\"");
            }
        }

        if (inputStr.length() != 4) {
            System.out.println("Ошибка! Число не 4-х значное");
        } else {

            int inputInt = Integer.parseInt(inputStr);
            System.out.println(inputInt);

            // "откусываем" от числа по 1 цифре

            // 1234
            int digit0 = inputInt / 1000;
            inputInt = inputInt % 1000;

            //234
            int digit1 = inputInt / 100;
            inputInt %= 100;

            //34
            int digit2 = inputInt / 10;
            int digit3 = inputInt % 10;

            System.out.println("Числа: " + digit0 + " : " + digit1 + " : " + digit2 + " : " + digit3);

            if (digit0 + digit1 == digit2 + digit3) {
                System.out.println("Число счастливое! Ура!");
            } else {
                System.out.println("Число НЕ является \"счастливым\"");
            }
        }
    }
}
