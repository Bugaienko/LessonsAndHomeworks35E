package homework_11;

import java.util.Random;

/*
@date 20.09.2023
@author Sergey Bugaienko
*/
/*
Дан массив целых чисел. *Выберите произвольную длину.
Заполните случайными значениями.

Вывести на экран:

минимальное значение, хранящееся в массиве
максимальное
среднее арифметическое всех значений в массиве
 */
public class Task_00 {
    public static void main(String[] args) {
        Random random = new Random();
        int bound = 100;

        int[] numbers = new int[random.nextInt(21)];

        int i = 0;
        while (i < numbers.length) {
            numbers[i++] = random.nextInt(2 * bound + 1) - bound; // (0 ...200) - 100 -> (-100...100)
        }

        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        int j = 0;
        System.out.print("[");
        while (j < numbers.length) {

            if (numbers[j] < min) {
                min = numbers[j];
            } else if (numbers[j] > max) {
                max = numbers[j];
            }

            sum += numbers[j];

            System.out.print(numbers[j] + ((j < numbers.length -1)? "," : "]"));
            j++;
        }

        System.out.println("\nМинимальное значение в массиве: " + min);
        System.out.println("Максимальное значение в массиве: " + max);
        System.out.printf("Среднее арифметическое значений в массиве: %.3f", (double)sum / numbers.length);

        int l = 0;
        int randomSum = 0;
        while (l < 10_000_000) {
            randomSum += random.nextInt(101); // 0...100
            l++;
        }

        System.out.printf("\nСреднее арифметическое 10млн случайных значений: %.4f", (double)randomSum / (l-1));
        //число стремится к bound / 2;


    }

}
