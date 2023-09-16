package lesson_08;
/*
@date 14.09.2023
@author Sergey Bugaienko
*/

import java.util.Random;
import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {

        int x = 35;

        if (x == 5) {
            System.out.println("if: x равен 5");
        } else if (x == 7) {
            System.out.println("if: x равен 7");
        } else {
            System.out.println("if: Что-то другое");
        }

        //
        switch (x) {
            case 5:
                System.out.println("switch: x равен 5");
                break;
            case 7:
                System.out.println("switch: x равен 7");
                break;
            case 9:
                System.out.println("switch: x равен 9");
            default:
                System.out.println("switch: Что-то другое");
            case 11:
                System.out.println("11");
        }


        /*
        У ребенка есть карманные деньги. Допустим 100 денег.
        Ребенок получил оценку в школе. (от 1 до 5)
        за хорошие оценки получает деньги, за плохие отбирают
            5 -> + 20
            4 -> 10
            3 -> 0;
            2 -> - 20
            1 -> все
         */
        Random random = new Random();

        int money = 100;
        int note = random.nextInt(5) + 1; // генерируем случайное число от 1 до 5 включительно

        System.out.println("Ребенок получил оценку: " + note);

//         Java code v. before 12
        switch (note) {
            case 5:
                money += 20;
                break;
            case 4:
            case 6:  //if (note == 4 || note ==6)
                money += 10;
               break;
            case 2:
                money -= 20;
                break;
            case 1:
                money = 0;

        }

        // Java 14 and higher
//        money = switch (note) {
//            case 5 -> money + 20;
//            case 4 -> money + 10;
//            case 2 -> money - 20;
//            case 1, 3, 7 -> 0;
//            default -> money;
//        };

        System.out.println("У ребенка теперь: " + money + " денег");


        System.out.println("У меня есть загадка:");
        System.out.println("Что это такое: желтый, большой, с рогами и полный зайцев?");
        System.out.println("Как думаешь?");


        Scanner scanner = new Scanner(System.in);

        String answer = scanner.nextLine();

        // троллейбус = Троллейбус = троллейбус! -> Троллейбус!-> Молодец! Угадал!
        // сдаюсь = Сдаюсь = сдаюсь! -> Быстро ты сдался :( Правильный ответ троллейбус
        // Ответ не верный, попробуй еще раз!
        // Надо считать количество сделанных попыток.



        String answerClean = answer.trim().toLowerCase();

        switch (answerClean) {
            case "троллейбус":
            case "троллейбус!":
                System.out.println("Молодец! Угадал!");
                break;
            case "сдаюсь":
            case "сдаюсь!":
                System.out.println("Быстро ты сдался :( Правильный ответ троллейбус");
                break;
            default:
                System.out.println("Ответ не верный, попробуй еще раз!");
        }

        /*
           Наша программа должна уметь расшифровывать короткие имена валют.
           USD - доллар США
           CHF - швейцарский франк
           EUR - евро
           PLN - польский злотый
           CZK - чешская крона.

           Пользователь вводит короткое имя валюты - программа выдает полное имя, предварительно сохранив его в переменную.
         */



    }
}
