package lesson_27.runners;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

/*
Task 1

Напишите иерархию классов человек -> спортсмен-любитель - > спортсмен-профи У человека есть метод бежать.
Обычный человек бежит со скоростью 10 км, любитель 15, профи - 25;

Также у наших спортсменов есть необходимость в отдыхе.
Человек нужен отдых после пробежки 15 минут, любитель 10, профи 5
В методе бежать - вызвать метод,
который будет выводить количество минут,
необходимых для отдыха спортсменам
 */
public class MainRunners {
    public static void main(String[] args) {
        Human human = new Human();
        AmateurRunner amateur = new AmateurRunner();
        ProRunner proRunner = new ProRunner();

        human.run();
        System.out.println("============");
        amateur.run();
        System.out.println("============");
        proRunner.run();
        System.out.println("============");

        Human human1 = new Human(12, 13);
        human1.run();
    }
}
