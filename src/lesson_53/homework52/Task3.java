package lesson_53.homework52;
/*
@date 21.11.2023
@author Sergey Bugaienko
*/

import java.util.function.BiConsumer;

/*
Напишите BiConsumer, который принимает ключ и значение, а затем печатает их в формате "ключ=значение"
 */
public class Task3 {
    public static void main(String[] args) {

        BiConsumer<Integer, String> biConsumer = (key, value) -> System.out.println(key + "=" + value);
        biConsumer.accept(1, "Test");
    }
}
