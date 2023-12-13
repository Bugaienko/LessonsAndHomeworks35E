package lesson_65;
/*
@date 13.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part10 {
    public static void main(String[] args) {
        // \p{xxx} - позволяет указывать на определенные категории символов, согласно классификации Юникод
        /*
        \p{Digit} - любой десятичной цифре [0-9] = \d
        \p{Lower} - Соответствует любому символу в нижнем регистре [a-z]
        \p{Ll} - буквы алфавитов из Юникод в нижнем регистре

        \p{Upper} -  Соответствует любому символу в верхнем регистре [A-Z]
        \p{Lu} - буквы алфавитов из Юникод в Верхнем регистре
        p{LC} = \p{Lu+Ll}

        \p{Alpha} - соответствует любому алфавитному символу. // \w -> a-zA-Z0-9_
        \p{Alnum} - соответствует буквенно-символьному символу // a-zA-Z0-9

        \p{Punct} - соответствует любому пунктуационному символу !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~

       \p{Space} \p{Whitespace} - соответствует любому пробельному символу \s
       \p{Blank} - пробел или табуляция

       \p{XDigit} - любому шестнадцатеричному символу [0-9a-fA-F]

       \p{IsCyrillic} - соответствует любому символу кириллического алфавита [а-яА-Я]

       POSIX - [:[digit]]


         */

        Pattern pattern3 = Pattern.compile("(\\p{Digit}{2})-(\\p{Digit}{2})-(\\d{4})");
        Matcher matcher3 = pattern3.matcher("Дата: 15-03-2023");
        String newText = matcher3.replaceAll("$2/$1/$3");
        System.out.println(newText);


        Matcher matcher = Pattern.compile("\\p{Ll}+").matcher("Пример Text Beispiel");
        while (matcher.find()) System.out.println(matcher.group());

        Matcher matcher1 = Pattern.compile("\\p{Punct}").matcher("!@#$$%^&*()~<>{}_|");
//        while (matcher1.find()) System.out.println("Punct: " + matcher1.group() );





    }
}
