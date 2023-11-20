package lesson_52.interfaces;
/*
@date 20.11.2023
@author Sergey Bugaienko
*/

import java.util.function.*;

public class CombinedInterfaces {

    public static void main(String[] args) {
        // andThen, compose

        //andThen(Function<T, R> after) - позволяет создать последовательность двух операций.
        // Первой выполнится текущая функция, немедленно за ней выполнится функция after

        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> concatStrings = string -> string + "!";
        Function<String, String> combinedFunction = toUpperCase.andThen(concatStrings);

        System.out.println(combinedFunction.apply("hello"));

        Function<Integer, Integer> sum = i -> i + 5;
        Function<Integer, Integer> multi = i -> i * 2;
        Function<Integer, Integer> combinedInt = sum.andThen(multi);
        System.out.println("combinedInt: " + combinedInt.apply(3));

        // compose(Function<T, R> before) --> Сначала применяется функция before к входному значению и только потом применяем текущую функцию (к результату before)
        // Используется для подготовки входных данных перед обработкой

        Function<Integer, Integer> combinedIntCompose = sum.compose(multi);
        System.out.println("combinedIntCompose: " + combinedIntCompose.apply(3));

        Consumer<String> consumer = string -> System.out.println("1: " + string.length());
        Consumer<String> consumer1 = string -> System.out.println("2: " + string + "!");
        Consumer<String> consumer2 = consumer.andThen(consumer1);
        consumer2.accept("Test");

        // BiFunction<T, U, R> - принимает два аргумента типов T и U, и возвращает объект типа R.
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b + 1;
        int result = add.apply(5, 6);
        System.out.println("result: " + result);

        //BiConsumer<T, U> - принимает два аргумента типов T, U, ничего не возвращает
        BiConsumer<String, String> biConsumer = ((string, string2) -> System.out.println(string + " : " + string2));
        biConsumer.accept("Hello", "Java");

        //BiPredicate<T, U> - принимает два аргумента типов T, U и возвращает логическое значение (boolean)
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a > b;
        System.out.println("biPredicate: " + biPredicate.test(10, 20));


    }
}
