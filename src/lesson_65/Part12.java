package lesson_65;
/*
@date 13.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part12 {
    /*
        Pattern.CASE_INSENSITIVE - сопоставляет шаблон без учета регистра (i - в других языках)

        Pattern.MULTILINE (m)- в котором метасимволы ^ и $ соответствуют началу и концу каждой строки, а не  только началу и концу всего текста

        Pattern.DOTALL - точка соответствует любому символу (включая перевод строки)
     */

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE);
//        Pattern pattern = Pattern.compile("(?i)[a-z]+");
        Matcher matcher = pattern.matcher("Example");
        while (matcher.find()) System.out.println(matcher.group());

//        Pattern pattern1 = Pattern.compile("^example", Pattern.MULTILINE);
        Pattern pattern1 = Pattern.compile("(?im)^example");
        Matcher matcher1 = pattern1.matcher("Example is\nexample");
        while (matcher1.find()) System.out.println(matcher1.start() +  " : "  + matcher1.group());

        System.out.println("\n===============================\n");

        Pattern pattern2 = Pattern.compile("e.xample", Pattern.DOTALL);
        Matcher matcher2 = pattern2.matcher("e\nxample eUxample");
        while (matcher2.find()) System.out.println(matcher2.start() +  " : "  + matcher2.group());


    }
}
