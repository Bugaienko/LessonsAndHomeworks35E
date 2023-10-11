package lesson_24.persons;
/*
@date 09.10.2023
@author Sergey Bugaienko
*/

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println("{" + name + " возраст: " + age + "}");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        // isKind = age < 15; так мы сделать в родителе не можем. Проблема. Надо будет решать
    }
}
