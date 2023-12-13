package lesson_64.homework63;
/*
@date 12.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tasks {
    public static void main(String[] args) {
        /*
        Напишите регулярное выражение для поиска всех почтовых индексов, состоящих из пяти цифр.

        Пример строки: "Мой индекс 12345, а его индекс 67890. А число 456789 не подходит"
        Ожидаемый результат: "12345", "67890"
         */
        Matcher matcher = Pattern.compile("\\b\\d{5}\\b").matcher("Мой индекс 12345, а его индекс 67890. А число 456789 не подходит");
        while (matcher.find()) System.out.println("0: startAt: " + matcher.start() + " : " + matcher.group());

        /*
        Найти все слова, начинающиеся с "re".
        Пример строки: "I need to rewrite and reread these re reports."
        Ожидаемый результат: "rewrite", "reread", "reports"
         */
        Matcher matcher1 = Pattern.compile("\\bre[a-zA-Z]+").matcher("I need to rewrite and reread these re reports.");
        while (matcher1.find()) System.out.println("1: startAt: " + matcher1.start() + " : " + matcher1.group());

        /*
        Найти все номера телефонов в формате "+XXX-XXX-XXXX".

        Пример строки: "Мои номера: +123-456-7890, +987-654-3210."
        Ожидаемый результат: "+123-456-7890", "+987-654-3210"
         */

        Pattern pattern2 = Pattern.compile("\\+\\b\\d{3}-\\d{3}-\\d{4}\\b");
        Matcher matcher2 = pattern2.matcher("Мои номера: +123-456-7890, +987-654-3210.");
        while (matcher2.find()) System.out.println("2: startAt: " + matcher2.start() + " : " + matcher2.group());

        /*
        Найти все email-адреса.

        Пример строки: "Мои контакты: email@example.com, test.email@domain.ru."
        Ожидаемый результат: "email@example.com", "test.email@domain.ru"
         */

        // test.rre@example.com
        // test.r[1_-#&%!]@example.co1.uk


        Pattern pattern3 = Pattern.compile("\\b([a-zA-Z]\\w{1,2}[\\w%#!&*]?\\.?[\\w%#!&*]+)@[a-zA-Z]{3,}\\.?[a-zA-Z]{3,}\\.[a-zA-Z]{2,3}\\b");
        Matcher matcher3 = pattern3.matcher("Мои контакты: email@example.com, test.email@domain.ru.");
        while (matcher3.find()) {
            System.out.println("email: startAt: " + matcher3.start() + " : " + matcher3.group());
            System.out.println("userName: " + matcher3.group(1));
        }

    }
}
