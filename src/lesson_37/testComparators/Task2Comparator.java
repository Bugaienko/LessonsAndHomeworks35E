package lesson_37.testComparators;
/*
@date 26.10.2023
@author Sergey Bugaienko
*/

import java.util.Comparator;

public class Task2Comparator implements Comparator<Integer> {


    @Override
    public int compare(Integer int1, Integer int2) {
        boolean isFirstEven = (int1 % 2) == 0;
        boolean isSecondEven = (int2 % 2) == 0;

        if (isFirstEven && isSecondEven) { // оба числа четных. Сравниваем их в порядке возрастания
            return int1 - int2;
        } else if (isFirstEven) { // первое четное, второе не четное -> первое должно быть "меньше" (т.е. располагаться левее)
            return -1;
        } else if (isSecondEven) { // первое не четное, второе четное -> второе должно быть "меньше" (т.е. располагаться левее)
            return 1;
        } else { // оба не четных - сортируем в порядке убывания
            return Integer.compare(int2, int1);
        }

    }
}

/*
Четные целые числа должны идти перед нечетными числами в порядке возрастания.
Нечетные целые числа должны идти после четных в порядке убывания
 */
