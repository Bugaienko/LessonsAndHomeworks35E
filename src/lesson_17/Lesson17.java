package lesson_17;
/*
@date 27.09.2023
@author Sergey Bugaienko
*/

public class Lesson17 {

    public static void main(String[] args) {

        Cat cat = new Cat(); // создаем объект класса Cat

        cat.sayMeow(); // вызываем метод sayMeow у объекта
        cat.run();
        cat.sleep();

        // При создании объекта класса все его поля
        //инициализируются значениями по умолчанию
        String catName = cat.name;
        System.out.println("Имя " + catName);
        System.out.println("Возраст " + cat.age);
        System.out.println("Цвет: " + cat.color);
        System.out.println("======================");

        // Был создан новый объект класса
        // Имя (строка) которая была передана в конструктор
        // было присвоено полю name
        Cat cat1 = new Cat("Max");
        System.out.println("Имя cat1 " + cat1.name);
        System.out.println("Возраст " +cat1.age);
        System.out.println("Цвет: " + cat1.color);
        cat1.sayMeow();
        cat1.sleep();
        System.out.println("==============");

        Cat cat2 = new Cat("Boris", "red");
        System.out.println("Имя cat2 " + cat2.name);
        System.out.println("Возраст " +cat2.age);
        System.out.println("Цвет: " + cat2.color);
        cat2.sayMeow();
        cat2.run();
        cat2.whoAmI();
        System.out.println("=================");

        Cat cat3 = new Cat("Barsik", "white", 4);
        System.out.println("Имя cat2 " + cat3.name);
        System.out.println("Возраст " + cat3.age);
        System.out.println("Цвет: " + cat3.color);
        cat3.sayMeow();
        cat3.whoAmI();
    }
}
