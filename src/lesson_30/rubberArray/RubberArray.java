package lesson_30.rubberArray;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;
import java.util.Random;

public class RubberArray<T> {
    private T[] array; // можно инициализировать поле при его объявлении = new int[10];
    private int cursor;
    static final int MULTIPLIER = 2;

    Random random = new Random();

    public RubberArray() {
        array = (T[]) new Object[10];
    }

    public RubberArray(int sizeDefault) {
        array = (T[]) new Object[sizeDefault];
    }

    public void add(T number) {
        if (cursor == array.length - 1) {
            expandArray();
        }
        array[cursor++] = number;
    }


    public void add(T... values) {
        /* могу обращаться как с массивом (перебирать по индексам)
        for (int i = 0; i < ints.length; i++) {
            ints[i]
        }
         */
        // ints[0] = 100;

        for (int value : values) {
            add(value);
        }
    }

    /* не используем
    public void addRandomValues(int count, int bound) {
        for (int i = 0; i < count; i++) {
            add(random.nextInt(bound));
        }
    }

    public void addRandomValues(int count) {
        addRandomValues(count, 101);
    }
     */

    private void expandArray() {
//        int[] newArray = Arrays.copyOf(array, array.length * 2);
        T[] newArray = (T[]) new Object[array.length * MULTIPLIER];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < cursor; i++) {
            result += array[i] + ((i < cursor - 1) ? ", " : "]");
        }
        return result;
    }

    public int length() {
        return cursor;
    }

    public int indexOf(int number) {
        // 1. Перебрать массив, сравнить элементы, вернуть индекс
        // Если совпадений нет - вернуть минус 1.

        for (int i = 0; i < cursor; i++) {
            if (array[i] == number) return i;
        }
        return -1;
    }

    public int lastIndexOf(int number) {

        for (int i = cursor - 1; i >= 0; i--) {
            if (array[i] == number) return i;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) >= 0; //переиспользуем уже написанный код (метод)
    }

    public boolean remove(int value) {
        int index = indexOf(value);
        removeByIndex(index);
        return index >= 0;
    }

    public int[] toArray() {
        int[] result = new int[cursor];
        for (int i = 0; i < cursor; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public void trim() {
        System.out.println("Текущий array1: " + Arrays.toString(array));
        array = toArray();
        System.out.println("Текущий array2: " + Arrays.toString(array));
    }

    public int removeByIndex(int index) {
        if (index < 0 || index > cursor - 1) return Integer.MIN_VALUE;
        int value = array[index];

        int[] result = new int[array.length - 1];

        /* // Option1
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(array, index + 1, result, index, cursor - 1- index);
        System.out.println(Arrays.toString(result));
         */

        //Option2
//        for (int i = 0; i < cursor - 1; i++) {
        for (int i = 0; i < result.length; i++) {
            if (i < index) {
                result[i] = array[i];
            } else { // i >= index
                result[i] = array[i + 1];
            }
        }

        cursor--;
        array = result;

        return value;
    }
}


/*
-+ 1. Динамическое изменение размера массива
-- 2. Добавление элемента (значения) в массив
-- 9. Добавлять в массив сразу несколько элементов
-- 3. Поиск значений в массиве
-- 3.1. Поиск последнего вхождения элемента
-- 4. Удаление элемента по значению из массива
-- 5. Удаление элемента по индексу из массива
6. Найти мин, макс, среднее, сумму элементов
-- 7. Количество элементов в массиве
-- 8. Строковое представление массива (для вывода в консоль, например)
-- 10. Добавить в массив Х случайных значений
-- 11. Добавить в массив Х случайных значений в диапазоне от 0 до У;
-- 12. Вернуть наш резиновый массив в виде обычного массива


 */


/*
        int[] ints = new int[1000];
        int[] ints1 = {1, 2, 3, 4, 5};
        int number = 100;
        // добавь значение number в конец массива
        // {1, 2, 3, 4, 5, 100};
        // удаление элемента по значение (5) -> {1, 2, 3, 4, 100};

        // добавь в массив 6,7,8,9 -> {1, 2, 3, 4, 100, 6, 7, 8, 9};


        for (int i = 0; i < ints.length; i++) {

*/