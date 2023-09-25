package homework_13;

/**
 * @author Sergii Bugaienko
 */
/*
Дано: Два отсортированных массива целых чисел.
Вам нужно найти элемент, который будет находиться на k-й позиции в объединенном отсортированном массиве.

Массив 1 - {100, 112, 256, 349, 770}
Массив 2 - {72, 86, 113, 119, 265, 445, 892}
k = 7
Вывод : 256

Можно такой вывод:

72, 86, 100, 112, 113, 119, 256
Искомое число: 256
Объединенный отсортированный массив был бы такой (выводить, формировать его не обязательно) -

[72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]
 */

public class Task_03 {
    public static void main(String[] args) {

//        int[] arrA = {1, 3};
//        int[] arrB = {2, 4, 5, 6, 7};

        int[] arrA = {100, 112, 256, 349, 770};
        int[] arrB = {72, 86, 113, 119, 265, 445, 892};

        int positionForSearch;
        positionForSearch = 7;

        System.out.println(searchIntByIndex(arrA, arrB, positionForSearch));
    }

    private static int searchIntByIndex(int[] arrA, int[] arrB, int positionForSearch) throws RuntimeException{
        if (positionForSearch > arrA.length + arrB.length || positionForSearch < 1)
            throw new RuntimeException("Error!");
        int cursor = 0;
        int aPos = 0;
        int bPos = 0;


        while (aPos + bPos < positionForSearch) {
            if (aPos < arrA.length && bPos < arrB.length && arrA[aPos] < arrB[bPos]) {
                cursor = 0;
                System.out.print(arrA[aPos] + ", ");
                aPos++;
            } else if (bPos < arrB.length) {
                cursor = 1;
                System.out.print(arrB[bPos] + ", ");
                bPos++;
            } else {
                cursor = 0;
                System.out.print(arrA[aPos] + ", ");
                aPos++;
            }


        }

        System.out.println();
        if (cursor == 1) return arrB[bPos - 1];
        return arrA[aPos - 1];
    }
}
