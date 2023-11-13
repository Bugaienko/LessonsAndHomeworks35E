package lesson_48.mapMethods;
/*
@date 13.11.2023
@author Sergey Bugaienko
*/

import java.util.HashMap;
import java.util.Map;

public class ComputeMergeExample {
    public static void main(String[] args) {
        // map(K key, BiFunction<Key, Value>

        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key3", 3);
        System.out.println(map);

        //Позволяет вычислить новое значение для указанного ключа, используя функцию пересчета
        map.compute("key1", (key, value) -> value == null ? 10 : value + 5);
        System.out.println(map);

        // если функция пересчета вернет null - пара ключ-значение будет удалена из карты
        map.compute("key1", (key, value) -> value == null ? 10 : null);
        System.out.println(map);


        System.out.println(map.get("key2"));

        // Вычисляет новое значение для ключа ТОЛЬКО ЕСЛИ ключ еще не ассоциирован с каким-то значением или ассоциирован с null;
        map.computeIfAbsent("key2", k -> 1); // в карте не было ключа key2 -> создана новая пара ключ-значение <"key2"=1>
        System.out.println(map);
        map.computeIfAbsent("key2", k -> 10); // в карте УЖЕ есть ключ key2 -> никакие пересчеты производиться не будут
        System.out.println(map);


        //Вычисляет новое значение для ключа ТОЛЬКО ЕСЛИ ключ уже ассоциирован с ненулевым значением.
        // функция пересчета применяется только если ключ присутствует в карте

        // key3 есть : value = 3
        map.computeIfPresent("key3", (key, value) -> value + 1); // станет <key3=4>
        System.out.println(map);

        // key4 нет : value  нет
        map.computeIfPresent("key4", (key, value) -> value + 1); //функция пересчета применена не будет
        System.out.println(map);

        map.put("key4", null);
        System.out.println("key4 : null -> " + map);
        // key4 есть : value = null
        map.computeIfPresent("key4", (key, value) -> value + 1); //функция пересчета применена не будет
        System.out.println("map after compute: " + map);


        System.out.println("\n==========================\n");
        // merge - используется для объединения значений

        map.merge("key5", 1, (oldValue, value) -> oldValue + value);

        // если ключ не существует -> будет добавлена новая пара "key5": 1 (value);
        //Если ключ существует и ассоциирован с ненулевым значением, применяется функция пересчета
        // функция использует текущее значение, соответсвующее ключу и value (2-й аргумент метода)


    }
}
