package homework_15;
/*
@date 26.09.2023
@author Sergey Bugaienko
*/
/*
Task 0

Написать метод принимающий целое число и проверяющий является ли число простым.
Если является, метод должен вернуть true, не является - false
 */

/*
Task 1

Написать метод, принимающий массив целых чисел.
Метод должен вернуть количество простых чисел в массиве.
Для проверки на "простоту" числа рекомендуется использовать метод из Task 0
 */

import java.util.Arrays;

/*
Task 4 опционально

Написать метод, принимающий на вход массив целых чисел.
Метод должен вернуть массив, состоящий только из простых чисел, присутствующих в изначальном массиве
 */
public class Task_primeArrays {

    public static void main(String[] args) {

        int[] testArray = {0, 13, -25, 11, 31, 55, 98, 11, 5};

        int countPrime = countPrimeNumbersInArray(testArray);
        System.out.println("Количество простых чисел в массиве: " + countPrime);

        int[] primeArray = getArrayOnlyPrimeNumbersOptional(testArray);
        System.out.println(Arrays.toString(primeArray));

        int[] newPrimeArray = getArrayOnlyPrimeNumbersOptional(primeArray);
        System.out.println(Arrays.toString(newPrimeArray));

    } // Methods area

    public static int[] getArrayOnlyPrimeNumbers(int[] ints) {
        // 1. Узнать какой длинны будет результирующий массив
        // 2. Создать массив
        // 3. Перебрать массив-донор и записать все простые числа в результирующий массив
        // 4. Вернуть массив

        int[] primeArray = new int[countPrimeNumbersInArray(ints)];

        int counter = 0;

        for (int value : ints) {
            if (isNumberPrime(value)) {
                primeArray[counter] = value;
                counter++;
            }
        }

        return primeArray;
    }

    public static int[] getArrayOnlyPrimeNumbersOptional(int[] ints) {
        // 1. Длина результирующего массива точно не будет больше чем у массива-донора
        // 2. создаем результирующий массив такой же длину, как донор
        // 3. Проходим по массиву донору. Находим, считаем и записываем в результ.массив простые числа
        // 4. "обрезать" результирующий массив. И вернуть

        int[] result = new int[ints.length];

        int counter = 0;

        for (int value: ints) {
            if (isNumberPrime(value)) {
                result[counter] = value;
                counter++;
            }
        }

        System.out.println("Массив до обрезания: " + Arrays.toString(result) + " - counter: " + counter + " : length: " + result.length);
        result = Arrays.copyOf(result, counter);
        System.out.println("Массив после обрезания: " + Arrays.toString(result) + " - counter: " + counter + " : length: " + result.length);

        return  result;

    }

    public static int countPrimeNumbersInArray(int[] numbers) {
        int count = 0;

        for (int value : numbers) {
            if (isNumberPrime(value)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isNumberPrime (int number) {
        if (number <= 1) return false;
        if (number == 2 || number == 3) return true;

        for (int i = 5; i <= Math.sqrt(number); i+=6) {

            if (number % i == 0 || number % (i+2) == 0) {
                return false;
            }
        }
        return true;
    }
}
