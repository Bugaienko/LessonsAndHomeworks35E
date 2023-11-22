package lesson_54.streamsMethods;
/*
@date 22.11.2023
@author Sergey Bugaienko
*/

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StaticMethods {
    public static void main(String[] args) {

        // Статические методы

        /*
        методы of()
        of(T value) - создает поток из одного элемента
        of(T...values) - создает поток из переданных значений
        ofNullable() - поток из одного элемента или пустой поток


        empty() - Создает пустой поток. Stream.empty();

        concat(Stream<T> a, Stream<T> b) ->создаст поток, содержащий элементы из a и b

        generate(Supplier<T> s) - создает БЕСКОНЕЧНЫЙ поток, генерируя элементы с помощью предоставленной функции.
        Если мы хотим собрать его в список - надо как-то ограничить кол-во элементов

        iterate(T seed, UnaryOperator<T> f) - Создает бесконечный поток, в котором каждый последующий элемент генерируется путем
        повторного применения функции к предыдущему элементу, начиная с начального значения seed

        iterate(T seed, Predicate<T> hasNext, UnaryOperator<T> f) - похож на iterate, но включает hasNext, который определяет когда итерация должна остановиться

         */

        //of
        //task_of();

        //concat
        //task_concat();

        //generate
        //task_generate();

        //iterate
        task_iterate();


    } //main

    private static void task_iterate() {
        Stream<Integer> integerStream = Stream.iterate(0, n -> n + 2); // создаст бесконечный поток честных чисел

        List<Integer> integers = integerStream.limit(15).collect(Collectors.toList());
        System.out.println("integers: " + integers);


        List<Integer> integerStream1 = Stream.iterate(0, n -> n <= 10, n -> n + 1).collect(Collectors.toList());
        System.out.println("integerStream1: " + integerStream1) ;
    }

    private static void task_generate() {


        Stream<Double> infinityStream = Stream.generate(Math::random); // Math.random()


        List<Double> randomDoubleList = infinityStream
                .limit(20)
                .collect(Collectors.toList());

        System.out.println(randomDoubleList);

        Random random = new Random();

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return random.nextInt(1000);
            }
        };


        Stream<Integer> streamIntegers = Stream.generate(supplier);
        List<Integer> randomIntegers = streamIntegers.limit(10)
                .collect(Collectors.toList());
        System.out.println(randomIntegers);


        System.out.println(Stream.generate(new Random()::nextInt).limit(10).collect(Collectors.toList()));


    }

    private static void task_concat() {
        Stream<Integer> integerStream = Stream.concat(Stream.of(1, 2, 4), Stream.of(2, 5, 7));
        System.out.println(integerStream.collect(Collectors.toList()));

    }

    private static void task_of() {
        Stream<Integer> stream = Stream.of(12);
        stream.forEach(System.out::println);
//        stream.forEach(el -> System.out.println(el));

        //of(T...values)
        Stream<String> stringStream = Stream.of("string", "hello", "java");

//        stringStream
//                .map(String::length)
//                .map(String::length)

        stringStream.forEach(System.out::println);

        String s = null;
        Stream<String> nullStream = Stream.ofNullable(s);
        System.out.println(nullStream.collect(Collectors.toList()));


    }


}
