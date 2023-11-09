package lesson_47.maps;
/*
@date 09.11.2023
@author Sergey Bugaienko
*/

import java.util.*;

public class MapsExample {
    public static void main(String[] args) {
        Map<Integer, String> oldTable = new Hashtable<>(); // устаревшая. Медленная. Не рекомендуется использовать
        Map<Integer, String> map = new HashMap<>();
        // добавить пару ключ-значение
        // Возвращает "старое" значение, соответсвующее ключу ранее. Если не было такого ключа - вернется null
        map.put(1, "Hello");
        map.put(2, "Java");
        map.put(3, "World");

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(2, "Python");
        System.out.println(map1.put(4, "Orange")); //
        String str = map1.put(4, "test");
        System.out.println(str);

        System.out.println(map);
        // принимает карту, копирую все пару ключ-значения из указанной карты
        map.putAll(map1);
        System.out.println(map);

        //contains -> boolean
        System.out.println("containsKey(8): " + map.containsKey(8));
        System.out.println("containsValue(\"test\"): " + map.containsValue("test"));

        // get(Object key) -> возвращает значение по ключу. Если ключа нет - вернет null
        System.out.println("map.get(1): " + map.get(1));
        System.out.println("map.get(8): " + map.get(8));

        String val = map.get(8);
        if (val == null) val = "Default value";

        // getOrDefault(Object key)
        String value = map.getOrDefault(8, "25");
        System.out.println("getOrDefault(8, \"Default value\"): " + value);
        value = map.getOrDefault(1, "Default value");
        System.out.println("getOrDefault(1, \"Default value\"): " + value);

        System.out.println("map: " + map);
        // V remove(Object key) - удаление пары "ключ-значение" по ключу. Возвращает значение / null
        System.out.println(map.remove(8));
        System.out.println(map.remove(4));
        System.out.println("map: " + map);

        // void clear() - очищает карту / map.clear()

        // int size() - возвращает кол-во элементов в карте
        System.out.println("map.size(): " + map.size());

        // Collection<V> values() - возвращает коллекцию всех значений карты
        Collection<String> strings = map.values();
        System.out.println("map.values() " + strings);

        // boolean isEmpty()

        // Set<K> keySet() - возвращает set состоящий из всех ключей карты
        Set<Integer> keys = map.keySet();
        System.out.println("map.keySet(): " + keys);

        //Map.Entry<K,V> entrySet() - возвращает set представлений всех пар "ключ-значение"
        Set<Map.Entry<Integer, String>> setEntry = map.entrySet();
        System.out.println("setEntry: " + setEntry);
        System.out.println("=================\n");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("entry.getKey(): " + entry.getKey());
            System.out.println("entry.getValue(): " + entry.getValue());
            if (entry.getKey().equals(1)) entry.setValue("Red");
        }
        System.out.println(map);

        System.out.println(map);
        //  replace vs put
        map.put(9, "Car"); // если нет такого ключа, то будет создана новая пара ключ-значение. Если есть - будет переписано value
        System.out.println(map);
        System.out.println(map.replace(10, "Green")); // если нет такого ключа, то НЕ будет создана новая пара ключ-значение. Если есть - будет переписано value
        System.out.println(map);
        System.out.println(map.replace(9, "Replace")); // если нет такого ключа, то НЕ будет создана новая пара ключ-значение. Если есть - будет переписано value
        System.out.println("\n=============================\n");
        System.out.println(map);
        System.out.println(map.replace(9, "any", "new"));
        System.out.println(map);
        System.out.println(map.replace(9, "Replace", "newValue"));
        System.out.println(map);

        System.out.println("=================");
        // перебор всех пар ключ-значение. И возможность применить какую-то функцию к ним
        map.forEach((k, v) -> System.out.println("Key: " + k + "; value: " + v));


    }
}
