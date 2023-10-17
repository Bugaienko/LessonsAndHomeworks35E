package lesson_30.generics;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

import java.util.ArrayList;
import java.util.List;

public class GenericBoxApp {

    public static void main(String[] args) {

        GenericBox<String> stringBox = new GenericBox<>("Hello");
        GenericBox<String> stringBox2 = new GenericBox<>(", world");
        System.out.println(stringBox);
        System.out.println(stringBox.getValue() + stringBox2.getValue());



        // также ошибка на этапе компиляции
        //stringBox.setValue(100);

        // Ошибка на этапе компиляции. Проверка типа данных при создании объекта
//        GenericBox<String> stringGenericBox = new GenericBox<>(100);

        // Дженерики не поддерживают примитивные типы данных
        //GenericBox<int> intBox = new GenericBox<>();
        GenericBox<Integer> intBox = new GenericBox<>(150);
        GenericBox<Integer> intBox2 = new GenericBox<>(20);
        System.out.println(intBox.getValue() + intBox2.getValue());

        // гораничение снизу. Класс и все его родители.
        GenericBox<? super Integer> gBox = new GenericBox<>(150.5);
        System.out.println(gBox.toString());



    }
}
