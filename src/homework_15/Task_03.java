package homework_15;
/*
@date 26.09.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;

/*
Task 3

Написать метод, принимающий на вход массив строк.
Метод должен вернуть массив, состоящий из самой короткой и самой длинной строки изначального массива.
 */
public class Task_03 {
    public static void main(String[] args) {
//        String[] strings = null;
//        String[] strings = {null, null, "Str"};
        String[] strings = {"String", null, "hello", "example"};

        String[] twoString = createArrayWithSmallestAndLongestStringOfArray(strings);

        System.out.println(Arrays.toString(twoString));
    }


    public static String[] createArrayWithSmallestAndLongestStringOfArray(String[] strings) {
        String[] result = new String[2];

        if (strings == null || strings.length == 0) {
            return result;
        }
        System.out.println("Проверка на null и длину массива завершена");

        String minLenStr = strings[0];
        String maxLenStr = strings[0];

        for (String str : strings) {
            // код находит самую короткую и самую длинную строку в массиве
            // и записывать их в результирующий массив

            // str -> null (str != null) -> (null != null) = false
            if (str != null &&  str.length() < minLenStr.length()) {
                minLenStr = str;
            }
            if (str != null && str.length() > maxLenStr.length()) maxLenStr = str;
        }

        result[0] = minLenStr;
        result[1] = maxLenStr;

        return result;
    }
}
