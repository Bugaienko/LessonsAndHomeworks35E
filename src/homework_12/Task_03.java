package homework_12;

import java.util.Random;

/*
@date 21.09.2023
@author Sergey Bugaienko
*/
/*
Task 2

Заполните массив 50 случайными числами от 1 до 100.
Программа должна найти, и вывести на экран все простые числа.
Посчитайте сколько получилось таких чисел в массиве.

Простое число - число, которое делится на цело только на 1 и само себя.

Пример простых чисел: 3, 5, 7, 11, 13 и т.д.
 */
public class Task_03 {
    public static void main(String[] args) {
        Random random = new Random();

        int range = 50;
        int[] numbers = new int[range];

        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000) + 1;
//            System.out.print(numbers[i] + ((i < numbers.length - 1) ? ", " : "]\n"));
        }
        System.out.println();

        int counterSimple = 0;

        long start = System.currentTimeMillis();

        for (int i = 0; i < numbers.length; i++) {

            // 13 -> 1, 13 -> простое; 2, 3, 4. 5. 6. 7. 8. 9. 10. 11. 12.

            boolean isSimple = true;


            if (numbers[i] == 1) {
                isSimple = false;
            }

            for (int j = 2; j <= Math.sqrt(numbers[i]); j++) { // (2 ... N-1)

                if (numbers[i] % j == 0) {
                    isSimple = false;
                    break;
                }
            }

            if (isSimple) {
                System.out.print(numbers[i] + "; ");
                counterSimple++;
            }

        }

        System.out.println("\nКоличество простых чисел: " + counterSimple);

        long end = System.currentTimeMillis();
        System.out.println("Алгоритм 1  затратил: " + (end - start));

        int counterSimple2 = 0;

        long start2 = System.currentTimeMillis();


        for (int i = 0; i < numbers.length; i++) {

            // 13 -> 1, 13 -> простое; 2, 3, 4. 5. 6. 7. 8. 9. 10. 11. 12.

            boolean isSimple = true;


            if (numbers[i] == 1) {
                isSimple = false;
                continue;
            }

//            if (numbers[i] == 2 || numbers[i] == 3) {
//                isSimple = true;
//            }


            if (numbers[i] % 2 == 0 && numbers[i] != 2 || numbers[i] % 3 == 0 && numbers[i] != 3 ) {
                isSimple = false;
                continue;
            }


            for (int j = 5; j <= Math.sqrt(numbers[i]); j = j + 6) { // (2 ... N-1)

                if (numbers[i] % j == 0 || numbers[i] % (j + 2) == 0) {
                    isSimple = false;
                    break;
                }
            }


            if (isSimple) {
                System.out.print(numbers[i] + "; ");
                counterSimple2++;
            }

        }

        System.out.println("\nКоличество простых чисел: " + counterSimple2);

        long end2 = System.currentTimeMillis();
        System.out.println("Алгоритм 2  затратил: " + (end2 - start2));

    } // main
}

// 25 -> 5. (2.3.4.5) (6..24)

// 12 -> 4. 2
//25 -> 2 -> 4,6,8,10,12
//    5,  7,        11,  13,         17,  19,  ,       23, 25,         29,  31,       35, 37