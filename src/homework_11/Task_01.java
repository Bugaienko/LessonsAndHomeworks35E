package homework_11;
/*
@date 20.09.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;

/*
Дан массив целых чисел.
Поменять местами элемент с максимальным и минимальным значением

Пример:

{ 5, 6, -25, 0, 31, -15 }  ->  { 5, 6, 31, 0, -25, -15}
 */
public class Task_01 {
    public static void main(String[] args) {
        int[] numbers = {5, 6, -25, 0, 31, -15 };

        System.out.println(Arrays.toString(numbers));


        int i = 0;
        int min = numbers[0];
        int max = numbers[0];
        int indexMin = 0;
        int indexMax = 0;

        while (i < numbers.length) {
            if (numbers[i] < min) {
                min = numbers[i];
                indexMin = i;
            } else if (numbers[i] > max){
                max = numbers[i];
                indexMax = i;
            }

            i++;
        }

//        numbers[indexMin] = max;
//        numbers[indexMax] = min;

        int temp = numbers[indexMin];
        numbers[indexMin] = numbers[indexMax];
        numbers[indexMax] = temp;

        System.out.println(Arrays.toString(numbers));



    }
}
