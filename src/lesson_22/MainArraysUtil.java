package lesson_22;
/*
@date 05.10.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;

public class MainArraysUtil {

    public static void main(String[] args) {

        int[] ints = {25, 13, -56, 44, 57, 78, 34, 8, 10, 77, -25, 34};

        int searchMe = 150;




        ArraysUtil.minIndexSearch(ints, 3);

//        System.out.println(ArraysUtil.linearSearch(ints, searchMe));

        ArraysUtil.sortArray(ints);

        System.out.println(Arrays.toString(ints));

        System.out.println("результат бинарного поиска: "
                + ArraysUtil.binarySearch(ints, searchMe));


        int[] testInts = ArraysUtil.initTestArray(1_000_000);
        int[] searchValues = ArraysUtil.initTestArray(100);

//        Arrays.sort(testInts);

//        ArraysUtil.binarySearch(testInts, 1002);



        // возвращает текущее время в миллисекундах
        long startTime = System.currentTimeMillis();

        int[] resultFromLinear = new int[100];

        for (int i = 0; i < searchValues.length; i++) {
            resultFromLinear[i] = ArraysUtil.linearSearch(testInts, 1001);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Линейный поиск. Затрачено времени: " + (endTime - startTime));
//        System.out.println("Результаты поиска: " + Arrays.toString(resultFromLinear));


//        ArraysUtil.sortArray(testInts);
//
        startTime = System.currentTimeMillis();

        Arrays.sort(ints);



        resultFromLinear = new int[100];

        for (int i = 0; i < searchValues.length; i++) {
//            resultFromLinear[i] = Arrays.binarySearch(testInts, 1001);
            resultFromLinear[i] = ArraysUtil.binarySearch(testInts, 1001);
        }

        endTime = System.currentTimeMillis();

        System.out.println("Бинарный поиск. Затрачено времени: " + (endTime - startTime));


    }
}
