package lesson_30.generics;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

public class GenericBoxApp {

    public static void main(String[] args) {

        GenericBox<String> stringBox = new GenericBox<>("Hello");
        System.out.println(stringBox);

        // также ошибка на этапе компиляции
        //stringBox.setValue(100);

        // Ошибка на этапе компиляции. Проверка типа данных при создании объекта
        //GenericBox<String> stringGenericBox = new GenericBox<>(100);

        // Дженерики не поддерживают примитивные типы данных
        //GenericBox<int> intBox = new GenericBox<>();

    }
}
