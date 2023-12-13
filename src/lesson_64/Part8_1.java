package lesson_64;
/*
@date 12.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part8_1 {

    /*
    При обращении к значению именованной группы используется синтаксис \k<name>
     */

    public static void main(String[] args) {
        String text = "hello hello";
        Pattern pattern = Pattern.compile("(?<word>\\w+)\\s+\\k<word>");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) System.out.println("Найден повтор: " + matcher.group("word"));
//        String s = "hello".replaceAll("(?<w1>hello)", "Hello, ${w1}");
//        System.out.println(s);

        text = matcher.replaceAll("${word}");


        String htmL1 = "This text <div><h1>Title</h1></div> <p class=\"p5\">text</p>";

        Pattern pattern4 = Pattern.compile("<(?<gr1>[a-z][a-z0-9]*)[^>]*>([^<]*)(</\\k<gr1>>)");
        Matcher matcher4 = pattern4.matcher(htmL1);
        while (matcher4.find()) {
            System.out.printf("Найден тег <%s> - %s. Текст внутри: %s\n", matcher4.group("gr1"), matcher4.group(3), matcher4.group(2));
            System.out.println("group: " + matcher4.group());
        }



    }
}
