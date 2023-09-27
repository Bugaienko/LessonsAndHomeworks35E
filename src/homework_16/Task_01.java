package homework_16;

import java.util.Arrays;

/*
@date 27.09.2023
@author Sergey Bugaienko
*/
/*
Написать метод swap, принимающий на вход массив целых чисел, и два индекса.
Метод должен поменять местами значения, хранящихся в этих индексах

{0, 1, 2, 3, 4, 5, 6} -> swap(arr, 1, 5} -> {0, 5, 2, 3, 4, 1, 6}
Если индексы за пределами массива?

Перегрузка метода для работы с массивами строк.
 */
public class Task_01 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};

        swap(array, 1, 5);
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] ints, int idx1, int idx2) {

        if (idx1 < 0 || idx2 < 0 || idx1 >= ints.length || idx2 >= ints.length) return;

        int temp = ints[idx1];
        ints[idx1] = ints[idx2];
        ints[idx2] = temp;

    }
}
