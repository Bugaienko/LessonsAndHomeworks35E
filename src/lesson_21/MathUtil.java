package lesson_21;
/*
@date 04.10.2023
@author Sergey Bugaienko
*/

public class MathUtil {

    public static int symOfInts(int x, int... ints) {
        int sum = x;
        for (int value: ints) {
            sum += value;
        }

        return sum;
    }
}
