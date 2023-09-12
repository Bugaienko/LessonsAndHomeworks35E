package homework_05;
/*
@date 12.09.2023
@author Sergey Bugaienko
*/

/*
Создайте строки:

"Java"
"is"
"a"
"powerful"
"language"

Из созданных строк склейте двумя разными способами строку: "Java is a powerful language"

Распечатать эту строку и ее длину

Заменить в результирующей строке слово "powerful" на "super"
Содержит ли строка подстроку "age"? Создайте переменную boolean типа c ответом
 */
public class Task_02 {

    public static void main(String[] args) {
        String str = "Java";
        String str1 = "is";
        String str2 = "a";
        String str3 = "powerful";
        String str4 = "language";

        //Первый вариант объединения строк
        String strConcat = str + " " + str1 + " " + str2 + " " + str3 + " " + str4;
        System.out.println(strConcat + " {строка имеет длину " + strConcat.length() + " символов}");

        //второй вариант объединения строк
        String strConcat2 = String.join(" ", str, str1, str2, str3, str4);
        System.out.println(strConcat2 + " {строка имеет длину " + strConcat.length() + " символов}");

        // замена подстроки в строке на другое значения
        String strReplace = strConcat.replace("powerful", "super");
        System.out.println(strReplace);

        System.out.println(strConcat.replace("powerful", "super"));

        // метод проверяет содердится ли подстрока в строке
        boolean answer = strConcat.contains("age");
        System.out.println(answer);
    }
}
