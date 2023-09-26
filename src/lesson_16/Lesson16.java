package lesson_16;
/*
@date 26.09.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;
import java.util.Random;

public class Lesson16 {

    public static void main(String[] args) {

        Random random = new Random();

        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 14, 15};


        // toString() - возвращает представление массива в виде строки
        System.out.println(Arrays.toString(ints));

        // Создает новый массив, заданной длины. При этом копирует элементы из старого массива
        // Кол-во копируемых элементов равно новой длине массива.
        // Если длина нового массива больше, чем старого - оставшиеся ячейки заполняются значениями по умолчанию
        int[] newInts = Arrays.copyOf(ints, 5);
        System.out.println(Arrays.toString(newInts));

        int[] newInts1 = copyOfArray(ints, 5);
        System.out.println(Arrays.toString(newInts1));


        // copyOfRange создает новый массив, записав в него значения от индекса 'from' до индекса 'to'. Последний индекс не включен
        int[] ints1 = Arrays.copyOfRange(ints, 2, 5); // 2, 3, 4
        System.out.println("copyOfRange: " + Arrays.toString(ints1));

        int[] ints2 = copyOfRange(ints, 2, 5);
        System.out.println("copyOfRange my: " + Arrays.toString(ints2));

//        String[] strings = {"Hello", "Java", "world"};
//        String[] strings1 = Arrays.copyOfRange(strings, 0, 2);
//        System.out.println(Arrays.toString(strings1));


        // метод fill заполняет массив указанными значениями, в том числе случайными
        int[] ints3 = new int[7];
        Arrays.fill(ints3, random.nextInt(101));
        System.out.println(Arrays.toString(ints3));

        int[] numbers = {1, 2, 3, 4};
        int[] ints4 = {1, 2, 3, 4, 5};
        int[] newLink = ints4;

        boolean isEquals;

        // Arrays.equals() - сравнение двух массивов по значениям
        isEquals = numbers == ints4; // false
        isEquals = numbers.equals(ints4); // false
        isEquals = Arrays.equals(numbers, ints4); // true
        System.out.println("isEquals: " + isEquals);

        //проверяем работу нашего метода сравнения массивов по значениям
        boolean isArraysEquals = isEqualsArrays(numbers, ints4);
        System.out.println("результат сравнения массивов по значению: " + isArraysEquals);
        System.out.println("результат сравнения массивов по значению: " + isEqualsArrays(ints4, newLink));

        int[][] doubleArray = new int[5][5];
        int[][] testArray = new int[5][5];

        // заполняем двумерный массив случайными числами
        for (int i = 0; i < doubleArray.length; i++) {
            for (int j = 0; j < doubleArray[0].length; j++) {
                int temp = random.nextInt(101);
                doubleArray[i][j] = temp;
                testArray[i][j] = temp;
            }
        }

        // deepToString() - позволяет получить строковое представление многомерных массивов
        System.out.println(Arrays.deepToString(doubleArray));
        System.out.println(Arrays.deepToString(testArray));

        // deepEquals() - сравнивает многомерные массивы по значениям
        System.out.println("сравнение по значение двумерных массивов: " + Arrays.deepEquals(doubleArray, testArray));

        int[] numbers1 = {10, 11, 12, 14, 14, 15, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // сортировка массива
        Arrays.sort(numbers1);

        // {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 14, 15};
        System.out.println(Arrays.toString(numbers1));

        // Поиск элемента в массиве. Возвращает индекс или отрицательное значение. Работает быстрее, чем поиск перебором всех значений
        System.out.println("binarySearch: " + Arrays.binarySearch(numbers1, -10));

        int[] arrSystemCopy = new int[10];  // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        // System.arraycopy - имеет 5 параметров.
        // Массив-донор (откуда берем значения);
        // Индекс с которого берем значения;
        // Массив в который будут вставлены значения;
        // индекс с которого начнут записываться значения;
        // кол-во копируемых значений;

        System.arraycopy(numbers1, 3, arrSystemCopy, 5, 5);

        systemArrayCopy(numbers1, 3, arrSystemCopy, 2, 5);
        System.out.println("System.arraycopy: " + Arrays.toString(arrSystemCopy));


        // метод substring при работе со String-ами. Выделяет подстроку из строки
        //               0123456759
        String string = "Hello Java";

        String subString = string.substring(6); // выделяет подстроку начиная с индекса 6 и до конца строки
        subString = string.substring(6, 8); // выделяет подстроку с 6 до (8-1) индекса
        System.out.println("subString: " + subString);

        System.out.println(" ============================ ");
        System.out.println(Arrays.toString(ints));

        int[] ints5 = copyOfRange(ints, 4);
        System.out.println(Arrays.toString(ints5));

        // string.replace() - заменяет один char на другой. Возвращает новую строку
        String replacedString = string.replace('a', '_');
        replacedString = string.replace("a", "Etwas");
        System.out.println(replacedString);
        System.out.println(string.replaceFirst("Java", "Python"));


        char[] chars1 = string.toCharArray();
        System.out.println(Arrays.toString(chars1));



    } // Methods area

    public static void systemArrayCopy(int[] old, int indexFrom, int[] newArr, int indexTo, int count) {
        for (int i = 0; i < count; i++) {
            newArr[indexTo + i] = old[indexFrom + i];
        }
    }

    public static boolean isEqualsArrays(int[] a, int[] b) {

        /*
        0. Сравним ссылки. Если обе ссылаются на один объект (массив) - говорим что значения в них равны. Если не равны - проверяем значения
        1. сравним длины массивов. Если разный - содержимое массивов не равно -> возвращаем false
        2. Берем цикл. Перебираем индексы. Сравниваем значения. Как только находим не равные - возвращаем false
        3. Прошли цикл - значит не нашли не равные значения - возвращаем true
        */

        // Сравниваем ссылки
        boolean tempEquals = a == b;
        if (tempEquals) {
            System.out.println("Ссылки равны");
            return true;
        }

        // Сравниваем длины. Если не равны - возвращаем false
        tempEquals = a.length != b.length;
        if (tempEquals) return false;

        //Перебираем значения и сравниваем. Если найдем не равные - возвращаем false
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static int[] copyOfRange(int[] array, int begin) {
        return copyOfRange(array, begin, array.length);
    }

    public static int[] copyOfRange(int[] array, int begin, int end) {
        if (end < begin) return new int[0];

        int[] result = new int[end - begin];
        int counter = 0;

        for (int i = begin; i < end; i++) {
            result[counter++] = array[i];
        }
        return result;
    }

    public static int[] copyOfArray(int[] array, int newLength) {
        int[] result = new int[newLength];

        for (int i = 0; i < result.length && i < array.length; i++) {
            result[i] = array[i];
        }

        return result;
    }
}
