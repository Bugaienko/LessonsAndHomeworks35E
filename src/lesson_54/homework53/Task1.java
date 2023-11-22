package lesson_54.homework53;
/*
@date 22.11.2023
@author Sergey Bugaienko
*/

import java.util.List;
import java.util.stream.Collectors;

/*
Дан список строк. Используя Stream API,
отфильтруйте строки, которые начинаются на определенную букву (например, "A"),
удалите дубликаты и
отсортируйте их в алфавитном порядке.
 */
public class Task1 {
    public static void main(String[] args) {
        List<String> strings = List.of("test", "Abba", "Arrow", "Java", "A");

        List<String> filteredString = strings.stream()
                .filter(str -> str.startsWith("A"))
//                .filter(str2 -> str2.charAt(0) == 'A')
//                .filter(str1 -> str1.substring(0, 1).equals("A"))
//                .filter(str -> str.endsWith("a")) // проверка заканчивается ли строка на "a"
//                .filter(str -> str.contains("a")) // проверка содержит ли строка подстроку "а"
                .sorted()
                .collect(Collectors.toList());

        System.out.println(filteredString);

    }
}
