package homework_12;

import java.util.Scanner;

/*
@date 21.09.2023
@author Sergey Bugaienko
*/
/*
Task 1

За каждый месяц банк начисляет к сумме вклада 7% от суммы.
Напишите консольную программу, в которую пользователь вводит сумму вклада и количество месяцев.
А банк вычисляет конечную сумму вклада с учетом начисления процентов за каждый месяц. Для вычисления суммы с учетом процентов используйте цикл for.

Пусть сумма вклада будет представлять тип float.
 */
public class Task_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        float sumDeposit;
        int mouths;

        System.out.println("Сколько денюжек вы нам доверите?");
        sumDeposit = scanner.nextFloat();

        System.out.println("На какой срок (в месяцах)?");
        mouths = scanner.nextInt();

        float percentsPerMonth = 7; // чтобы получить x процентов от суммы, сумму нужно умножить на х и разделить на 100

        for (int i = 1; i <= mouths; i++) {
            sumDeposit += sumDeposit * percentsPerMonth / 100;
        }

        System.out.printf("Через  %d мы вам будем должны %.2f", mouths, sumDeposit);
    }
}
