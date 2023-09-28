package lesson_18;
/*
@date 28.09.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;
import java.util.Random;

public class Main18 {
    public static void main(String[] args) {
        Random random = new Random();

        RubberArray ra = new RubberArray();

        System.out.println("Сейчас в массиве: " + ra.length() + " элементов");

        ra.add(50);
        ra.add(-10);

        for (int i = 0; i < 5; i++) {
            ra.add(random.nextInt(101) - 50);
        }

        System.out.println(ra.toString());
        System.out.println("Сейчас в массиве: " + ra.length() + " элементов");

        ra.add(1, 3, 4);
        System.out.println(ra.toString());
        System.out.println("Сейчас в массиве: " + ra.length() + " элементов");

        int searchMe = 3;
        System.out.println("Поиск в массиве по значению: " + ra.indexOf(searchMe));

        System.out.println("Метод contains: " + ra.contains(searchMe));


        ra.addRandomValues(3, 1000);
        ra.add(3);
        ra.addRandomValues(2);
        System.out.println(ra.toString());
        System.out.println("=================");

        int index = ra.indexOf(50);
        int lastIndex = ra.lastIndexOf(50);

        System.out.println(index);
        System.out.println(lastIndex);

        if (index != -1 && index != lastIndex) {
            System.out.println("Число вхождений тройки в массиве больше 1");
        }

        if (index != -1 && index == lastIndex) {
            System.out.println("В массиве только один элемент с таким значением");
        }


        System.out.println("=======================");

        System.out.println("Удаляем по индексу 8: " + ra.removeByIndex(8));
        System.out.println(ra.toString());
        ra.add(11);
        System.out.println(ra.toString());

        System.out.println(ra.remove(1005));
        System.out.println(ra.toString());

        int[] array = ra.toArray();
        System.out.println(Arrays.toString(array));

        ra.trim();
        ra.add(555);
        System.out.println(ra.toString());




    }


}
