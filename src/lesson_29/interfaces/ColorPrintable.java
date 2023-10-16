package lesson_29.interfaces;
/*
@date 16.10.2023
@author Sergey Bugaienko
*/

public interface ColorPrintable extends Printable {

    void colorPrint();
    // но без строки 11 интерфейс может получить реализацию по умолчанию от Printable
    void test();
}
