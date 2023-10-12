package lesson_27.abstracts;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

public class Dog extends Animal{



    @Override
    public void move() {
        System.out.println("Dog двигается");
    }


    @Override
    void eat()  {

    }

    @Override
    public void sayHello() {
        System.out.println("Hello from Dog");
    }
}
