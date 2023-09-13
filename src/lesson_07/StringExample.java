package lesson_07;
/*
@date 13.09.2023
@author Sergey Bugaienko
*/

public class StringExample {
    public static void main(String[] args) {

        int x = 10;
        System.out.println(x);
        x = 12;

        String str1 = "Java"; // Ссылочный тип данных. В переменной str1 хранится ссылка на область памяти, в которой находится объект типа String
        String str2 = "Java";
        String str3 = "JaVA";
        String str4 = new String("Java");

        System.out.println(str1);
        System.out.println(str4);

        boolean b1 = str1 == str2;
        System.out.println("str1 == str2 -> " + b1);
        System.out.println("str1 == str3 -> " + (str1 == str3));
        System.out.println("str1 == str4 -> " + (str1 == str4));
        System.out.println("str1.equals(str4) -> " + str1.equals(str4));

        // ВАЖНО!!!
        // Сравнение строк по значению мы должны делать методом equals!!!

        System.out.println("str1.equals(str3) " + str1.equals(str3));
        System.out.println("str1.equalsIgnoreCase(str3) " + str1.equalsIgnoreCase(str3));
    }
}
