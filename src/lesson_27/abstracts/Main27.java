package lesson_27.abstracts;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

public class Main27 {
    public static void main(String[] args) {
        // Ошибка.Не может быть создан объект абстрактного класса
        //Animal animal = new Animal();

        Dog dog = new Dog();
        SuperDog superDog = new SuperDog();
        Cat cat= new Cat();

        dog.move();
        dog.eat();

        cat.eat();
        cat.move();
    }
}
