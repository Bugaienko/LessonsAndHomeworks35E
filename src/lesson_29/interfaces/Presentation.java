package lesson_29.interfaces;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public class Presentation implements ColorPrintable {
    String title;
    String author;
    String Theme;
    int amountPages;

    public Presentation(String title, String author, String theme, int amountPages) {
        this.title = title;
        this.author = author;
        Theme = theme;
        this.amountPages = amountPages;
    }

    @Override
    public void colorPrint() {
        System.out.println("Отправляю презентацию в типографию!");
        System.out.println("Presentation by " + author + "; title: " + title);
    }

    @Override
    public void test() {
        System.out.println("Print with red TEST!");
    }

    @Override
    public void print() {
        System.out.println("Presentation " + title + " (pages:" + amountPages + ")");
    }

    @Override
    public String toString() {
        return "Presentation{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", Theme='" + Theme + '\'' +
                ", amountPages=" + amountPages +
                '}';
    }
}
