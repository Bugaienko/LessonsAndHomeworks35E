package lesson_29.interfaces;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public class Book implements Printable {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public void print() {
        System.out.printf("Book %s (%s)\n", title, author);
    }
}
