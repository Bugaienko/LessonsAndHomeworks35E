package lesson_27.abstracts;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

public class Cat extends Animal {
    @Override
    void move() {
        System.out.println("Кот передвигается");
    }

    @Override
    void eat() {
        System.out.println("Кот очень любит кушать!!! ");
    }
}
