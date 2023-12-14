package lesson_66.homework65;
/*
@date 14.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tasks {
    public static void main(String[] args) {
        /*
        Найти все вхождения слова "apple", не следующего за словом "green".

        Пример строки: "red apple, green apple, just an apple"
        Ожидаемый результат: "apple", "apple"
         */

        Pattern pattern = Pattern.compile("(?<!green\\s)apple");
        Matcher matcher = pattern.matcher("red apple, green apple, just an apple");
        while (matcher.find()) System.out.println("startAt: " + matcher.start() + " | " + matcher.group());

        /*
        Найти слова, которые начинаются непосредственно после цифры.

        Пример строки: "3a, 4b, 5cat, d6, e7, f8"
        Ожидаемый результат: "a", "b", "cat"
         */

        Pattern pattern1 = Pattern.compile("(?<=\\d)\\w+");
        Matcher matcher1 = pattern1.matcher("3a, 4b, 5cat, d6, e7, f8");
        while (matcher1.find()) System.out.println("startAt: " + matcher1.start() + " | " + matcher1.group());

        /*
        Найти все имена пользователей, у которых домен в email-адресе "@example.com".

        Пример строки: "contact@example.com, user@test.com, admin@example.com"
        Ожидаемый результат: "contact", "admin"
         */

        Pattern pattern2 = Pattern.compile("\\b\\w+(?=@example.com\\b)");
        Matcher matcher2 =  pattern2.matcher("contact@example.com, user@test.com, admin@example.com");
        while (matcher2.find()) System.out.println("startAt: " + matcher2.start() + " | " + matcher2.group());


        /*
         Найти все слова, заключённого между двумя словами 'start' и 'end'.

        Пример строки: "start middle end, beginning center finish"
        Ожидаемый результат: "middle"
         */

        Pattern pattern3 = Pattern.compile("(?<=start\\s)(\\w+\\s?)+(?=\\send)");
//        Pattern pattern3 = Pattern.compile("(?<=start\\s)(.+)(?=\\send)");
        Matcher matcher3 = pattern3.matcher("start middle end, start middle word end, start middle, beginning center finish");
        while (matcher3.find()) System.out.println(matcher3.start() + " | " + matcher3.group());



    }
}
