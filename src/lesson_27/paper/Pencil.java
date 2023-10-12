package lesson_27.paper;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

public class Pencil extends Pen{
    @Override
    public void draw(String figure) {
        System.out.println("Рисую карандашом " + figure);
    }
}
