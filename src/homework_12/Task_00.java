package homework_12;

import java.util.Random;

/*
@date 21.09.2023
@author Sergey Bugaienko
*/
/*
Task 0

Заполните массив 20 случайными целыми числами.
Программа должна вывести на экран массив, количество четных чисел в массиве и сумму всех четных чисел.
 */
public class Task_00 {
    public static void main(String[] args) {

        int count = 0;
        int sum = 0;

        int len = 20;
        Random random = new Random();

        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
            System.out.print(array[i] + ", ");
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                count++;
                sum += array[i];
            }
        }

        System.out.println("Четных чисел: " + count);
        System.out.println("Сумма четных чисел: " + sum);
    }
}
