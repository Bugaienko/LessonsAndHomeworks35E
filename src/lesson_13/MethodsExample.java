package lesson_13;
/*
@date 21.09.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;
import java.util.Random;

public class MethodsExample {
    public static void main(String[] args) {

        printNumbers(10);

        // написать метод, который выводит числа от Х до Y
        printNumbers(3, 10);

        sayHello();
        sayHello();
        sayHello();
        sayHello();

        String string = "Java";

        saySomething(string);

        char ch = 'A';


        char anotherChar = 'B';

        char anotherChar2 = 'C';


        printDecimalCodeOfChar(ch);
        printDecimalCodeOfChar(anotherChar);
        printDecimalCodeOfChar(anotherChar2);

        int[] array = {1, 45, 76, 54, 90, 435, 0, 45};
        int[] array2 = {581, 405, 768, -574, 987, 435, 13, 37};

        printArray(array);

        printArray(array2);


        array[3] = 1001;
        array[0] = -100000;

        printArray(array);

        for (int number : array2) {
            printIsNumberPrime(number);
        }

        // написать метод, который выводит на экран числа от 1 до N


        printNumbers(10, "Hello");
        printNumbers("Hello", 10);

        System.out.println();

        int[] newArray = new int[10];

        fillArrayWithRandomValues(newArray);
        printArray(newArray);

        int temp = 55;

        changeMe(temp);
        System.out.println(temp);

        changeMe(newArray);
        printArray(newArray);

        int[] third = newArray;
        third[2] = -100000;

        printArray(newArray);

        third = null;
        // third[0] = 10; Ошибка компиляции - NPE (нельзя взять 0-й индекс у "ничего"

        newArray[4] = -11111;

        String strTest = "Hello";
        System.out.println(strTest);


        // System.out.println("Hello");

    } // Methods area


    public static void changeMe(String str) {
        str = str + "!!!";
        System.out.println(str + " tt");
    }

    public static void changeMe(int x) {
        int temp;
        x = 100;
    }

    public static void changeMe(int[] arr) {
        arr[0] = 100;
    }

    public static void fillArrayWithRandomValues(int[] arr) {
        Random random = new Random();
        int bound = 101;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);
        }
    }

    public static void printNumbers(String str, int x) {
        System.out.println(str + ", Мне одиноко, поговори со мной!");
        System.out.println("Хотя бы " + x + " метод");
    }

    public static void printNumbers(int x, String str) {
        System.out.println(str + " УРА! " + x);
    }

    public static void printNumbers(int x, int y) {

        for (int i = x; i <= y; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printNumbers(int n) {

        printNumbers(1, n);

//        for (int i = 1; i <= n; i++) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

    }

    public static void printIsNumberPrime(int number) {
        boolean isSimple = true;

        if (number == 1 || number <= 0) isSimple = false;
        if (number % 2 == 0 && number != 2 || number % 3 == 0 && number != 3) {
            isSimple = false;
        }

        for (int j = 5; isSimple && j <= Math.sqrt(number); j = j + 6) { // (2 ... N-1)

            if (number % j == 0 || number % (j + 2) == 0) {
                isSimple = false;
                break;
            }
        }
        if (isSimple) {
            System.out.println(number + " - простое число");
        } else {
            System.out.println(number + " - НЕ является простым");

        }
    }


    public static void printArray(int[] array) {

        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ((i < array.length - 1) ? ", " : "]\n"));
        }

    }

    public static void printDecimalCodeOfChar(char ch1) {
        System.out.println((int) ch1);
    }

    public static void sayHello() {
        // тело метода
        System.out.println("Hello");
    }

    public static void saySomething(String str) {
        System.out.println(str);
    }


} // end class
