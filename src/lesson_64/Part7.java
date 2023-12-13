package lesson_64;
/*
@date 12.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part7 {
    public static void main(String[] args) {
        /*
        Режимы работы квантификаторов:
        Ленивый режим - Добавлением `?` после квантификатора и делает его "ленивым" (минимальным). a+? -> "aaaaaa" -> "a"
        Жадный режим - он является режимом по умолчанию. Пытается найти соответствие максимально возможному количеству символов. a+ -> "aaaaaa" -> "aaaaaa"
        Ревнивый (владеющий) режим. Включается `+`. Он похож на жадный режим, но не позволяет откатываться. a++ -> "aaaaaa" -> "aaaaaa"

         */

        String text = "Это <пример> с <несколькими> тегами.";

        //Я хочу найти текст внутри скобок <...>

        // жадный (по умолчанию)
        Pattern pattern = Pattern.compile("<.*>");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) System.out.println("Жадный: " + matcher.group() );

        // Ленивый
        Pattern pattern1 = Pattern.compile("<.*?>");
        Matcher matcher1 = pattern1.matcher(text);
        while (matcher1.find()) System.out.println("Ленивый: " + matcher1.group() );

        //Владеющий
        Pattern pattern2 = Pattern.compile("<.*+>");
        Matcher matcher2 = pattern2.matcher(text);
        while (matcher2.find()) System.out.println("Ревнивый: " + matcher2.group() );

        String stringA = "aaaaaaab";
        Pattern pattern3 = Pattern.compile(".+?");
        Matcher matcher3 = pattern3.matcher(stringA);
        while (matcher3.find()) System.out.println("A: " + matcher3.group() );

    }
}
