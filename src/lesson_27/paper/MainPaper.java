package lesson_27.paper;
/*
@date 12.10.2023
@author Sergey Bugaienko
*/

public class MainPaper {
    public static void main(String[] args) {

        Brush brush = new Brush();
        Pencil pencil = new Pencil();
        Marker marker = new Marker();
        ColorPencil colorPencil = new ColorPencil();
        Eraser eraser = new Eraser();

        Paper paper = new Paper();

        paper.drawFigure("Квадрат", brush);
        paper.drawFigure("Овал", pencil);
        paper.drawFigure("Треугольник", marker);
        paper.drawFigure("Портрет", colorPencil);
        paper.drawFigure("Треугольник", eraser);
    }
}
