package lesson_45;
/*
@date 07.11.2023
@author Sergey Bugaienko
*/

import lesson_31.myArrayList.MyArrayList;
import lesson_31.myArrayList.MyList;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("hello", "list", "collection", "example", "Java"));

        // void add(int index, E el) - добавляет элемент на указанную позицию
        strings.add(2, "Index2");
        System.out.println(strings);

        System.out.println(strings.get(3)); // возвращает элемент по индексу
        //E remove(int index); удаляет элемент по индексу и возвращает его значение
        System.out.println("remove index: " + strings.remove(2));
        System.out.println(strings);

        //E set(int index, E e) // заменяет элемент на указаной позиции новым значением
        System.out.println(strings.set(2, "new collection"));
        strings.add("new collection");
        strings.add("new collection");
        System.out.println(strings);

        // если элемент не найден - возвращается -1.
        System.out.println(strings.indexOf("new collection")); // принимает Object. Возвращает индекс первого вхождения значения в коллекцию
        System.out.println(strings.lastIndexOf("new collection")); // возвращает индекс последнего вхождения.

        //List<E> subList(int indexFrom, int indexTo) - возвращает список из элементов, на позициях с indexFrom до indexTo-1

        List<String> subList = strings.subList(1,4);
        System.out.println("subList " + subList);

        //void sort(Comparator<? super E> comparator) // сортирует список с использованием указанного компаратора

        strings.sort((s1, s2) -> s2.compareTo(s1));
        System.out.println(strings);
        Collections.reverse(strings); // обращает порядок элементов в списке
        System.out.println("reverse " + strings);
        Collections.shuffle(strings); //случайным образом перемешивает элементы
        System.out.println("shuffle: " + strings);

        // ArrayList constructors
        // new ArrayList<>(); создает список с массивом по капотом размерностью 10
        // new ArrayList<>(int capacity) создает список с массивом по капотом размерностью capacity
        // new ArrayList<>(Collection<? extends E> collection) // создает список, содержащий элементы collection

        // создать два списка. Один на реализации ArrayList, второй на LinkedList
        // создать третий список на реализации, которую писали мы сами.
        // заполнить все списки 10000 случайных значений
        // засечь время, требующееся на заполнение каждого из списков

        List<Integer> arrayList = new ArrayList<>(100000);
        List<Integer> linkedList = new LinkedList<>();
        MyList<Integer> myList = new MyArrayList<>();
        Random random = new Random();

        long start = System.currentTimeMillis();

        // заменить все элементы в списке на указанный объект

        for (int i = 0; i < 100_000; i++) {
            arrayList.add(random.nextInt(1000));
        }
        long end = System.currentTimeMillis();
        System.out.println(arrayList.size());
        Integer int2 = arrayList.get(50000);
        System.out.println(int2);


        System.out.println("arrayList: " + (end - start));

        start = System.currentTimeMillis();
        Collections.fill(arrayList, random.nextInt(1000));
        end = System.currentTimeMillis();
        System.out.println("fill: " + (end - start));
        int2 = arrayList.get(50000);
        System.out.println(int2);




        start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            linkedList.add(random.nextInt(1000));
        }
        end = System.currentTimeMillis();
        System.out.println("linkedList: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            myList.add(random.nextInt(1000));
        }
        end = System.currentTimeMillis();
        System.out.println("myList: " + (end - start));

    }

}
