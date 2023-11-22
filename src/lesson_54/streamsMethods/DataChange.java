package lesson_54.streamsMethods;
/*
@date 22.11.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataChange {
    public static void main(String[] args) {

        // Промежуточные методы для изменения потока (типа) данных

        /*
        map(Function<T, R> mapper) - преобразует элементы потока с использованием заданной функции
        flatMap(Function<T, R> mapper) - Преобразуем каждый элемент потока в поток других объектов и затем "сглаживает / склеивает" все эти потоки в один
        mapToObj(IntFunction() mapper) - преобразует примитивный тип данных в ссылочный при помощи заданной функции

        mapToInt -> преобразует объекты потока в IntStream (поток примитивов)
        mapToLong
        mapToDouble



         */

        //Получить список всех продуктов, представленных во всех магазинах
        task_1();

        //преобразование потока примитивный типов данных в коллекции
        task_2();

        //преобразовать строку в массив строк примитивов (int)
        task_3();
    }

    private static void task_3() {
        String[] str = new String[]{"aaa", "bbbb", "cccc"};

        List<Integer> integers = Arrays.stream(str)
                .map(String::length)
                .collect(Collectors.toList());

        int[] ints = Arrays.stream(str)
                .mapToInt(String::length)
                .toArray();
        System.out.println(Arrays.toString(ints));
    }

    private static void task_2() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6};

        List<Integer> integers = Arrays.stream(ints)
//                .mapToObj(i -> i)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("integers: " + integers);
    }

    private static void task_1() {
        //Получить список всех продуктов, представленных во всех магазинах

        Shop shop = new Shop("Shop1", List.of("Orange", "Banana", "Apple"));
        Shop shop1 = new Shop("Shop1", List.of("Lime", "Cherry", "Pineapple"));
        Shop shop2 = new Shop("Shop1", List.of("Grape", "Lemon", "Apple"));

        Shop[] shops = new Shop[]{shop, shop1, shop2};

        List<String> products = Arrays.stream(shops)
                .flatMap(shopCurrent -> shopCurrent.getProducts().stream())
                .collect(Collectors.toList());

        System.out.println(products);

        String[] strings = new String[]{"ABC", "def", "qwerty", "XyZ"};

//        Arrays.stream(strings)
//                .flatMapToInt(str -> str.chars())
//                .peek(i -> System.out.print((char) i + ";  "))
//                .map(i -> {
//                    Character ch = (char) i;
//                    return ch;
//                })
//                .forEach(i -> System.out.println(i + "; "));

        List<Character> characterList = Arrays.stream(strings)
                .flatMapToInt(str -> str.chars())
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());

        System.out.println("characterList: " + characterList);

    }
}
