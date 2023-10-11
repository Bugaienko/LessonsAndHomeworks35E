package lesson_26.animals;
/*
@date 11.10.2023
@author Sergey Bugaienko
*/

public class MainEquals {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog dog1 = new Dog();

        Cat cat = new Cat();

        System.out.println(dog);
        System.out.println(dog1);

        System.out.println(dog == dog1);
        System.out.println(dog.equals(dog1));

        dog1.setName("max");
        System.out.println(dog.equals(dog1));

        System.out.println(dog.equals(cat));

        SuperDog superDog = new SuperDog();
        SuperDog superDog1 = new SuperDog();
        System.out.println(superDog);
        System.out.println(superDog.equals(superDog1));

        String s = "fd";
        System.out.println(s.equals(cat));

    }
}
