package homework_10;

/*
@date 19.09.2023
@author Sergey Bugaienko
*/
/*
Task 2 Распечатать только 7 чисел от 1 до 100, которые делятся на 5 без остатка.
Используем цикл while
 */
public class Task_02 {
    /*
    1. Берем первое число
    2. Проверить, делится ли число на 5 без остатка
        2.1. Если делится -> Записать +1 к количеству искомых чисел
        2.2. Берем следующее число

     */

    public static void main(String[] args) {

        int countNumber = 0;

        int i = 1;
        while (i <= 100 && countNumber < 7) {  // true && true

            if (i % 5 == 0) {
                countNumber = countNumber + 1;
                System.out.print(i + "; ");
            }

            i++;
        }
        System.out.println("\nКол-во чисел: " + countNumber);
    }
}
