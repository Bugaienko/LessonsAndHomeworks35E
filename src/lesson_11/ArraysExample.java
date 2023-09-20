package lesson_11;
/*
@date 19.09.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;
import java.util.Random;

public class ArraysExample {
    public static void main(String[] args) {

//        int x = 0;
////        int y = 10 / x; ошибка. В тип int делени е на 0 вызывает ошибку / исключение
//
//        double infinity = 10.0 / 0; // допустимая операция. Получаем значение "infinity"
//        double infinity1 = 1000.0 / 0;
//
//        System.out.println(infinity1 == infinity); // true
//
//        System.out.println(infinity1 / infinity); // ожидаем 1, получаем NaN -результат не определен

        int[] array;
        String[] strings;
        // int array1[]; альтернативный способ объявления массива. Не рекомендуется использовать

        array = new int[4]; // создали (инициализировали) массив типа int с 4 ячейками. // 0 0 0 0
        strings = new String[10]; // создали массив строк с 10 ячейками // null, x10

        int[] array2 = new int[8]; // объявили и инициализировали массив int с 8 ячейками

        // Значения по умолчанию:
        // для всех числовых типов (в том числе char) это будет 0 (0.0)
        // для boolean - false
        // для всех ссылочных типов - null (null - ничего)

        int[] numbers = new int[]{45, 56, -16, 45, 0, 159, 1444}; // явная инициализация массива
        int[] ints = {-10, 54, 32323, 444}; // явная инициализация массива

        int value = numbers[0];

        System.out.println("В 0 ячейки массива numbers находится число: " + value);
        System.out.println("В 2 ячейки массива ints находится число: " + ints[2]);
        System.out.println("В 3 ячейки массива array находится число: " + array[3]);
        System.out.println("В 9 ячейки массива strings находится число: " + strings[9]);

        System.out.println(ints); // получим визуализированную ссылку на адрес в Heap (куче)


        System.out.println("Длинная массива (кол-во ячеек в массиве) numbers: " + numbers.length);

        System.out.println("Распечатываем массив ints:");
        int j = 0;
        while (j < ints.length) {
            System.out.print(ints[j++] + ", ");
        }
        System.out.println();


        int i = 0;
        // [1, 3, 4, 5, 6, 7] - результат правильного / красивого вывода массива на печать


        System.out.println("Распечатываем \"красиво\" массив numbers:");

        String arrayToString = "[";
        while (i < numbers.length) {
//            arrayToString = arrayToString  + numbers[i] + ((i != numbers.length -1) ? ", ": "]");

            arrayToString += numbers[i];
            if (i != numbers.length - 1) {
                arrayToString += ", ";
            } else {
                arrayToString += "]";
            }
//            System.out.print(numbers[i] + ", ");
            i++;
        }
        System.out.println(arrayToString);

        System.out.println("======================");
        System.out.println("Работаем с типом String как с массивом");
        String str = "Hello!";

        int i1 = 0;

        while (i1 < str.length()) {
            System.out.print(str.charAt(i1) + ", ");
            i1++;
        }
        System.out.println();

        char[] chars = str.toCharArray();
        System.out.println("длина массива chars: " + chars.length);

        int e = 0;
        while (e < chars.length) {
            System.out.print(chars[e++] + " ");
        }
        System.out.println();

        System.out.println("======= Массив строк =============");

        String[] strings1 = {"Str1", "Sttrq", "trtrf", "hello"};
        System.out.println(strings1.length);
        System.out.println("strings1[2] -> " + strings1[2]);

        int[] ints1 = {3, 5, 6, 7, 8}; // могу инициализировать значениями без оператора new;
        // ints1 = {1, 3, 54, 8, 6}; // Не допустимо. Ошибка компиляции. Перезаписать значения без использования new не получится
        ints1 = new int[] {1, 5, 6,};

        System.out.println(Arrays.toString(strings1)); // формирует представление массива в виде строки
        strings1[1] = "Java";
        System.out.println(Arrays.toString(strings1));



        String string = Arrays.toString(ints1); // формирует представление массива в виде строки
        System.out.println(string);


//        int var = 0;
//        var = 1;

        ints1[2] = 10; // присвоение нового значения элементу с индексом 2 нового значения
        System.out.println(Arrays.toString(ints1));



        // Создать массив из 10 элементов и заполнить его случайными числами от 0 до 100;
        Random random = new Random();

        int[] nums = new int[10];

        int k = 0;
        System.out.print("[");
        while (k < nums.length) {
            nums[k] = random.nextInt(101);
            System.out.print(nums[k] + ", ");
            k++;
        }
        System.out.println("]\n");

        // Найти минимальное значение в массиве.

        int l = 0;
        int min = nums[0];

        while (l < nums.length) {
            if (nums[l] < min) {
                min = nums[l];
            }
            l++;
        }
        System.out.println("минимальное значение в массиве: " + min);





    }
}
