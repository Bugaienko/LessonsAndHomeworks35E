package homework_08;
/*
@date 18.09.2023
@author Sergey Bugaienko
*/

import java.util.Random;

/*
Task 2 Реализовать с использованием switch Ваш ребенок принес оценку за контрольную работу по математике.
В школе 12 бальная система. Запишите в переменную случайное число от 0 до 12.
Вы разрешаете ребенку смотреть телевизор не более 60 минут в день.
(Оставшееся время не может быть больше 1 часа) На сегодня у него осталось 45 минут. (записать в переменную)

Если оценка
от 10 до 12 баллов -> Скажите ему, как вы рады и добавьте к оставшемуся на сегодня времени 1 час
от 7 до 9 -> Слова похвалы на экран + ко времени 45 минут
от 4 до 6 -> Нейтральные слова + ко времени 15 минут
3 -> Огорчитесь. Минус 30 минут ко времени
оценка меньше -> Трагедия. Сегодня ТВ смотреть запрещено

Выведите на экран оставшееся на сегодня время для просмотра ТВ
 */
public class Task_03 {
    public static void main(String[] args) {

        int note, restTime, maxTime = 60;
        restTime = 45;

        Random random = new Random();

        note = random.nextInt(13);

        System.out.println("Текущая оценка: " + note);

        switch (note) {
            case 12:
            case 11:
            case 10:
                System.out.println("как мы рады");
                restTime += 60;
                break;
            case 9:
            case 8:
            case 7:
                System.out.println("Слова похвалы");
                restTime += 45;
                break;
            case 6:
            case 5:
            case 4:
                System.out.println("Нейтральные слова");
                restTime += 15;
                break;
            case 3:
                System.out.println("Огорчился");
                restTime -=30;
                break;
            case 2:
            case 1:
            case 0:
                System.out.println("Трагедия! Сегодня ТВ смотреть запрещено");
                restTime = 0;
                break;
            default:
                System.out.println("Ребенок, да ты волшебник! Не бывает таких оценок");
        }


        if (restTime > maxTime) {
            restTime = maxTime;
        } else if (restTime < 0) {
            restTime = 0;
        }

        System.out.printf("На сегодня осталось %s минут просмотра телевизора", restTime);

    }
}
