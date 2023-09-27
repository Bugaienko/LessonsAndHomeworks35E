package lesson_17;
/*
@date 27.09.2023
@author Sergey Bugaienko
*/

public class Dog {
    String name;
    int weight;

    public Dog(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    void eat() {
        System.out.println("Я ем! Вкусно...");
        weight++;
    }

    void run() {

        while (weight < 3) {
            System.out.println("Сорян! Я слишком худая и голодная." +
                    "Бежать не могу");
            System.out.println("Надо поесть! Мой вес сейчас: " + weight);
            eat();
        }
        System.out.println("Я бегу!");
        weight -= 2;
    }


    String whoAmI() {
        return "I am dog: " + name + " my weight: " + weight;
    }
}
