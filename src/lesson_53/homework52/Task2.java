package lesson_53.homework52;
/*
@date 21.11.2023
@author Sergey Bugaienko
*/

import java.util.function.Function;

/*
Создайте цепочку функций, которая
сначала удаляет пробелы из строки, затем преобразует её в верхний регистр, и
в конце считает количество символов в измененной строке
 */
public class Task2 {
    public static void main(String[] args) {
        String string = "Hello, wor ld!";

        Function<String, String> function = string1 -> string1.toUpperCase();
        Function<String, String> function1 = string1 -> string1.replaceAll("\\s+", "");
        Function<String, Integer> function2 = String::length;

        Function<String, Integer>  combinedFunc = function1.andThen(function).andThen(function2);

        System.out.println(combinedFunc.apply(string));
    }
}
