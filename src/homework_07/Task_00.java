package homework_07;
/*
@date 14.09.2023
@author Sergey Bugaienko
*/

import java.util.Scanner;

/*
Task 0

Необходимо написать программу, где бы пользователю предлагалось ввести число на выбор: 1, 2 или 3,
а программа должна сказать, какое число ввёл пользователь: 1, 2, или 3
 */
public class Task_00 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число 1, 2 или 3");
        int input = scanner.nextInt();

        System.out.println("В переменную попало число: " + input);

        if (input == 1) {
            System.out.println("Вы ввели число один");
        } else if (input == 2) {
            System.out.println("Вы ввели число два");
        } else if (input == 3) {
            System.out.println("Вы ввели число три");
        } else {
            System.out.println("Не корректный ввод :(");
        }

        System.out.println("Конец цикла if");

    }
}
