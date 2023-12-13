package lesson_65.homework64;
/*
@date 13.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tasks {
    public static void main(String[] args) {
        /*
        Напишите регулярное выражение для извлечения имени пользователя и домена из email-адресов.

        Пример строки: "Контакт: email@example.com"
        Ожидаемый результат: "Имя пользователя: email, Домен: example.com"
         */

        Pattern pattern = Pattern.compile("\\b([a-z][a-zA-Z_\\-#&!*]{2,})@(\\w{3,}\\.[a-zA-Z]{2,3})\\b");
        Matcher matcher = pattern.matcher("Контакт: email@example.com");
        while (matcher.find())
            System.out.printf("Имя пользователя: %s, Домен: %s\n", matcher.group(1), matcher.group(2));

        /*
        Найти первое слово в кавычках в строке.

        Пример строки: "Она сказала: 'быстро', а потом добавила: 'осторожно'."
        Ожидаемый результат: "быстро"
         */

        Pattern pattern1 = Pattern.compile("'([а-яА-Я]+)'");
        Matcher matcher1 = pattern1.matcher("Она сказала: 'быстро', а потом добавила: 'осторожно'.");
        int counter = 0;
        while (matcher1.find()) {
            if (counter < 1) {
                System.out.println(matcher1.group(1));
                counter++;
            }
        }

        System.out.println("\n================================\n");
        /*
        Написать регулярное выражение для извлечения текста из определенного HTML-тега (например, <p>).

        Пример строки:
        "<p>Это пример текста.</p> <p>Это другой текст.</p>"
        Ожидаемый результат: "Это пример текста.", "Это другой текст."
         */

        Pattern pattern2 = Pattern.compile("<p>(.+?)</p>");
        Matcher matcher2 = pattern2.matcher("<p>Это пример текста.</p> <p>Это другой текст.</p>");
        while (matcher2.find()) System.out.println(matcher2.group());

        System.out.println("\n================================\n");

        /*
        Написать регулярное выражение для замены формата даты с "ДД-ММ-ГГГГ" на "ММ/ДД/ГГГГ".

        Пример строки: "Дата: 15-03-2023"
        Ожидаемый результат: "Дата: 03/15/2023"
         */

        Pattern pattern3 = Pattern.compile("(\\d{2})-(\\d{2})-(\\d{4})");
        Matcher matcher3 = pattern3.matcher("Дата: 15-03-2023");
        String newText = matcher3.replaceAll("$2/$1/$3");
        System.out.println(newText);

    }
}
