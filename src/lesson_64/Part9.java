package lesson_64;
/*
@date 12.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part9 {
    public static void main(String[] args) {
        /*
        Еще методы класса Matcher:
        replaceFirst(String replacement) - Заменяет первое совпадение шаблона указанной заменой
        replaceAll(String str) - заменяет все совпадения в тексте
        reset(String str) - сбрасывает Matcher для повторного использования
        groupCount() -возвращает количество групп захвата

         */

        String string = "The cat sat on the cat";
        Pattern pattern = Pattern.compile("cat");
        Matcher matcher = pattern.matcher(string);
        String replacement = matcher.replaceFirst("dog");
        String replacement1 = matcher.replaceAll("dog");
        System.out.println(replacement);
        System.out.println(replacement1);

        System.out.println("\n============================\n");

        Matcher matcher1 = pattern.matcher(string);
        System.out.println(matcher1.find());
        matcher1.reset("The dog sat"); // Сброс и использование с новой строкой
        System.out.println(matcher1.find());

        System.out.println("\n==========================\n");
        Pattern pattern1 = Pattern.compile("(?:\\w+) (\\w+)");
        Matcher matcher2 = pattern1.matcher("Hello World");
        int count = matcher2.groupCount();
        System.out.println("Кол-во групп: " + count);
    }
}
