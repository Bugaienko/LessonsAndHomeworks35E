package homework_13;
/*
@date 25.09.2023
@author Sergey Bugaienko
*/
/*
Написать метод, принимающий массив целых чисел
и распечатывающий массив в обратной последовательности.

{1, 4, 3, 6, 7} -> распечатывает [7, 6, 3, 4, 1]

Перегрузить метод, если в него приходит индекс, то часть массива слева до этого индекса распечатывается в обычном порядке,
 а начиная с этого индекса в обратном:
{1, 4, 3, 6, 7} + индекс 2 - > распечатывает [1, 4, 7, 6, 3]

Еще одна перегрузка: метод принимает массив и булевый флаг.
Если флаг == true -> печатает массив в обратном порядке Если флаг == false -> печатает массив в прямом порядке
 */

public class Task_00 {

    public static void main(String[] args) {
        int[] testArray = new int[]{1, 4, 3, 6, 7};
        printReverseArray(testArray);

        printReverseArray(testArray, 2);
        printReverseArray(testArray, false);


    } // Methods area

    public static void printReverseArray(int[] arr, boolean flag) {
        if (flag) {
            // reverse
            printReverseArray(arr);
        } else {
            //direct
            printReverseArray(arr, arr.length);
        }
    }


    public static void printReverseArray(int[] arr, int idx) {
        for (int i = 0; i < idx; i++) {
            System.out.print(arr[i] + ", ");
        }

        for (int i = arr.length - 1; i >= idx; i--) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void printReverseArray(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
