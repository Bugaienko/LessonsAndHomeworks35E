package lesson_47.homework46;
/*
@date 09.11.2023
@author Sergey Bugaienko
*/

import java.util.*;

/*
Написать метод, возвращающий первый неповторяющийся символ в строке

public static void main(String[] args) {
        String string = "abcdefj ab,cdf,";
        System.out.println(StrUtil.getFirstUniqueChar(string));
    }

    //Output:
    e
 */
public class Task3 {
    public static void main(String[] args) {
        String string = "abcdefj ab,cd,f";
        System.out.println(getFirstUniqueChar(string));
        System.out.println(getFirstUniqueChar2(string));
    }

    private static Character getFirstUniqueChar(String string) {
        Set<Character> uniqueChars = new LinkedHashSet<>();
        Set<Character> repeatedChars = new HashSet<>();

//        for (int i = 0; i < string.length(); i++) {
//            char ch = string.charAt(i);
//        }

//        while (iterator.hasNext()) {
//            Character ch = iterator.next();
//        }


        // перебираем в цикле все символы в строке
        for (char ch : string.toCharArray()){ // for-each

            // проверяем, присутствует ли текущий символ в сете повторяющихся символов
            if (repeatedChars.contains(ch)){
                continue; // если да, переходим к следующему символу в цикле
            }

            // проверяем, присутствует ли текущий символ в сете уникальных символов
            if (uniqueChars.contains(ch)){
                uniqueChars.remove(ch); // если да, убираем символ из "уникальных"
                repeatedChars.add(ch); // добавляем в повторяющиеся
            } else {
                uniqueChars.add(ch);
            }
        }
//        uniqueChars.get(0) // Set-ы не поддерживают взятие элемента по индексу

        Iterator<Character> iterator = uniqueChars.iterator();
       while (iterator.hasNext()) {
           Character ch = iterator.next();
       }

        System.out.println("repeatedChars: " + repeatedChars);
        System.out.println("uniqueChars: " + uniqueChars);

        return uniqueChars.isEmpty() ? null : uniqueChars.iterator().next();
    }

    private static Character getFirstUniqueChar2(String string) {
        Set<Character> uniqueChars = new LinkedHashSet<>();

        for (char ch : string.toCharArray()){
            if (!uniqueChars.add(ch)) {
                uniqueChars.remove(ch);
            }
        }

        System.out.println(uniqueChars);


       return uniqueChars.isEmpty() ? null : uniqueChars.iterator().next();
       //  return new ArrayList<>(uniqueChars).get(1); достучаться до элемента по индексу, преобразовав set в list
    }
}
