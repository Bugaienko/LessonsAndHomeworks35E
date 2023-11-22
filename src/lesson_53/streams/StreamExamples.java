package lesson_53.streams;
/*
@date 21.11.2023
@author Sergey Bugaienko
*/

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {

        //Промежуточные операции:
        // Stream<T> filter(Predicate<T> predicate) - отфильтровывает элементы, не соответсвующее предикату.
        // sorted() -сортирует элементы в естественном порядке
        // sorted(Comparator<T> comparator) -сортирует элементы c использованием компаратора
        // Stream<R> map(Function<T, R> mapper) - преобразует элементы потока  с использованием заданной функции, в том числе в другой тип данных
        // peek(Consumer<T> action) - выполняет действие для каждого элемента потока

        //Терминальные операции
        //void forEach(Consumer<T> action) - выполняет заданное действие для каждого элемента потока
        //R collect(Collector<T, A, R> collector) - преобразует элементы потока в разные типы коллекций или другие структуры данных
        //Optional<T> min(Comparator<T> comparator) - возвращает минимальное значение элемента потока в соответствии с компаратором
        //Optional<T> max(Comparator<T> comparator) - возвращает максимальное значение элемента потока в соответствии с компаратором

        //  task1();

        //  task2();

        //  task3();

        // task4();

        // Получить список имен кошек, чей вес больше 4
        // task5();

        // Получить список имен кошек, которые короче 5 символов
        //task6();

        // Stream api и исключения
        //task7();

        //Изменить имя котика по условию. Распечатать список элементов потока
        // task8();

        // min, max
        //task9();

        // Верните самое длинное имя кота из списка котов
        //task10();

        // Цепочки фильтрации
        task11();
        task12();

    }

    private static void task12() {

        Cat cat = new Cat(null, 5, "braun");
        Cat cat1 = new Cat("Python", 7, "white");
        Cat cat2 = new Cat("Panda", 4, "black");

        Cat[] cats = new Cat[]{cat, cat1, null, cat2};

        // Получить список котиков, вес которых больше 4

        List<Cat> bigCats = Arrays.stream(cats)  // получить поток из элементов массива
                //.filter(Objects::nonNull)
                .filter(c -> Objects.nonNull(c))
                //.filter(c -> Objects.nonNull(c.getName())) - проверка какого-то поля на null (для примера)
                .filter(c -> c.getWeight() > 4)
                .collect(Collectors.toList());

        System.out.println(bigCats);

    }

    private static void task11() {
        // Цепочки фильтрации

        //Получить список всех положительных, четных чисел, входящих в список-донор целых чисел

        List<Integer> integers = List.of(1, 4, 7, -5, -8, 0, 10, 22, 23);

        List<Integer> integerList = integers.stream()
                .filter(i -> i > 0)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(integerList);
    }

    private static void task10() {
        // Верните самое длинное имя кота из списка котов
        // Фильтровать и возвращать мы будем имена котов (String)-> Cat -> String (name)
        // надо найти самое длинное имя, т.е. сравнить имена по их длине и "назначить" максимальным значением самое длинное имя

        List<Cat> cats = getListCats();

        Optional<String> longestName = cats.stream()
                .map(Cat::getName)
                .max((name1, name2) -> name1.length() - name2.length());

        if (longestName.isPresent()) {
            System.out.println(longestName.get());
        } else {
            System.out.println("Котов с именами не найдено!");
        }

    }

    private static void task9() {
        // min, max
        List<Integer> integers = List.of(5, 4, 14, 50, 32, 24, -1);

        Optional<Integer> max = integers.stream()
                .filter(i -> i < 0)
                .max(Integer::compareTo);
        System.out.println("isPresent: " + max.isPresent());
        System.out.println(max.orElse(0));
    }

    private static void task8() {
        //Изменить имя котиков, вес которых меньше 5 (по условию). Распечатать список элементов потока
        //
        List<Cat> cats = getListCats();

        Stream<Cat> catStream = cats.stream()
                .filter(cat -> cat.getWeight() < 5) //фильтруем котиков
//                .peek(cat -> cat.setName(cat.getName() + "_")); // промежуточный метод, выполняет действие для каждого элемента потока
                .peek(cat -> cat.setName("Slim" + cat.getWeight())); // промежуточный метод, выполняет действие для каждого элемента потока

        catStream.forEach(cat -> System.out.println(cat)); // терминальный метод, выполняет действие для каждого элемента потока

        System.out.println("cats: " + cats);


    }

    private static void task7() {
        // Stream api и исключения
        List<Cat> cats = List.of(
                new Cat("Bear", 5, "braun"),
                new Cat("Python", 7, "white"),
                new Cat(null, 3, "gray"),
                new Cat("Panda", 4, "black")
        );


        Stream<Cat> catStream = cats.stream()
                .filter(cat -> cat.getName().length() > 4);

        System.out.println("Catch stream");


        try {
            List<Cat> cats1 = catStream.collect(Collectors.toList());
            System.out.println(cats1);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    private static void task6() {
        // Получить список имен кошек, которые короче 5 символов
        List<Cat> cats = getListCats();

        List<String> catNames = cats.stream()
                .map(Cat::getName)
                .filter(name -> name.length() < 5)
                .collect(Collectors.toList());

        List<String> names = cats.stream()
                .filter(cat -> cat.getName().length() < 5)
                .map(Cat::getName)
                .collect(Collectors.toList());


        System.out.println("names opt1: " + catNames);
        System.out.println("names opt2: " + names);

    }

    private static void task5() {
        List<Cat> cats = getListCats();
        // Получить список имен кошек, чей вес больше 4

        List<String> catNames = cats.stream()
                .filter(cat -> cat.getWeight() > 4)
                .map(Cat::getName)
                //  .map(cat -> cat.getName())
                .collect(Collectors.toList());

        System.out.println(catNames);
    }

    private static void task4() {
        // получить список имен всех кошек
        List<Cat> cats = getListCats();

        Stream<String> stringStream = cats.stream()
                .map(cat -> cat.getName());


        List<String> catNames = cats.stream()
                .map(Cat::getName)
                .collect(Collectors.toList());

        System.out.println("catNames: " + catNames);
    }

    private static void task3() {
        List<Cat> cats = getListCats();

        // фильтрация по длине имени.

        Stream<Cat> stream = cats
                .stream()
                .filter(cat -> cat.getName().length() > 4);

        // пока не запущен терминальный метод, промежуточные методы не выполняются
        List<Cat> longNameCats = stream.collect(Collectors.toList());

        System.out.println("cats: " + cats);

    }

    private static void task2() {
        List<Cat> cats = getListCats();

        // список кошек, чей вес больше 4 кг

        Stream<Cat> catStream = cats.stream()
                .filter(cat -> cat.getWeight() > 4);

        List<Cat> fatCats = catStream.collect(Collectors.toList());

        // повторно использовать "закрытый" стрим нельзя
        //List<Cat> fat2 = catStream.filter(cat -> cat.getWeight() > 5).collect(Collectors.toList());

        System.out.println(fatCats);

        // Lazy Evaluation - Ленивые вычисления


    }


    private static List<Cat> getListCats() {
        return List.of(
                new Cat("Bear", 5, "braun"),
                new Cat("Python", 7, "white"),
                new Cat("Tiger", 3, "gray"),
                new Cat("Panda", 4, "black")
        );
    }

    private static void task1() {
        List<Integer> integers = List.of(-1, 12, 0, 4, 1, -15, 24, 0);
        // список, содержащий положительные числа. Список должен быть отсортирован в порядке возрастания.

//        List<Integer> result = new ArrayList<>();
//        for (Integer integer : integers) {
//            if (integer > 0) result.add(integer);
//        }
//        Collections.sort(result);
//        System.out.println(result);

        // У всех коллекций, есть метод stream - создающий поток на основе коллекции.
        List<Integer> integerList = integers.stream() //создание потока на основе элементов коллекции
                .filter(integer -> integer > 0)  // фильтрация элементов потока
                .sorted() // сортировка в естественном порядке
                .collect(Collectors.toList()); // преобразуем элементы потока в список (коллекцию)

        System.out.println(integerList);

    }
}
