package lesson_62;
/*
@date 06.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) {
/*
        Pattern - класс для определения шаблона регулярного выражения
        Matcher - класс для выполнения операций поиска по шаблону

        Pattern.compile(String regexp) - компилирует регулярное выражение в шаблон (статический)
        pattern.matcher(String input) - создает объект Matcher для поиска шаблона в тексте (input)\
        boolean matcher.find() - ищет следующее совпадение
        matcher.matches() - проверяет, соответствует ли весь текст шаблону
        matcher.group() - используется для получения части текста, которая соответствует шаблону

        // [].^$*+?{}\()
 */

        // String regEmail = "^[_A-Za-z0-9-\\\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile("a");
        String text = "Jack is a cat";
        Matcher matcher = pattern.matcher(text);

        //System.out.println("find: " + matcher.find());
        while (matcher.find()) {
            System.out.println("совпадение: " + matcher.group());
        }

        Pattern pattern1 = Pattern.compile("cat");
        Matcher matcher1 = pattern1.matcher("Text with cats and dogs");
        while (matcher1.find()) {
            System.out.println("matcher1: " + matcher1.group());
        }


        Pattern pattern2 = Pattern.compile("12");
        Matcher matcher2 = pattern2.matcher("Пример 123 текста с числом 456");
        while (matcher2.find()) {
            System.out.println("matcher2: " + matcher2.group());
        }


        // []{}().^$*+?\
        // Экранирование \ - используется для экранирования
        Pattern pattern3 = Pattern.compile("1\\+1=2 \\^");
        Matcher matcher3 = pattern3.matcher("1+1=2 ^");
        while (matcher3.find()) {
            System.out.println("matcher3: " + matcher3.group());
        }

        // Экранирование группы \Q...\E
        Pattern pattern4 = Pattern.compile("\\Q[].^$*+?{}\\()\\E");
        Matcher matcher4 = pattern4.matcher("[].^$*+?{}\\()");
        while (matcher4.find()) {
            System.out.println("matcher4: " + matcher4.group());
        }

        Pattern pattern5 = Pattern.compile("aba");
        Matcher matcher5 = pattern5.matcher("abababa");
        int counter = 0;
        while (matcher5.find()) {
            counter++;
            System.out.println("matcher5: " + matcher5.group());
        }
        System.out.println("Найдено совпадений: " + counter);

    }
}
