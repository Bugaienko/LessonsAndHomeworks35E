package lesson_55.homework54;

import java.util.Comparator;
import java.util.List;

/*
@date 23.11.2023
@author Sergey Bugaienko
*/
/*
Из списка целых чисел выделите те значения, которые больше 10;
отсортируйте эти значения по значению последней цифры в числе и выведите результат на экране
 */
public class Task1 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(9, 17, 11, 22, 5, 34, 55, 101, 204);

        integers.stream()
                .filter(i -> i > 10)
//                .sorted((i1, i2) -> (i1 % 10) - (i2 % 10))
                .sorted(Comparator.comparingInt(i -> i % 10))
                .forEach(i -> System.out.print(i + "; "));
        System.out.println();
    }
}
