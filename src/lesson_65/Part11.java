package lesson_65;
/*
@date 13.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part11 {
    public static void main(String[] args) {
        /*
        Look Around -> lookahead lookbehind
        lookahead - (предварительная проверка) - смотреть вперед - Следует ли за точкой другой шаблон
        Положительный lookahead - X(?=Y) - соответствует X только если за Х есть Y
        Отрицательный lookahead - X(?!Y) - соответствует X только если за Х НЕ следует Y

        Lookbehind - (предшествующая проверка) - проверяет есть ли перед точкой другой шаблон
          Положительный Lookbehind - (?<=Y)X - соответствует Х, только если перед Х ЕСТЬ У
           Отрицательный Lookbehind - (?<!Y)X - соответствует Х, только если перед Х НЕТ У

         Lookbehind - ДОЛЖЕН иметь фиксированную длину. Мы не можем использовать квантификатору переменной длинны *, +
         */

        String johns = "John Smith John First Garry Smith";
        // Хочу найти имя John, если за ним есть " Smith";
        Pattern positiveLookAhead = Pattern.compile("John(?= Smith)");

        Matcher matcher = positiveLookAhead.matcher(johns);
        while (matcher.find()) System.out.println("positive LA: " + matcher.group() + "; start: " + matcher.start());

        // Хочу найти имя John, если за ним нет " Smith";
        Pattern negativeLookAhead = Pattern.compile("John(?! Smith)");
        Matcher matcher1 = negativeLookAhead.matcher(johns);
        while (matcher1.find()) System.out.println("negative LA: " + matcher1.group() + "; start: " + matcher1.start());

        System.out.println("\n================================\n");


        String string = "f1 r2 ff G7 kk rty1 4a";
        //Мне нужно найти все буквы, сразу за которыми следует цифра
        // f r G y

//        Pattern pattern = Pattern.compile("\\p{LC}(?=\\d)");
        //Все буквы, после которых стоит цифры
        Pattern pattern = Pattern.compile("[a-zA-Z](?=\\d)");

        Matcher matcher2 = pattern.matcher(string);
        while (matcher2.find()) System.out.println("буква, после которой стоит цифра" + matcher2.group());

        //Все цифры, перед которыми есть буква
        Pattern pattern2 = Pattern.compile("(?<=[a-zA-Z])\\d");
        Matcher matcher4 = pattern2.matcher(string);
        while (matcher4.find()) System.out.println("цифра, перед которой есть буква: " + matcher4.group());

        //Все цифры, перед которыми нет буквы

        Pattern pattern3 = Pattern.compile("(?<![a-zA-Z])\\d");
        Matcher matcher6 = pattern3.matcher(string);
        while (matcher6.find()) System.out.println("цифра, перед которой нет буквы: " + matcher6.group());

        System.out.println("\n================================\n");

        // // Хочу найти фамилию Smith, только если перед ней есть имя "John ";
        Pattern positiveLB = Pattern.compile("(?<=John )Smith");
        Matcher matcher3 = positiveLB.matcher(johns);
        while (matcher3.find()) System.out.println("(?<=John )Smith positive LB: " + matcher3.group() + "; start: " + matcher3.start());


        Pattern negativeLB = Pattern.compile("(?<!John )Smith");
        Matcher matcher5 = negativeLB.matcher(johns);
        while (matcher5.find()) System.out.println("(?<!John )Smith negativeLB: " +  matcher5.group() + "; start: " + matcher5.start());

        System.out.println("\n===================================\n");

        String text = "cannot cannote tunote notrer not knot notnot notfg trerte cataaaa";
        // Найти все слова, в которых есть "not"
        // Найти все слова, в которых есть "not" длинной 6 символов

        Pattern pattern1 = Pattern.compile("(?=\\w{6})(\\b\\w*not\\w*\\b)");
        Matcher matcher7 = pattern1.matcher(text);
        while (matcher7.find()) System.out.println("not find: " + matcher7.group());

        System.out.println("\n================================\n");

        //Найти все слова, длинной от 6 до 12 символов, в которых есть "cat" или "dog" или "mouse"
        String stringCatDog = "catrer catrerdd catg ddogass gtmouse hhhhhhhhhmouse ffffffcatddd  cadotyrr";
        Pattern pattern4 = Pattern.compile("(?=\\w{6,12}\\b)(\\b\\w*(cat|dog|mouse)\\w*\\b)");
        Matcher matcher8 = pattern4.matcher(stringCatDog);
        while (matcher8.find()) System.out.println("my: " + matcher8.group());

        System.out.println("\n=================================\n");

        Pattern pattern5 = Pattern.compile("\\b(?=\\w{6,12}\\b)\\w*(cat|dog|mouse)\\w*");
        Matcher matcher9 = pattern5.matcher(stringCatDog);
        while (matcher9.find()) System.out.println(matcher9.group());


        System.out.println("\n=================================\n");

        String string1 = "нехорошо неток нротс не нлоллу пннене";
        //Все слова, которые не начинаются на "не"

        Pattern pattern7 = Pattern.compile("\\b(?!не)\\p{IsCyrillic}+");
        Matcher matcher10 = pattern7.matcher(string1);
        while (matcher10.find()) System.out.println(matcher10.group());


    }
}
