package lesson_55.streamsExample;
/*
@date 23.11.2023
@author Sergey Bugaienko
*/

import java.util.List;
import java.util.stream.Stream;

public class ChangeOrder {
    public static void main(String[] args) {

        // Промежуточные методы для изменения порядка элементов
        // sorted,
        // unordered() - указывает, что в потоке не обязательно сохранять порядок элементов. В основном имеет смысл в параллельных потоках

        // task1();

        // task2();

        task3();


    } //

    public static void task1() {
        List<String> strings = List.of("E1", "E2", "E3");

        Stream<String> stream = strings.stream()
                .filter(string -> {
                    System.out.println("filter: " + string);
                    return string.length() <= 2;
                })
                .map(string -> {
                    System.out.println("map: " + string);
                    return "_" + string;
                });

        stream.forEach(string -> System.out.println("forEach: " + string));
    }
    public static void task2() {
        List<String> strings = List.of("E1", "E2", "E3");

        Stream<String> stream = strings.stream()

                .filter(string -> {
                    System.out.println("filter: " + string);
                    return string.endsWith("2");
                })
                .map(string -> {
                    System.out.println("map: " + string);
                    return "_" + string;
                });



        stream.forEach(string -> System.out.println("forEach: " + string));
    }

    public static void task3() {
        List<String> strings = List.of("E1", "E3", "E2", "E22"); // -> "E1","E2", "E3"

        Stream<String> stream = strings.stream()


                .filter(string -> {
                    System.out.println("filter: " + string);
                    return string.endsWith("2");
                })
                .map(string -> {
                    System.out.println("map: " + string);
                    return "_" + string;
                })
                .sorted((s1, s2) -> {
                    System.out.println("sorted: " + s1 + ":" + s2);
                    return s1.compareTo(s2);
                });



        stream.forEach(string -> System.out.println("forEach: " + string));
    }


}
