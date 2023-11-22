package lesson_54.streamsMethods;
/*
@date 22.11.2023
@author Sergey Bugaienko
*/


import java.util.List;
import java.util.stream.Collectors;

public class DataFilters {
    public static void main(String[] args) {

        // Фильтрации данных

//        Промежуточные методы (возвращают поток)
        /*
        filter(Predicate<? super T> predicate) - возвращает поток, содержащий только те элементы для которых предикат вернул true
        distinct() - удаляет дублирующиеся элементы. Возвращает поток с уникальными элементами. Для определения равенства использует метод equals()

        limit(long maxSize) - ограничивает количество элементов потока заданным значением
        skip(long n) - Пропускает первые n элементов потока

        takeWhile(Predicate<T> predicate) - возвращает новый поток, который содержит элементы исходного потока до тех пор, пока предикат возвращает true.
        Как только предикат возвращает false, прекращается копирование элементов, все последующие элементы игнорируются
        dropWhile(Predicate<T> predicate) - он пропускает элементы исходного потока, пока предикат возвращает true и
        возвращает поток из всех элементов исходного потока, начиная с элемента, для которого предикат вернул false

         */

        // получить список с уникальными элементами (отбросить дубликаты)
        //task();

        //получить три самых маленьких числа из списка целых чисел
        //получить список чисел из списка целых чисел отбросив три самых маленьких
        //task1();

        //takeWhile, dropWhile
        task2();


    } //main

    private static void task2() {
        List<String> strings = List.of("aa", "bb", "ccc", "dd", "eee");

//        takeWhile
        List<String> strings1 = strings.stream()
                .takeWhile(string -> string.length() < 3)
                .collect(Collectors.toList());

        System.out.println("strings1: " + strings1);

//        dropWhile

        List<String> dropStrings = strings.stream()
                .dropWhile(s -> s.length() < 3)
                .collect(Collectors.toList());

        System.out.println("dropStrings: " + dropStrings);
    }

    private static void task1() {
        List<Integer> integers = List.of(0, 5, 1, 2, 4, 3, 3, 4, 6, 0, 4);
//        integers = List.of(0, 5);

        //получить три самых маленьких числа из списка целых чисел
        List<Integer> smallest = integers.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("smallest: " + smallest);

//        integers = List.of(0, 5, 1);
        //получить список чисел из списка целых чисел отбросив три самых маленьких
        List<Integer> withoutSmallest = integers.stream()
                .sorted()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("withoutSmallest: " + withoutSmallest);

        System.out.println(integers.stream().skip(4).collect(Collectors.toList()));

    }

    private static void task() {
        // получить список с уникальными элементами (отбросить дубликаты)

        List<Integer> integers = List.of(0, 5, 1, 2, 4, 3, 3, 4, 6, 0, 4);

        integers.stream()
                .distinct()
                .forEach(i -> System.out.print(i + "; "));
        System.out.println();

        List<Cat> cats = List.of(
                new Cat("Bear", 5, "braun"),
                new Cat("Bear", 5, "braun"),
                new Cat("Tiger", 3, "gray"),
                new Cat("Panda", 4, "black")
        );

        List<Cat> cats1 = cats.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(cats1);

        List<String> strings = List.of("abc", new String("abc"), "defg", "defg");

        System.out.println(strings.stream().distinct().collect(Collectors.toList()));

    }

    private static List<Cat> getListCats() {
        return List.of(
                new Cat("Bear", 5, "braun"),
                new Cat("Python", 7, "white"),
                new Cat("Tiger", 3, "gray"),
                new Cat("Panda", 4, "black")
        );
    }
}
