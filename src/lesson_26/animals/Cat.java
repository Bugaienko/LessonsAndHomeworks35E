package lesson_26.animals;
/*
@date 11.10.2023
@author Sergey Bugaienko
*/

public class Cat extends Animal {

    public Cat(){
         super("Fgfgff");
    }

    @Override
    public void sound(){
        System.out.println("Cat say Meow!");
    }

    public void sayHello() {
        System.out.println("Hello from Cat");
    }
}
