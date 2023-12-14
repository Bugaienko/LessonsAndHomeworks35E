package lesson_66.regex;
/*
@date 14.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskFinal {
    public static void main(String[] args) {
        System.out.println("\u00E9");
        System.out.println("\u0065\u0301");

        Pattern pattern = Pattern.compile("é", Pattern.CANON_EQ); //u00E9
        Matcher matcher = pattern.matcher("e\u0301");
        System.out.println(matcher.matches());

        Pattern pattern1 = Pattern.compile("\\b# граница слова\n(\\d+)# одна или более цифр\n\\b", Pattern.COMMENTS);
//        Pattern pattern2 = Pattern.compile("\\b(\\d+)\\b");
        Matcher matcher1 = pattern1.matcher("1234 121");
        while (matcher1.find()) System.out.println(matcher1.group());

        //Java 17 code
//        String regEx = """
//                \\b# граница слова
//                (\\d+)# одна или более цифр
//                \\b
//                """;

//        Matcher matcher2 = Pattern.compile(regEx, Pattern.COMMENTS).matcher("1234 123");
//        while (matcher2.find()) System.out.println(matcher2.group());
        //Java 17


    }
}
