package lesson_55.streamsExample;
/*
@date 23.11.2023
@author Sergey Bugaienko
*/

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {

        // Терминальный метод collect

        /*
        collect(Collector<? super T, A, R> collector) - Преобразует элементы потока в различные структуры данных.
        Позволяет сохранить элементы потока в структуру данных и/или произвести группировку

        Класс Collectors - содержит большой набор статических методов, возвращающих реализации интерфейса Collector

        toList() - создает коллектор, который собирает элементы в список (List)

        toSet() - собирает элементы в Set. Т.е. на выходе получим набор уникальных элементов

        toMap() - 8 методов - создает коллектор, который собирает данные в Map.

        toMap(Function keyMapper, Function valueMapper) - собирает элементы в карту. Требуются функции преобразования элементов потока в ключи и значения

        toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction) - Аналогичен предыдущему,
        но добавляет функцию слияния для разрешения конфликтов ключей

        toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier supplier) - Supplier указывающий конкретную реализацию карты

        toUnmodifiableMap, toConcurrentMap
        toUnmodifiableMap, toConcurrentMap


         */

        //map1();

        map2();


    } // main

    private static void map2() {

        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        Function<Integer, String> keyMapper = i -> (i % 2 == 0) ? "even" : "odd";

        Function<Integer, List<Integer>> valueMapper = i -> List.of(i);

        BinaryOperator<List<Integer>> mergeFunction = (l1, l2) -> {
           List<Integer> result = new ArrayList<>(l1);
           result.addAll(l2);
           return  result;
        };

        Map<String, List<Integer>> mapOddEven = integers.stream()
                .collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction));

        System.out.println("mapOddEven: " + mapOddEven);

        // Supplier
        Supplier<Map<String, List<Integer>>> supplier = LinkedHashMap::new;

        Map<String, List<Integer>> mapOddEvenLinked = integers.stream()
                .collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction, supplier));

        System.out.println("mapOddEvenLinked: " + mapOddEvenLinked);


    }

    private static void map1() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);

        Map<Integer, String> result = integers.stream()
                .collect(Collectors.toMap(Function.identity(), i -> (i % 2 == 0) ? "even" : "odd"));

        System.out.println(result);
    }
}
