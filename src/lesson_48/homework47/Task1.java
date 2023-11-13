package lesson_48.homework47;
/*
@date 13.11.2023
@author Sergey Bugaienko
*/

import java.util.HashMap;
import java.util.Map;

/*
Частотный словарь слов:
Напишите метод, который принимает строку текста и
возвращает Map<String, Integer>, где каждому слову соответствует количество его вхождений в текст.
 */
public class Task1 {
    public static void main(String[] args) {
        String text = "Строка для проверки количества вхождений слов" +
                ".\n Строка для проверки и теста. и количества слов для проверки";

        Map<String, Integer> frequencyMap = frequencyDictionary(text);
        frequencyMap.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("op2: " + frequencyDictionary2(text));
        System.out.println("op3: " + frequencyDictionary3(text));
        System.out.println("op4: " + frequencyDictionary4(text));
        System.out.println("op5: " + frequencyDictionary5(text));

        //Map<Character, Integer> frequencyCharsMap = frequencyCharsDictionary(text);

//        System.out.println("\nВхождение символов: ");
//        frequencyCharsMap.forEach((k, v) -> System.out.print("'" + k + "': " + v+ "; "));
//        System.out.println();
    }

    /*
    1. Поместить в какую-то коллекцию наши слова
    2. Создать карту соответствия слово - количество вхождений
    3. Перебирать слова. Проверять - есть ли слово в карте. Если есть - обновить значение +1
    4. Если нет - добавить новый ключ со значением 1.
     */

    private static Map<String, Integer> frequencyDictionary(String text) {
        // получаем массив слов
        String[] words = text.replaceAll("[^a-zA-Zа-яА-Я ]", "").split("\\s+");

        Map<String, Integer> result = new HashMap<>();

        // перебираю слова
        for (String word : words) {
            // пытаюсь получить значение, соответсвующее ключу "текущее слово"
            Integer amount = result.get(word);

            // если такого ключа в карте нет - вернется null

            // если вернулся null - присваиваю значению 0
            if (amount == null) {
                amount = 0;
            }

            // увеличиваю значение на 1
            amount = amount + 1;

            //перезаписываю в карту новое соответствие текущему ключу
            result.put(word, amount);
        }
        return result;
    }

    private static Map<String, Integer> frequencyDictionary2(String text) {
        String[] words = text.replaceAll("[^a-zA-Zа-яА-Я ]", "").split("\\s+");

        Map<String, Integer> result = new HashMap<>();

        // перебираю слова
        for (String word : words) {

            // берем из карты значение для ключа слово. Если такого ключа не было - значение устанавливаем = 0
            Integer amount = result.getOrDefault(word, 0);

            result.put(word, ++amount);


        }
        return result;

    }

    private static Map<String, Integer> frequencyDictionary3(String text) {
        String[] words = text.replaceAll("[^a-zA-Zа-яА-Я ]", "").split("\\s+");

        Map<String, Integer> result = new HashMap<>();

        // перебираю слова
        for (String word : words) {

            result.compute(word, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);

        }
        return result;

    }

    private static Map<String, Integer> frequencyDictionary4(String text) {
        String[] words = text.replaceAll("[^a-zA-Zа-яА-Я ]", "").split("\\s+");

        Map<String, Integer> result = new HashMap<>();

        // перебираю слова
        for (String word : words) {

            result.computeIfPresent(word, (k, v) -> v + 1);
            result.computeIfAbsent(word, k -> 1);

        }
        return result;

    }

    private static Map<String, Integer> frequencyDictionary5(String text) {
        String[] words = text.replaceAll("[^a-zA-Zа-яА-Я ]", "").split("\\s+");

        Map<String, Integer> result = new HashMap<>();

        // перебираю слова
        for (String word : words) {

            result.merge(word, 1, (oldValue, value) -> oldValue + 1);


        }
        return result;

    }


}
