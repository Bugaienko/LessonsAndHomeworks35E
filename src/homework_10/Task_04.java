package homework_10;
/*
@date 19.09.2023
@author Sergey Bugaienko
*/

import java.util.Scanner;

/*
Программа просит пользователя ввести произвольное число.
Вывести сумму цифр этого числа
 */
public class Task_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");

        int number = scanner.nextInt();

        int sum = 0;

        if (number < 0) number *= -1;


        String numberStr = String.valueOf(number);

        // 12345 -> 5 + 1234; -> 4 + 123 -> 3 + 12 -> 2 + 1;  1 + 0;

        while (number > 0) {
            int digit = number % 10;
            System.out.print(digit + ((number > 10) ? " + " : " = "));
            sum += digit;
            number = number / 10;
        }

        System.out.println(sum);


        int strIter = 0;
        int sum1 = 0;

        //1025

        while (strIter < numberStr.length()) {
//            System.out.println(numberStr.charAt(strIter));
            int digit = numberStr.charAt(strIter) - 48;
            sum1 = sum1 + digit;
            System.out.print(digit + ((strIter < numberStr.length() -1 ) ? " + " : " = "));
            strIter++;
        }

        System.out.println(sum1);


    }
}
