package lesson_29.interfaces;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public class Journal implements Printable {
    String name;
    int number;

    public Journal(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void print() {
        System.out.println("Journal: " + name + " #" + number);
    }

    @Override
    public void test() {
        System.out.println("Journal test overload");;
    }
}
