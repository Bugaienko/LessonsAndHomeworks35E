package lesson_63;
/*
@date 11.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {
    public static void main(String[] args) {
        /*
        . - точка. Соответствует любому символу, кроме символа новой строки. В некоторых режимах (DOTALL) - будет соответствовать и переводу строки тоже

        \d - соответствует любой цифре - эквивалент [0-9]
        \D - соответствует любому символу, который НЕ является цифрой

        \w - соответствует любому буквенно-цифровому символу или символу подчеркивания. Буквы латинского алфавита. Экв: [a-zA-Z0-9_]
        \W - отрицание \w. Любому символу, который не является буквенно-цифровым или подчеркиванием. Экв: [^a-zA-Z0-9_]

        \s - соответствует любому пробельному символу (пробелы, табуляции, новые строки) Экв: [\t\n\f\r\x0B]
        \S  - соответствует любому НЕпробельному символу

        \b - границы слова
         */

        String testText = "abC- 913 %\nd f_g5^7 фба";
//        System.out.println(testText);

        Pattern pattern = Pattern.compile(".");
        Matcher matcher = pattern.matcher(testText);
        // while (matcher.find()) System.out.println("matcher . :" + matcher.group());

//        Pattern pattern1 = Pattern.compile("\\d");
//        Pattern pattern1 = Pattern.compile("\\D");
//        Pattern pattern1 = Pattern.compile("\\w");
//        Pattern pattern1 = Pattern.compile("\\W");
        Pattern pattern1 = Pattern.compile("\\S");
        Matcher matcher1 = pattern1.matcher(testText);
        while (matcher1.find()) System.out.println(matcher1.group());

        //Методы класса Matcher
        /*
        find() -
        matches() - проверяет соответствует ли весь текст шаблону целиком. Возвращает boolean
        group() - Используется для получение части текста, которая соответствует шаблону или части шаблону (если использовались группы).
        start() - Возвращает индекс начала текущего совпадения.
        end() - Возвращает индекс, следующий за последним символом текущего совпадения


        */

        String s = "cats";
        Pattern pattern2 = Pattern.compile("cat[o-t]");
        Matcher matcher2 = pattern2.matcher(s);
        if (matcher2.matches()) {
            System.out.println("Весь текст соответствует шаблону");
        } else  {
            System.out.println("Текст не соответствует шаблону");
        }

        System.out.println(" ============================ \n");
        String text = "The cat sat on the mat cat";
        Pattern pattern3 = Pattern.compile("[cm]at");
        Matcher matcher3 = pattern3.matcher(text);
        while (matcher3.find()) {
            System.out.println("Совпадение start: " + matcher3.start());
            System.out.println("Совпадение end: " + matcher3.end());
            System.out.println("Совпадение: " + matcher3.group());
            System.out.println("Substring: " + text.substring(matcher3.start(), matcher3.end()));
        }











    }
}
