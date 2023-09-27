package lesson_17;
/*
@date 27.09.2023
@author Sergey Bugaienko
*/

public class Cat {
    String name;
    String color;
    int age;

    // конструктор
    public Cat(String catName) {
        name = catName;
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Cat() {
    }

    public void whoAmI() {
        System.out.println("Я котик " + this.name +
                ", мой возраст: " + age +
                ", и мой окрас: " + color);
    }


    void sleep() {
        System.out.println("Я сплю!");
    }

    void sayMeow() {
        System.out.println("Meow!");
    }

    void run() {
        System.out.println("Я бегу!");
    }
}
