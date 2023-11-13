package lesson_48.collectionsEx;
/*
@date 13.11.2023
@author Sergey Bugaienko
*/

import java.util.*;

public class CollectionsEx {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(List.of("test", "java", "orange", "hello", "compute"));

        // Экземпляр класса  создать не возможно
        // Collections collections  =new Collections();
        //все методы статические

        /*
        1. Сортировка и поиск
         */

        // sort, binarySearch

        // сортирует по возрастанию natural order
        Collections.sort(strings);
        System.out.println(strings);

        int index = Collections.binarySearch(strings, "test");
        System.out.println(index);

        // принимает компаратор для определения метода сравнения
        Collections.sort(strings, (s1, s2) -> s1.length() - s2.length());
        System.out.println(strings);

        Collections.sort(strings);
        System.out.println(strings);

        // возвращает значение >= 0 если элемент найден. И возвращает отрицательное значение, если элемент не найден
        int binarySearch = Collections.binarySearch(strings, "test2", (s1, s2) -> s1.length() - s2.length());
        System.out.println(binarySearch);


        /*
        2. Перемешивание, замена
         */

        // обращает порядок элементов
        Collections.reverse(strings);
        System.out.println("reverse: " + strings);

        Collections.shuffle(strings);
        System.out.println("shuffle: " + strings);

        // заменяет значение всех элементов
        Collections.fill(strings, "str");
        System.out.println("strings: " + strings);

        //копирует все элементы из одного списка в другой
        // в списке назначения должно быть не меньше элементов, чем в "доноре" - иначе ошибка
        List<String> strings2 = new ArrayList<>(List.of("str1", "str2", "str3", "str4", "str5"));
        Collections.copy(strings2, strings);
        System.out.println("strings2: " + strings2);

        Collections.swap(strings2, 1, 3); // меняет местами два элемента в коллекции по индексам

        /*
        Экстремальные значения
         */

        List<Integer> integers = new ArrayList<>(List.of(1, 4, 5, 6, -10, 15));
        int min = Collections.min(integers);
        int max = Collections.max(integers);
        System.out.println("min: " + min + "; max: " + max);
        min = Collections.min(integers, Comparator.reverseOrder());
        max = Collections.max(integers, Comparator.reverseOrder());
        System.out.println("min: " + min + "; max: " + max);

        //
        Collections.addAll(integers, 1,2,3,4,5); //T...elements
        System.out.println(integers);

        // принимает две коллекции. Возвращает true если коллекции не имеют общих элементов
        System.out.println(Collections.disjoint(integers, List.of(100, 50, 25, 1)));

        // возврат пустых
        Collections.emptyMap(); // умеет возвращать пустые коллекции. Разные.

        // Неизменяемые коллекции
        Collection<Integer> col = Collections.unmodifiableCollection(integers);
        List<Integer> list = Collections.unmodifiableList(integers);

        // Синхронизированные коллекции
        Collection<Integer> synh = Collections.synchronizedCollection(integers);
        List<Integer> synchronizedList = Collections.synchronizedList(integers);


    }
}
