package lesson_55.streamsExample;
/*
@date 23.11.2023
@author Sergey Bugaienko
*/

import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {

        // Аккумулирующие терминальные методы
        /*
        Optional<T> reduce(BinaryOperator<T> accumulator) - выполняет свертку элементов, возвращая одно суммированное значение
        T reduce(T seed, BinaryOperator<T> accumulator) - выполняет свертку элементов, но имеет заданное начальное значение

        BinaryOperator<T> -> BiFunction<T, T, T> - где два объекта одного типа объединяются (обрабатываются) и возвращается один объект того же типа
         */

        // reduce1();
        //reduce2();
        reduce3();

    } //

    private static void reduce3() {

        List<String> strings = List.of("world", "!");

        String concat = strings.stream().reduce("Hello", (s1, s2) -> s1 + " " + s2);
        System.out.println(concat);
    }

    private static void reduce2() {
        List<String> strings = List.of("Java", "Python", "JS", "Kotlin");
        Optional<String> longest = strings.stream()
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);

        System.out.println("longest: " + longest.get());
    }

    private static void reduce1() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Optional<Integer> sum = integers.stream()
                .filter(i -> i % 2 == 0)
                .reduce((i1, i2) -> i1 + i2);
        System.out.println(sum.get());
    }
}
