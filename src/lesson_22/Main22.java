package lesson_22;
/*
@date 05.10.2023
@author Sergey Bugaienko
*/

public class Main22 {
    public static void main(String[] args) {


        System.out.println("Общее кол-во прыжков всех собак: " + Dog.getTotalJumpCounter());

        Dog dog = new Dog("Max", 88);

        Dog dog1 = new Dog("Fred", 100);

        dog.takeBarrier(100);
        dog1.takeBarrier(150);

        System.out.println("Общее кол-во прыжков всех собак: " + Dog.getTotalJumpCounter());
        System.out.println("=============================\n");

        Employee employee = new Employee("Vasya Pupkin", 25, 1500);
        Employee employee1 = new Employee("Maria Petrova", 24, 2500);
        Employee employee2 = new Employee("Gennadiy Popov", 45, 1000);

        employee.info();
        employee1.info();
        employee2.info();

    }

}
