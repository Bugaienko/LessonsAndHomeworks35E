package lesson_63;
/*
@date 11.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    /*
    Квантификаторы - используются для указания количества раз, которое должен встречаться элемент (символ, группа символов или группа)

    * - звездочка. 0 или более раз {0,}
    + плюс - 1 или более раз {1,}
    ? - вопросительный знак. ноль или 1 {0,1}
    {n} - соответствует ровно n раз.
    {n,} - соответствует n раз и более
    {n, m} соответствует от n до m раз
     */

    public static void main(String[] args) {

//        Pattern pattern = Pattern.compile("a*"); // "", a, aa, aaa .. и  так далее
//        Pattern pattern = Pattern.compile("a+"); //  a, aa, aaa .. и  так далее
//        Pattern pattern = Pattern.compile("a?b"); //  "", a
//        Pattern pattern = Pattern.compile("a{3}"); //  aaa
        Pattern pattern = Pattern.compile("a{2,4}"); //  aa, aaa, aaaa -
        Matcher matcher = pattern.matcher("aaabcbaaaa"); //aa, aaa, aaaa
        while (matcher.find()) {
            System.out.println("*: " + matcher.start() + " : " + matcher.group());
        }

        Matcher matcher1 = Pattern.compile("\\d+").matcher("avdf12gfb345fdgfd6778u");
        while (matcher1.find()) System.out.println("\\d: " + matcher1.group());

        String string = "099 100 5268 9999 10000"; //3-x и 4-x значные числа
        //найти все числа от 100 до 9999 включительно
        Pattern pattern1 = Pattern.compile("\\b[1-9][0-9]{2,3}\\b");
//        Pattern pattern1 = Pattern.compile("\\b\\d{3,4}\\b");
        Matcher matcher2 = pattern1.matcher(string);
        while (matcher2.find()) System.out.println("100-9999: " + matcher2.group());

    }
}
