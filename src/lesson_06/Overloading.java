package lesson_06;
/*
@date 12.09.2023
@author Sergey Bugaienko
*/

public class Overloading {
    public static void main(String[] args) {

        byte byteVar = 127;
        System.out.println(byteVar);
        byteVar++;
        System.out.println(byteVar);

        // При переполнении типа данных значения "идут по кругу".
        // Если к максимальному значению типа прибавить 1 - мы получим минимальное значение типа

        int intVar = Integer.MAX_VALUE;
        System.out.println(++intVar);

        char ch = 65535;
        char ch1 = 0;
        System.out.println(++ch);
        System.out.println(ch1);

    }
}
