package homework_13;
/*
@date 25.09.2023
@author Sergey Bugaienko
*/
/*
Task 2 опционально

Написать свой метод copyOfArray, дублирующий функционал метода Arrays.copyOf()

на вход принимает массив целых чисел и число - длину нового массива.
Метод должен создать и распечатать массив заданной в параметрах длинны.
В начало массива должны быть скопированы элементы из входящего массива:

{0, 1, 2, 3, 4, 5, 6} -> copyOfArray(array, 3) -> вывод на печать {0, 1, 2}
Arrays.copyOf() использовать нельзя. Суть задачи - написать собственную реализацию этого метода

 */
public class Task_02 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        copyOfArray(array, 10);

    }
    /*
    {1,2,3,4} => length = 4
    option1 -> создать меньший или равный массив
    option2 -> создать массив большей длины
    null
     */

    public static void copyOfArray(int[] ints, int newLength) {
        /*
        1. Массив заданной (новой) длины
        2. Переписать в новый массив значения из старого -> сколько значений
        2.1. Решить сколько значений перезаписываем
         */
        int[] result = new int[newLength]; // {0, 0, 0, 0}

        // int shortestLength = (newLength < ints.length) ? newLength : ints.length;
        // можно определить какой массив короче и в цикле идти именно по нему

        for (int i = 0; i < ints.length && i < newLength; i++) {
            result[i] = ints[i];
        }
        printArray(result);

    }
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ((i < arr.length -1) ? ", " : "]\n"));
        }
    }
}
