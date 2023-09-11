package homework_03;
/*
@date 11.09.2023
@author Sergey Bugaienko
*/

import java.util.Scanner;

/*
Задача 4.
Какие числа могут получаться в качестве остатка от деления какого-либо целого числа на 2? На 3?
Покажите это на конкретных примерах.
 */
public class HW_Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите какое-то целое число");
        int var = scanner.nextInt();

        System.out.println("Остаток от деления на 2: " + var % 2);
        System.out.println("Остаток от деления на 3: " + var % 3);
    }
}
