package lesson_64;
/*
@date 12.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part8 {
    public static void main(String[] args) {
        String string = "11-12-2023";
        Pattern pattern = Pattern.compile("(\\d{2})-(\\d{2})-(\\d{4})");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println("День: " + matcher.group(1));
            System.out.println("Месяц: " + matcher.group(2));
            System.out.println("Год: " + matcher.group(3));
            System.out.println("group 0: " + matcher.group(0));
            System.out.println(matcher.group());
        }
    /*
    Типы групп:
    1. Захватывающие группы (по умолчанию) - () - текст соответствующий части шаблона можно извлечь
    2. Не захватывающие группы - (?: ) - группируют часть шаблона, но не сохраняют текст соответствующий этой части шаблона
    3. Именованные группы - (?<name> ) - Используются для присвоения имени определенной группе.
    4. Условные группы - в Java практически не используются. Это группы, которые совпадают при выполнении определенного условия.

     */

        System.out.println("\n======================\n");

    Pattern pattern1 = Pattern.compile("(?:\\d{2})-(\\d{2})-(\\d{4})");
        Matcher matcher1 = pattern1.matcher(string);
        while (matcher1.find()) {
//            System.out.println("День: " + matcher1.group(1));
            System.out.println("Месяц: " + matcher1.group(1));
            System.out.println("Год: " + matcher1.group(2));
            System.out.println("group 0: " + matcher1.group(0));
            System.out.println(matcher1.group());
        }

        System.out.println("\n===========================\n");

        Pattern pattern2 = Pattern.compile("(?<day>\\d{2})-(?<month>\\d{2})-(?<year>\\d{4})");
        Matcher matcher2 = pattern2.matcher("Дата: 15-12-2002");
        while (matcher2.find()) {
            System.out.println("День: " + matcher2.group("day"));
            System.out.println("Месяц: " + matcher2.group("month"));
            System.out.println("Год: " + matcher2.group("year"));
            System.out.println("group 0: " + matcher2.group(0));
            System.out.println(matcher2.group());
        }


        String string1 = "Set or SetValue Value1 Set123 1236";
        Pattern pattern3 = Pattern.compile("Set(\\w+)+ (\\1\\d+)+");
        Matcher matcher3 = pattern3.matcher(string1);
        while (matcher3.find()) System.out.println(matcher3.group());

        // Найти все теги в тексте
        /*
        <p></p>
        <h1>Title</h1>
        <div class="dsfd">   </div>
         */

        //Найти все теги в тексте:
        String htmL = "This text <h1>Title</h1> <p class=\"p5\">text</p>";
        String htmL1 = "This text <div><h1>Title</h1></div> <p class=\"p5\">text</p>";

        Pattern pattern4 = Pattern.compile("<([a-z][a-z0-9]*)[^>]*>([^<]*)(</\\1>)");
        Matcher matcher4 = pattern4.matcher(htmL1);
        while (matcher4.find()) {
            System.out.printf("Найден тег <%s> - %s. Текст внутри: %s\n", matcher4.group(1), matcher4.group(3), matcher4.group(2));
            System.out.println("group: " + matcher4.group());
        }

        System.out.println("\n============================\n");

        // Поменять формат дат в тексте DD-MM-YYYY -> YYYY-MM-DD
        String text = "Сегодняшняя дата 13-12-2023, а завтра будет 14-12-2023";
        System.out.println(text);
        Pattern pattern5 = Pattern.compile("(\\d{2})[-/](\\d{2})[-/](\\d{4})");
        Matcher matcher5 =  pattern5.matcher(text);
        while (matcher5.find()) {
            System.out.println(matcher5.group(1));
            System.out.println(matcher5.group(2));
            System.out.println(matcher5.group(3));
            System.out.println(matcher5.group());
        }
        String newText = matcher5.replaceAll("$3-$2-$1"); // "2023-12-13
        System.out.println(newText);

        System.out.println("\n=============================\n");

        // удаление повторяющихся слов
        System.out.println("the the there    there".replaceAll("\\b(\\w+)\\s+\\1\\b", "$1"));



    }
}
