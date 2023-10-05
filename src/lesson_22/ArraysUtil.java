package lesson_22;
/*
@date 05.10.2023
@author Sergey Bugaienko
*/

import java.util.Random;

public class ArraysUtil {
    // для того, чтобы сказать: "число отсутствует в массиве",
    // нам надо совершить array.length итераций
    public static int linearSearch(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return i;
        }

        return -1;
    }

    public static int binarySearch(int[] array, int searchValue) {

        int startIndex = 0;
        int endIndex = array.length - 1;
        int middleIndex;

        int counter = 0;

        // проверяем можно ли разделить массив
        while (startIndex <= endIndex) {
            counter++;

            // вычисляем индекс середины
            // 0, 12 - >  0 + (12-0)/2 ->  6;
            middleIndex = startIndex + (endIndex - startIndex) / 2;


            // сравниваем значение "в середине" с искомым
            if (array[middleIndex] == searchValue) {
                System.out.println("Значение найдено. Совершено шагов: " + counter);
                return middleIndex;
            }

            // надо понять в какой части массива может быть искомое значение (справа от середины или слева)
            // смещаем соответствующие указатели (индексы)
            if (array[middleIndex] > searchValue) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }

        System.out.println("Элемент в массиве не найден!");
        System.out.println("Затрачено шагов: " + counter);

        return -1;
    }


    public static void sortArray(int[] array) {

        for (int i = 0; i < array.length; i++) {

            // находим минимум в текущей части массива
            int minIndex = minIndexSearch(array, i);

            // меняем местами значения самого левого элемента и элемента с minIndex;
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    // Поиск минимального значения в массиве от startIndex и до конца массива
    public static int minIndexSearch(int[] array, int startIndex) {
        // Назначаем минимумом самый левый элемент, части массива в которой идет поиск
        int min = array[startIndex];
        int minIndex = startIndex;

        // перебираем все значения. Если текущее меньше min - перезаписываем мин и индекс
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }

        return minIndex;

    }


    public static int minIndexSearch(int[] array) {
        int min = array[0];
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int[] initTestArray(int size) {
        Random random = new Random();
        int[] result = new int[size];

        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(2001) - 1000; // (0..2000) -1000 -> (-1000...1000)
        }

        return result;
    }
}
