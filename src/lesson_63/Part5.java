package lesson_63;
/*
@date 11.12.2023
@author Sergey Bugaienko
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {
    /*
    Границы в регулярных выражениях
    \b - Граница слова.  Соответствует позиции между словесным и несловесным символом (между \w и \W)
    \B - отрицание. НЕ граница слова

    ^ - соответствует началу строки.
    $ - соответствует концу строки

    \A и \Z являются практически аналогами ^ и $.
    \A - всегда соответствует началу ВСЕГО текста
    \Z - всегда соответствует концу ВСЕГО текста

     */
    public static void main(String[] args) {

        // Найти слово cat, стоящее в тексте как отдельное слово

        String text = "cat cats cat. cat\n adcat cat_ cat1";
//        Pattern pattern = Pattern.compile("\\bcat\\b");
        Pattern pattern = Pattern.compile("\\Bcat\\b");
//        Pattern pattern = Pattern.compile("\\bcat");
//        Pattern pattern = Pattern.compile("cat\\b");

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("\\b start:" + matcher.start() + " : " + matcher.group());
        }


//        String text2 = "слово слово\n слово";
        String text2 = "слово"; // соответствует
//        String text2 = "слоFо"; // тоже соответствует
//        String text2 = "слоF4"; // тоже соответствует
//        String text2 = "слов4"; // тоже соответствует
//        Pattern pattern1 = Pattern.compile("^слово");
//        Pattern pattern1 = Pattern.compile("слово$");
        Pattern pattern1 = Pattern.compile("^сло[вF][о4]$");
        Matcher matcher1 = pattern1.matcher(text2);
        while (matcher1.find()) {
            System.out.println("^|$ start:" + matcher1.start() + " : " + matcher1.group());
        }

        System.out.println("\n==============================\n");

        String text3 = "cat cats cat. cat\ncas adcat cat_ cat";
        Pattern pattern2 = Pattern.compile("ca[ts]\\Z", Pattern.MULTILINE);
        Matcher matcher2 = pattern2.matcher(text3);
        while (matcher2.find()) {
            System.out.println("Multi start:" + matcher2.start() + " : " + matcher2.group());
        }
    }
}
