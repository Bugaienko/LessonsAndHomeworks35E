package homework_16;

/*
@date 27.09.2023
@author Sergey Bugaienko
*/
/*
Task 2

Написать метод, принимающий строку и один или два индекса (перегрузка).
Метод должен возвращать подстроку начиная с первого индекса (включительно) и заканчивая вторым индексом (не включительно)
Если индекс 1 - начиная с индекса и до конца строки.

Функционал повторяет метод String.substring(), так что этот метод использовать не нужно.
Оригинальный метод ломает программу, если введены не корректные индексы.
Наш метод аварийно завершать программу не должен.
 */


/*
Task 3
Написать метод по поиску строки в массиве строк. На вход метод принимает массив строк, и строку для поиска.
 */

/*
Task 4

Написать метод, принимающий строку и возвращающий новую строку, состоящую из 2го и 3го символа входящей строки,
переведенных в верхний регистр.
Распечатать полученный результат в методе main

"Hello" -> "EL"
"He" -> "E"
"H" -> ???

 */
public class Task_02 {
    public static void main(String[] args) {

        String str = "0123456789";

        System.out.println(substring(str, 2, 5));

        System.out.println(substring(str, 4));

        String[] testStrings = {"String", null, "hello", "Java", "JavaScript"};
        String[] nullString = null;
        String findMe = "hello";

        System.out.println(searchStringInArray(nullString, findMe));
        System.out.println(searchStringInArray(testStrings, findMe));

        System.out.println(getTwoSymbolsString(str));
        System.out.println(getTwoSymbolsString("Hello"));

    }

    public static String getTwoSymbolsString(String str) {
        String result = "";

        if (str.length() > 1) {
            result += str.charAt(1);
        }
        if (str.length() > 2) {
            result += str.charAt(2);
        }

        return result.toUpperCase();
    }

    public static int searchStringInArray(String[] strings, String findMe) {
        if (strings == null || findMe == null) return -1;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null && strings[i].equals(findMe)) return i;
        }

        return -1;
    }

    public static String substring(String string, int idx1) {
        return substring(string, idx1, string.length());
    }

    public static String substring(String string, int idx1, int idx2) {
        String result = "";

        if (string == null || idx1 < 0 || idx1 > string.length() || idx2 < 0 || idx2 > string.length()) {
            return result;
        }

        // Option1
        if (idx1 > idx2) return result;
        char[] chars = new char[idx2 - idx1];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = string.charAt(i + idx1);
        }


        //Option2
        for (int i = idx1; i < idx2; i++) {
            result += String.valueOf(string.charAt(i));
        }

        return result;

//        return String.valueOf(chars);
    }
}
