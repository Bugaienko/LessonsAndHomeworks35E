package lesson_06;
/*
@date 12.09.2023
@author Sergey Bugaienko
*/

public class BooleanExample {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;

        boolean bol1 = true;
        bol1 = false;

        bol1 = (x == y); // X равен Y -> true / false; (10 равно 5) -> false
        System.out.println(x + " == " + y + " -> " + bol1);

        boolean b1 = x != y; // X не равно Y / (10 не равно 5) -> true
        System.out.println(x + " != " + y + " -> " + b1);

        y = 10;

        boolean b2 = x > y; // X больше Y / (10 больше 10) -> false
        System.out.println(x + " > " + y + " -> " + b2);

        boolean b3 = x < y; // X меньше Y / (10 меньше 10) -> false
        System.out.println(x + " < " + y + " -> " + b3);


        boolean b4 = x >= y; // X больше или равно Y / (10 больше-равно 10) -> true
        System.out.println(x + " >= " + y + " -> " + b4);

        y = 7;

        boolean b5 = x <= y; // X больше или равно Y / (10 меньше-равно 7) -> false
        System.out.println(x + " <= " + y + " -> " + b5);

        System.out.println("\n============================\n");


        // Логическое НЕ - меняет значение boolean на противоположное
        boolean b6 = !(4 == 5);
        System.out.println("!(4==5) : " + b6);

        boolean t1 = true;
//        t1 = !t1;
        t1 = !true; // получим значение false
        System.out.println("t1 " + t1);

        //Логическое И -

        // Рим столица Италии И Берлин столица Германии
        boolean b7 = true & true;
        System.out.println("true & true И b7 " + b7);

        b7 = (2 < 5) & (11 == 10);
        //b7 = true & false
        // Рим столица Италии И Берлин столица Голландии
        System.out.println("true & false И b7 " + b7);

        // Логическое ИЛИ
        boolean b8 = true | false;
        System.out.println("true | false " + b8);
        System.out.println("true | true " + (true | true)); // true ИЛИ true

        b8 = (3 < 1) | (43 > 55); // false | false
        System.out.println("(3 < 1) | (43 > 55) " + b8);

        // Логическое исключающее ИЛИ (XOR)  возвращает true, если две части выражения разные
        boolean b9 = true ^ false;
        System.out.println("true ^ false " + b9);
        b9 = false ^ true;
        System.out.println("false ^ true " + b9);
        b9 = true ^ true;
        System.out.println("true ^ true " + b9);
        b9 = false ^ false;
        System.out.println("false ^ false " + b9);

        System.out.println(" ====================");


        // Логическое сокращенное И
        boolean b10 = true && false;
        System.out.println("true && false " + b10);
        b10 = true && true;
        System.out.println("true && true " + b10);

        int a = 0;
        int b = 10;
//        int c;
//        c = b / a; при a равном 0 - получаем ошибку. Программа останавливается

        //             2 - true &&
        //             0 - false &&
        boolean b11 = (a != 0) && (b / a > 4);
        System.out.println(b11);

//        Логическое сокращенное ИЛИ
        boolean b12 = true || (b / a < 4);
        System.out.println(b12);

        System.out.println("======================\n");

        /*
        !
        &
        ^
        |
        &&
        ||
         */

//        System.out.println(false & false);
        System.out.println(true ^ true & false); //true XOR true & false
        System.out.println(true ^ false); //
        System.out.println(true); //
        System.out.println("+++++++++++++");

        System.out.println(true ^ true && false); //true XOR true && false
        System.out.println(false && false); //
        System.out.println(false); //

        /*
        ! -> & -> ^ -> | -> && -> ||
        */

        System.out.println("+++++++++++++++++++++++++");
        boolean aa = true;
        boolean bb = false;
        int cc = 25;
        int qq = 2;
        System.out.println(aa | bb | cc < 100 & !aa ^ qq == 5);
        System.out.println(true | false | (25 < 100) & !true ^ (25 == 5));
        System.out.println(true | false | (true) & false ^ (false));
        System.out.println(true | false | false ^ (false));
        System.out.println(true | false | false);
        System.out.println(true | false);
        System.out.println(true);

        System.out.println("++++++++++++++++++");

        /*
        ! -> & -> ^ -> | -> && -> ||
        */

        System.out.println(true || false ^ true & !true);
        System.out.println(true || false ^ true & false);
        System.out.println(true || false ^ false);
        System.out.println(true || false);
        System.out.println(true);

        System.out.println("==================");

        // Скобки меняют приоритет логических операций. То что в скобках - имеет более высокий приоритет выполнения
        System.out.println(true ^ false & false);
        System.out.println(true ^ false);
        System.out.println(true);

        System.out.println((true ^ false) & false);
        System.out.println(true & false);
        System.out.println(false);


    }
}
