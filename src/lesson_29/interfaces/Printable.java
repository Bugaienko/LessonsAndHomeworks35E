package lesson_29.interfaces;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

// public abstract interface Printable {
public interface Printable {
    // Интерфейсы косвенно абстрактны. Нам не нужно использовать ключевое слово abstract. Оно присутствует "по умолчанию"

    // все методы интерфейса косвенно и абстрактные и публичные
    // public abstract
    void print();



    // Начиная c JDK8 доступны методы по умолчанию (имеющие реализацию)
    default void test() {
        System.out.println("Test");
    }

    // Начиная c JDK8 доступны статические методы в интерфейсах
    static void testStatic(String str) {
        System.out.println("Static method print: " + str);
    }
}
