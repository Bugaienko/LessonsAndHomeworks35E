package lesson_62;
/*
@date 06.12.2023
@author Sergey Bugaienko
*/


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static void main(String[] args) {
 /*
 Наборы символов - обозначаются [] и используются для поиска любого символа из указанного набора
Диапазоны символов указываются через - (знак тире/минус). Например [a-z] - соответствует любой маленькой букве латинского алфавита
  */

        Pattern pattern = Pattern.compile("[ab]");
        Matcher matcher = pattern.matcher("acbehg");
        while (matcher.find()) {
            System.out.println("matcher: " + matcher.group());
        }

        // a-c -> a,b,c
        Matcher matcher1 = Pattern.compile("[a-c]").matcher("acegb");
        while (matcher1.find()) {
            System.out.println("matcher1: " + matcher1.group());
        }

        Matcher matcher2 = Pattern.compile("[0-5]").matcher("1745");
        while (matcher2.find()) System.out.println("matcher2: " + matcher2.group());

        // "012345abcde...z"
        Matcher matcher3 = Pattern.compile("[0-5.\\-a-z]")
                .matcher("174dA.");
        while (matcher3.find()) System.out.println("matcher3: " + matcher3.group());

        /*
         - дефис / минус. Вне диапазона он рассматривается как обычный символ
         \ - обратная косая (обратный слеш) - используется для экранирования и для обозначения других спец.символов
         ^ - каретка
            Когда она находится в самом начале квадратных скобок - она означает "отрицание" ВСЕГО набора
            Если находится НЕ в начале - она теряет свое специальное значение и рассматривается как обычный символ
         */

        Matcher matcher4 = Pattern.compile("[^a^bc]").matcher("acdeA^BC123-%");
        while (matcher4.find()) {
            System.out.println("matcher4: " + matcher4.group());
        }

















//        char a = 'A';
//        char b = 'Z';
//        char a1 = 'a';
//        char b1 = 'z';
//
//        System.out.println((int) a + " : " +  (int) b + " : " + (int) a1 + " : " + (int) b1);
//
//        for (int i = 91; i < 97; i++) {
//            System.out.println((char) i);
//        }
    }
}
