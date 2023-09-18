package homework_08;
/*
@date 18.09.2023
@author Sergey Bugaienko
*/

import java.util.Scanner;

/*
Перепишите решение задачи с использованием switch вместо if-else:

Необходимо написать программу, где бы пользователю предлагалось ввести число на выбор: 1, 2 или 3,
а программа должна сказать, какое число ввёл пользователь: 1, 2, или 3
 */
public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число 1, 2 или 3");
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                System.out.println("Вы ввели число один");
                break;
            case 2:
                System.out.println("Вы ввели число два");
                break;
            case 3:
                System.out.println("Вы ввели число три");
                break;
            default:
                System.out.println("Вы ввели какое-то другое число");
        }

        String str = "Ппппп";

        switch (str) {
            case "Hello": // аналог if (str.equals("Hello"))
                System.out.println("Введено");
            case "Hi": // else if (str.equals("Hi"))
                System.out.println("апкпепке");
            case "gtrhrhtt": // else if (str.equals("gtrhrhtt"))
                System.out.println("Что угодно");
            default: // else {
                System.out.println("Вывод по дефолту");
        }

        String str1 = "Hello" + 1;
        System.out.println(str1);


    }
}
