package lesson_52.interfaces;
/*
@date 20.11.2023
@author Sergey Bugaienko
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main52 {

    public static void main(String[] args) {

        // Function<T, R> - предназначен для операций, который принимают один входной параметр типа T
        //  и возвращают результат типа R

        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String string) {
                return string.length();
            }
        };




        Function<String, Integer> function1 = string -> string.length();

        Function<String, Integer> function2 = String::length;
        System.out.println(function2.apply("Hello!"));

        String text = "Java is PowerfuL";

        Function<String, Integer> countSpaces = Main52::countSpaces;
        System.out.println("количество пробелов: " + countSpaces.apply(text));


        Function<String, Integer> countUpperCase = Main52::countUpperCase;
        System.out.println("количество больших букв: " + countUpperCase.apply(text));

        Function<String, String> function3 = String::toLowerCase;
        System.out.println("toLowerCase: " + function3.apply(text));


        // Consumer<T> - выполняет действие надо объектом типа T, но не возвращает никакого результата (void)
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(Arrays.toString(string.toCharArray()));
            }
        };

        consumer.accept("consumer: " + text);
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("System.out::println: " + text);

        Consumer<String> printCharsConsumer = Main52::printChars;
        printCharsConsumer.accept(text);


        // Predicate<T> - принимает один аргумент и возвращает логическое значение (boolean).
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return string.length() > 3;
            }
        };

        List<String> strings = List.of("Orange", "Tea", "Milk", "Ice", "Banana");

        List<String> longString = getListByPredicate(strings, predicate);
        System.out.println("longString: " + longString);

        System.out.println(getListByPredicate(strings, string -> string.contains("W")));

        Predicate<String> predicate1 = string -> string.length() > 3;
        Predicate<String> predicate2 = string -> string.contains("a");

        //and (Predicate<? super T> other) -- логическое И (AND)
        Predicate<String> combinedPredicateAnd = predicate1.and(predicate2); //

        System.out.println("combinedPredicate AND: " + getListByPredicate(strings, combinedPredicateAnd));

        // or -- логической ИЛИ (OR)
        Predicate<String> combinedPredicateOr = predicate1.or(predicate2);
        System.out.println("combinedPredicate OR: " + getListByPredicate(strings, combinedPredicateOr));

        //negate () -- логическое НЕТ (NOT)
        Predicate<String> combinedPredicateNot = predicate1.negate(); // (!true) == false
        System.out.println("combinedPredicate NOT: " + getListByPredicate(strings, combinedPredicateNot));


    } // main

    private static List<String> getListByPredicate(List<String> strings, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();

        for (String string : strings) {
            if (predicate.test(string)) {
                result.add(string);
            }
        }

        return result;
    }

    private static void printChars(String string) {
        for (char ch : string.toCharArray()) {
            System.out.print(ch + " -> ");
        }
        System.out.println();
    }

    private static Integer countUpperCase(String string) {
        Integer count = 0;
        for (char ch : string.toCharArray()) {
//           if (ch >= 65 && ch <= 90) {
//
//           }
            if (Character.isUpperCase(ch)) {
                count++;
            }
        }
        return count;
    }

    public static Integer countSpaces(String string) {
        Integer count = 0;
        for (char ch : string.toCharArray()) {
            if (ch == ' ') {
                count++;
            }
        }
        return count;
    }


}
