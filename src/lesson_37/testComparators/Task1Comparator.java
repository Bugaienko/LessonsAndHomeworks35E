package lesson_37.testComparators;
/*
@date 26.10.2023
@author Sergey Bugaienko
*/

import java.util.Comparator;

public class Task1Comparator implements Comparator<Integer> {
    @Override
    public int compare(Integer int1, Integer int2) {
        boolean isFirstEven = (int1 % 2) == 0;
        boolean isSecondEven = (int2 % 2) == 0;

        if (isFirstEven && !isSecondEven) { // первое четное, второе не четное -> первое должно быть "меньше" (т.е. располагаться левее)
            return -1;
        } else if (!isFirstEven && isSecondEven) { // второе четное, первое не четное -> первое должно быть "больше" (т.е. располагаться правее)
            return 1;
        } else { // оба либо четных, либо не четных - сортируем в порядке возрастания
            return Integer.compare(int1, int2);
        }

    }
}
/*
реализующий Comparator с методом сравнения для сортировки массива целых чисел в следующем порядке:
Четные целые числа должны идти перед нечетными числами
 */
