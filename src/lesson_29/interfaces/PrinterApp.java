package lesson_29.interfaces;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public class PrinterApp {
    public static void main(String[] args) {
        Printable book = new Book("Философия Java", "Б.Эkkель");
        Printable journal = new Journal("Cosmopolitan", 154);

        Book book1 = new Book("Мастер и Маргарита", "М.Булгаков");


        book.print();
        journal.print();
        book1.print();
        book.test();
        journal.test();

        Printable.testStatic("Hello");

        Presentation presentation =
                new Presentation("Inheritance", "Noname", "Inheritance in OOP", 20);

        presentation.print();
        presentation.colorPrint();
        presentation.test();

    }
}
