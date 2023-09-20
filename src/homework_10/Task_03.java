package homework_10;
/*
@date 19.09.2023
@author Sergey Bugaienko
*/

import java.util.Scanner;

/*
Task 3 Программа просит пользователя слово "hello"
Если пользователь вводит правильное слово -
программа распечатывает на экран благодарность и завершает работу

Если вводится не верное слово - программа просит ввести слово снова.
До тех пор, пока не будет введено запрашиваемое слово

*опционально - считать кол-во попыток, которые потребовались пользователю для введения правильного слова

По окончанию - вывести число попыток на экран
 */
public class Task_03 {
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);

        int counter = 0;
        String answer;

        do {
            System.out.println("Введите hello");
            answer = scanner.nextLine().trim();
            counter++;

        } while (!answer.equalsIgnoreCase("hello"));

        System.out.println("Hello! Вы использовали " + counter + " попыток");


    }
}
