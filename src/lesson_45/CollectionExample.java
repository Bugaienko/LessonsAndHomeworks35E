package lesson_45;
/*
@date 07.11.2023
@author Sergey Bugaienko
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class CollectionExample {
    public static void main(String[] args) {

        /*
        int size(); // количество элементов в коллекции
         */

//        List<String> strings = new ArrayList<>(List.of("hello", "Java", "world", "example"));
//        List<String> strings2 = new ArrayList<>(List.of("hello", new String("Java")));
//        System.out.println("containsAll strings: " + strings.containsAll(strings2));
//        System.out.println("==: " + ("Java" == new String("Java")));
//        System.out.println("equals: " + ("Java".equals(new String("Java"))));

        List<Integer> integers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> nulls = new ArrayList<>(List.of(0, 0, 0));

        // Методы интерфейса Collection. Все эти методы гарантированно есть во всех интерфейсах, расширяющих Collection (и их реализациях)

        integers.addAll(List.of(1, 2, 3, 4, 5));
        numbers.addAll(List.of(3, 2, 1));
        System.out.println("containsAll o.1: " + integers.containsAll(numbers));
        System.out.println("containsAll o.2: " + numbers.containsAll(integers));

        System.out.println("size: " + integers.size()); // количество элементов в коллекции
        System.out.println("isEmpty " + integers.isEmpty()); // возвращает true, если коллекция пуста
        System.out.println("contains " + integers.contains(1)); // boolean contains(Object o) // возвращает true, если коллекцияч содержит такой объект
        System.out.println("add: " + integers.add(1)); // boolean add(E e) - добавляет элемент в коллекцию. Возвращает true в случае успешного добавления
        System.out.println("remove " + integers.remove("Small")); // boolean remove(Object o)
        System.out.println("containsAll " + integers.containsAll(numbers)); // возвращает true? если коллекция содержит все элементы из указанной в аргументах коллекции
        System.out.println("addAll " + integers.addAll(numbers)); // добавляет все элементы из указанной коллекции в эту коллекцию, возвращает boolean
        System.out.println("addAll + index: " + integers.addAll(3, nulls)); // добавляет все элементы из коллекции. Вставка начинается с индекса index
        System.out.println(integers);
        System.out.println("RemoveAll: " + integers.removeAll(numbers)); // удаляет все элементы из коллекции, которые есть в коллекции numbers
        System.out.println(integers);
        integers.addAll(numbers);
        integers.add(3);
        integers.add(6);
        System.out.println(integers);
        System.out.println("RetainAll: " + integers.retainAll(numbers)); // оставляет в коллекции только те элементы, которые содержаться в numbers
        System.out.println(integers);
        System.out.println("void clear: " ); integers.clear(); // удаляет все элементы из коллекции
        System.out.println(integers);
        Object[] array = numbers.toArray(); // возвращает массив, содержащий все элементы коллекции Object[] toArray();
        System.out.println(Arrays.toString(array));
        Integer[] ints2 = new Integer[1];
        ints2 = numbers.toArray(ints2); // <T> T[] toArray(T[] a); // возвращать все элементoв коллекции, тип возвращаемого массива соответсвует типу массива в аргументах
        System.out.println(Arrays.toString(ints2));
        System.out.println("removeIf:  " + numbers.removeIf(i -> i > 2));
        System.out.println(numbers);


//        for (Integer i : numbers) {
//            if (i > 2 ){
//                numbers.remove(Integer.valueOf(i));
//            }
//        }

        //System.out.println(numbers);

//        Predicate<Integer> predicate = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer i) {
//                return i > 1;
//            }
//        };







    }
}
