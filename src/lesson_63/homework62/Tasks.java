package lesson_63.homework62;
/*
@date 11.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tasks {
    public static void main(String[] args) {

        /*
        Напишите регулярное выражение, которое находит все отдельные цифры меньше 7 в строке.

            Пример строки: "Моя дата рождения 2.6.1990"
            Ожидаемый результат: "2", "6", "1", "0"
         */

        Matcher matcher = Pattern.compile("[0-6]").matcher("Моя дата рождения 2.6.1990");
        while (matcher.find()) System.out.println("task1: " + matcher.group());

        /*
        Напишите регулярное выражение, чтобы найти все вхождения символов @ '&', '!' в строке.

        Пример строки: "myemail@example.co!m another&email@example.com"
        Ожидаемый результат: "@", "!", "&", "@"
         */

        Pattern pattern1 = Pattern.compile("[@&!]");
        Matcher matcher1 = pattern1.matcher("myemail@example.co!m another&email@example.com");
        while (matcher1.find()) System.out.println("task2: " + matcher1.group());

        /*
        Напишите регулярное выражение, чтобы найти все заглавные буквы в строке.

        Пример строки: "London is the capital of Great Britain."
        Ожидаемый результат: "L", "G", "B"
         */

        Matcher matcher2 = Pattern.compile("[A-Z]").matcher("London is the capital of Great Britain.");
        while (matcher2.find()) System.out.println("task3: " + matcher2.group());

        /*
        Создайте регулярное выражение для поиска всех вхождений букв 'b' и 'B' в строке.

        Пример строки: "Bears, Bees, and Bunnies are beautiful."
        Ожидаемый результат: "B", "B", "B", "b"
         */

        Matcher matcher3 = Pattern.compile("[bB]").matcher("Bears, Bees, and Bunnies are beautiful.");
        while (matcher3.find()) System.out.println("task4: " + matcher3.group());

    }
}
