package lesson_26.animals;
/*
@date 11.10.2023
@author Sergey Bugaienko
*/

public class Animal {
    private static int counter;

    public Animal(String str) {
        counter++;
    }
    public Animal() {
    counter++;
    }

    public static int getTotalAmount() {
        return counter;
    }
    public void sound() {
        System.out.println("Animal say Hello");
    }
    public void sound(String string) {
        System.out.println("Animal say: " + string);
    }
}
