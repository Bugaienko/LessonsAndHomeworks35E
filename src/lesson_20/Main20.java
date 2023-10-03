package lesson_20;
/*
@date 02.10.2023
@author Sergey Bugaienko
*/

public class Main20 {
    public static void main(String[] args) {

        Cat cat = new Cat("Gennadiy", 4, 10);
        // cat.sayMeow();

//        cat.age = 100;
//        cat.weight = -10;
//        cat.setName("Boris");
        cat.setAge(100); // проверка в сеттере не пройдена - значение не будет присвоено полю
        cat.setAge(5); // значение прошло проверку. Будет присвоено полю
        cat.setWeight(20);





        System.out.println("Имя: " + cat.getName());
        System.out.println("возраст: " + cat.getAge());
        System.out.println("Вес: " + cat.getWeight());

    }

}
