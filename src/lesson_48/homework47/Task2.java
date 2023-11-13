package lesson_48.homework47;
/*
@date 13.11.2023
@author Sergey Bugaienko
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Пересечение двух карт:
Реализуйте метод, который принимает две карты Map<String, Integer> и
возвращает новую карту, содержащую только те записи, ключи которых присутствуют в обеих исходных картах.
Для совпадающих ключей значение можно брать из любой карты
 */
public class Task2 {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 50);
        map1.put("banana", 20);
        map1.put("cherry", 30);
        map1.put("test", 40);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("banana", 25);
        map2.put("cherry", 30);
        map2.put("date", 40);

        System.out.println("map1: " + map1);
        // получили сет ключей их карты. Этот сет имеет "живую" связь с картой.
        // какие-либо изменения в этом сете мгновенно отражаются и в карте
        Set<String> keySet1 = map1.keySet();
        // удаляю ключ из сета ключей (при этом вроде как не трогаю саму HashMap
        keySet1.remove("test");

        System.out.println("map1:" + map1);
        System.out.println("\n==============================\n");
        System.out.println("map2: " + map2);

        // перебор коллекции с одновременным изменением значений
        for (Map.Entry<String, Integer> entry : map2.entrySet()){
            if (entry.getValue() < 35) {
                entry.setValue(100);
            }
        }

        System.out.println("map2: " + map2);



//        Map<String, Integer> intersectionMap = intersection(map1, map2);
//        intersectionMap.forEach((key, value) -> System.out.println(key + ": " + value));


        Map<String, Integer> intersectionMap2 = intersection2(map1, map2);
        intersectionMap2.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("map1: " + map1);

    }

    private static Map<String, Integer> intersection(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        Set<String> keySetMap1 = map1.keySet();
        // Содержаться ключи, которые присутствуют в обоих картах
        keySetMap1.retainAll(map2.keySet());

        for (String key : keySetMap1) {
            result.put(key, map1.get(key));
        }

        return result;
    }

    private static Map<String, Integer> intersection2(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);
        Set<String> keySet1 = result.keySet();
        keySet1.retainAll(map2.keySet());

        return result;
    }
}
