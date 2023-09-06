package lesson_02;

public class CamelCase {

    public static void main(String[] args) {

//        Однострочный комментарий
//        Ctrl + / - закомментировать / раскомментировать строку
//        Ctrl + Y - удаление строки

        /*
        Многострочный комментарий
         */

        int myFirstVariable; // объявление (декларация) переменной типа int

//        int myFirstVariable2;
//        какие-то строки кода

        myFirstVariable = 1; // присвоение значение (инициализация) переменной

        int mySecondVariable = 25; // объявление и инициализация

        System.out.println("Value of int variable " + mySecondVariable);

        mySecondVariable = 999;

        System.out.println(mySecondVariable);

        byte byteVariable = 126;
        System.out.println(byteVariable);

        short shortVar = 32700;
        System.out.println(shortVar);

        long longVariable = 2_100_000_000_000_000_000L;
        System.out.println("Число типа long " + longVariable);

        double double2; // инициализация переменной типа double
        double2 = 10; // автоматическая конвертация в тип int

        System.out.println("Переменная типа double " + double2);

        double2 = 5.5423;
        System.out.println(double2);

        double doubleVar;


    }


}
