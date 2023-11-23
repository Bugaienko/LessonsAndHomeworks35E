package lesson_55.homework54;
/*
@date 23.11.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;

/*
Разбейте строку на слова, используя в качестве разделителя пробел.
Используя функцию reduce верните суммарное количество букв в словах, которые длиннее 4 символов
 */
public class Task2 {
    public static void main(String[] args) {
        String text = "Hello, world and good afternoon";
        int countLetters = countLetters(text);
        System.out.println("countLetters: " + countLetters);
    }

    private static int countLetters(String text) {
        //Option 1
        String[] words = text.replaceAll("[^a-zA-Z ]", "").split("\\s+");

        return Arrays.stream(words)
                .map(String::length)
                .filter(i -> i > 4)
                .reduce(0, (i1, i2) -> i1 + i2);
//                .reduce(0, Integer::sum);

    }

    private static int countLetters2(String text) {
        //Option 1
        String[] words = text.split("\\s+");

        long count = Arrays.stream(text.split("\\s+"))
                .filter(word -> word.length() > 4)
                .flatMapToInt(String::chars)
                .mapToObj(i -> (char) i)
                .filter(Character::isAlphabetic)
                .count();
        return (int) count;

    }
}
