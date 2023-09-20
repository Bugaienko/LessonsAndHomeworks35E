package lesson_12;
/*
@date 20.09.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;
import java.util.Random;

public class LoopForExample {
    public static void main(String[] args) {

        /*
        for (<Блок инициализации> ; <Блок проверки>; <Блок изменений>) {
         // тело цикла
        }
         */

        // вывести числа от 0 до 10

        int j = 0;
        while (j <= 10) {
            System.out.print(j + " ");
            j++;
        }
        System.out.println("\n end while loop " + j);

        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n end for loop");

//        for (;;) {
//
//        }  Запустится бесконечный цикл. Для цикла фор ни один из блоков не является обязательным

        /*
        int i;
        for (i = 0 ; i >= 0 ; i = i + 1500000 ){
            System.out.println("hello " + i);
        }
        System.out.println(i); // Если нужен доступ к значению счетчика цикла после завершения цикла
        */


        // в блоке инициализации может быть переменная любого типа
        for (String str = "Hello"; str.length() < 10; str += "$") {
            System.out.println(str);
        }


        // мы можем инициализировать несколько переменных
        // в блоке изменений мы также можем изменять несколько переменых
        int k = 0;
        // какие-то строки кода
        k = 14;
        for (int a = 0, f = 1; k >= 0 && f < 10; k--, a = ++a + k, f++) {
            System.out.println(k + " : " + a + " : " + f);
        }
        System.out.println();


        // Создать массив целых чисел случайной длинны в диапазоне от 5 до 15.
        // Заполнить массив случайными числами от -50 до 50;

        // random.nextInt(11) -> (0 .. 10) + 5 -> (5..15)

        Random random = new Random();
        int[] ints = new int[random.nextInt(11) + 5]; // получим длину от 5 до 15 вкл
        System.out.println("длина массива: " + ints.length);

        System.out.print("[");
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(101) - 50;  // (0..100) - 50 -> (-50..50)
            System.out.print(ints[i] + ((i < ints.length - 1) ? ", " : "]\n"));
        }

        // Найти элемент в массиве по его значению.
        // Допустим нужно найти число 5;
        // Если число найдено - сохраняем в переменную его индекс. Если не найдено, сохраняем -1;
        // Найден индекс первого вхождения (первого элемента удовлетворяющего критериям поиска)
        // Найден индекс последнего вхождения

        int numberForSearch = 5;

        ints = new int[]{10, 11, 5, 6, 5, 7, 8, 5, 100};

        System.out.println(Arrays.toString(ints));
        int index = -1;
        for (int i = 0; i < ints.length; i++) {

            if (ints[i] == numberForSearch) {
                index = i;
                break; // при наличии break мы запоминаем индекс первого вхождения
                // без break - получим индекс последнего элемента, удовлетворяющего условию поиска
            }

        }

        // continue, break;

        System.out.println("В переменной индекс сейчас значение: " + index);

        for (int i = 1; i < 7; i++) {
            if (i == 3) continue; // continue - переход к следующей итерации цикла.
            // Мы перейдем в блок изменения переменных, потом в блок условия
            // в текущее итерации после continue все операторы в теле цикла будут пропущены
            System.out.print(i + " ");
        }
        System.out.println("\nend loop with continue ");

        for (int i = 1; i < 7; i++) {
            if (i == 3)
                break; // break заканчивает текущую итерацию цикла и весь цикл (все последующий итерации выполнены не будут)
            System.out.print(i + " ");
        }

        System.out.println("\nend loop with break");

        int y = 1;
        while (y < 7) {
            if (y == 3) {
                y++;
                continue;
            }
            System.out.print(y++ + " ");
        }
        System.out.println("\nend while loop with ");

        //  ints = new int[] {10, 11, 5, 6, 5, 7, 8, 5, 100};

        // цикл for-each
        for (int number : ints) { // тип массива - имя переменной, в которой будет храниться текущее значение : переменная со ссылкой массив
            System.out.print(number + " ");
        }
        System.out.println();

        String[] strings = {"Aaaa", "Bbbb", " Ccccc", "DDDD", "eeeee"};



        for (String str : strings) {
            System.out.println(str);
        }

        // по сути происходит одно и тоже.

        String str = "";
        for (int i = 0; i < strings.length; i++) {
//            str = strings[i];
//            System.out.println(str);
            System.out.println(strings[i]);
        }

        //  посчитать сумму элементов массива ints
        System.out.println(Arrays.toString(ints));

        int sum = 0;
        for (int currentValue : ints) {
            // int currentValue = ints[i]; // i - он сам перебирает.
            sum += currentValue;
            // currentValue = 155; // никак не влияет на элементы в массиве
            System.out.print(currentValue + " ");
        }
        System.out.println("\nсумма: " + sum);
        System.out.println(Arrays.toString(ints));


        int counter = 0;
        int isx = 0;
        for (String str1 : strings) {
            if (str1.length() > 4) {
                System.out.println(str1);
                counter++;
                strings[isx] = "Hello!!!";
            }
            isx++;
        }
        System.out.println("Нашел " + counter + " строк");
        System.out.println(Arrays.toString(strings));


        // Распечатать 5 раз числа от 2 до 7 вкл.

        for (int i = 0; i < 5; i++) {

            for (int l = 2; l <=7 ; l++) {
                System.out.print(l + " ");
            }

            System.out.println();

        }



    } // main


}
