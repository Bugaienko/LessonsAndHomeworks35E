package lesson_27.paper;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

public class Eraser extends Pen{
    @Override
    public void draw(String figure) {
        System.out.println("Стираю фигуру " + figure);
    }
}
