package homework_06;
/*
@date 13.09.2023
@author Sergey Bugaienko
*/

import java.util.Scanner;

/*
Task 00

Создайте переменную типа int.
Получите произвольное значение переменной из консоли (используем Scanner)
Выведите строку в формате:
Число: 6 четное: true; кратно 3: true; четное и кратное 3: true
Число: 3 четное: false, кратно 3: true, четное и кратное 3: false

(опционально) - учесть, что случайное число может оказаться 0
 */
public class HW06_Task_01 {
    public static void main(String[] args) {
        int userInput;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число: ");
        userInput = scanner.nextInt();

        //                0 !== 0
        //                4 != 0
        boolean isEven = (userInput != 0) && (userInput % 2 == 0);
        boolean isDevByThree = (userInput != 0) && (userInput % 3 == 0);

        System.out.println("Число: " + userInput + " четное: " + isEven + "; кратно 3: " + isDevByThree +
                "; четное и кратное 3: " + (isEven && isDevByThree));

        System.out.println("========== TASK 2 ===============");
        /*
        () -> ! -> & -> ^ -> | -> && -> ||
        */

        System.out.println((true | false) | (45 < 70) & !(true) ^ (6 == 5));
        System.out.println((true | false) | (true) & !(true) ^ (false));
        System.out.println((true) | (true) & !(true) ^ (false));
        System.out.println((true) | (true) & false ^ (false));
        System.out.println((true) | false ^ (false));
        System.out.println((true) | false);
        System.out.println(true);

    }
}
