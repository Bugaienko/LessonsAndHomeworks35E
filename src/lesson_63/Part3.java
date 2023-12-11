package lesson_63;
/*
@date 11.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static void main(String[] args) {
        /*
        Символы, которые в наборах являются спец.символами.
        - дефис / минус. Вне диапазона он рассматривается как обычный символ
         \ - обратная косая (обратный слеш) - используется для экранирования и для обозначения других спец.символов
         ^ - каретка
         []
         */

        Pattern pattern1 = Pattern.compile("q[^u]"); // q[u^] -> qu; q^
        Matcher matcher1 = pattern1.matcher("quality is qa q^ q1 qQ q  q-");
        while (matcher1.find()) System.out.println("matcher1: " + matcher1.group());

//        Pattern pattern = Pattern.compile("q[\\[\\]\\-]"); //q[ q- q]
        Pattern pattern = Pattern.compile("q[\\Q][-\\E]"); //q[ q- q]
        Matcher matcher = pattern.matcher("quality q] q- q[ qa");
        while (matcher.find()) System.out.println("matcher: " + matcher.group());


        // Объединение - Любой символ или из 1-го диапазона или из второго
        Pattern pattern2 = Pattern.compile("[a-d[m-p]]"); // объединение диапазонов
        // abcdmop
        Pattern pattern3 = Pattern.compile("[a-dm-p]");

        Pattern pattern99 = Pattern.compile("[a-d][m-p]"); // комбинацию из 2х символов. 1-й символ должен a-b-c-d, а второй m-o-p
        Matcher matcher99 = pattern99.matcher("am ab dp go dz");
        while (matcher99.find()) System.out.println("matcher99: " + matcher99.group());
        Matcher matcher98 = pattern2.matcher("am ab dp go dz");
        while (matcher98.find()) System.out.println("matcher98: " + matcher98.group());


        // Пересечение - для обозначения используется &&. Символ должен принадлежать обоим диапазонам. Быть и в 1, и во 2-м

        Pattern pattern4 = Pattern.compile("[a-e&&[d-f]]"); //de
        Matcher matcher4 = pattern4.matcher("adr0e1fz");
        while (matcher4.find()) System.out.println("matcher4: " +matcher4.group());


        //Исключение. Соответствует всем символам одного диапазона, исключая символы второго диапазона

        Pattern pattern5 = Pattern.compile("[a-z&&[^bc]]");
        Matcher matcher5 = pattern5.matcher("azb0-c% jABF");
        while (matcher5.find()) System.out.println("matcher5: " + matcher5.group());

    }
}
