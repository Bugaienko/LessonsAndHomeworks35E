package lesson_55.streamsExample;
/*
@date 23.11.2023
@author Sergey Bugaienko
*/

import java.util.List;
import java.util.Optional;

public class TerminalsMethods {
    public static void main(String[] args) {
        // Терминальные методы

        // Методы, которые возвращают одно значение

        /*
         boolean allMatch(Predicate predicate) - возвращает true, если все элементы потока соответствуют заданному предикату
         boolean anyMatch(Predicate predicate) - возвращает true, если хотя бы один элемент потока соответствуют заданному предикату
         boolean noneMatch(Predicate predicate) - возвращает true, если НИ  один элемент потока НЕ соответствуют заданному предикату

        Optional<T> findFirst() - возвращает первый элемент потока
        Optional<T> findAny() - возвращает любой элемент потока. Как правило используется в параллельных потоках.

        long count() - Возвращает количество элементов в потоке

        Optional<T> min(Comparator comparator) = возвращает минимальный элемент потока в соответствии с компаратором
        Optional<T> max(Comparator comparator) = возвращает максимальный элемент потока в соответствии с компаратором
         */

        // *Match
        //example1();

        //findFirst, findAny
        //example2();

        //count
        example3();


    } // main

    private static void example3() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        long count =integers.stream()
                .filter( integer -> integer % 2 == 0)
                .count();

        System.out.println("count: " + count);
    }

    private static void example2() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        Optional<Integer> findFirst = integers.stream().filter(i -> i > 3).findFirst();
        System.out.println("findFirst: " + findFirst.get());

        Optional<Integer> findAny = integers.stream().findAny();
        System.out.println("findAny: " + findAny.get());
    }

    private static void example1() {
        List<Integer> integers = List.of(1, 4, 5, -5, 10, 22, 34);

        // отсеять элементы, которые больше 10 и проверить, что в потоке остались только четные числа

        //allMatch
        boolean isAllMatch = integers.stream()
                .filter(i -> i > 10)
                .peek(i -> System.out.print(i + "; "))
                .allMatch(i -> i % 2 == 0);
        System.out.println("\nisAllMatch: " + isAllMatch);


        // anyMatch
        boolean isAnyMatch = integers.stream()
                .filter(i -> i > 0)
                .peek(i -> System.out.print(i + "; "))
                .anyMatch(i -> i > 50);
        System.out.println();
        System.out.println("isAnyMatch: " + isAnyMatch);

        //noneMatch
        boolean isNoneMatch = integers.stream()
                .filter(i -> i > 0)
                .peek(i -> System.out.print(i + "; "))
                .noneMatch(i -> i > 50);
        System.out.println();
        System.out.println("isNoneMatch: " + isNoneMatch);


    }


}
