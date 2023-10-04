package lesson_21;
/*
@date 04.10.2023
@author Sergey Bugaienko
*/

public class FinalDemo {

    private final int x = 10; // поля final инициализировано

    private final int[] ints = new int[10];

    private final String name = "Max";

    private int y;
    private double[] doubles;

    public FinalDemo() {
       // x = 15; невозможно присвоить новое значение
       // ints = new int[3]; невозможно изменить ссылку.
        // Но можно изменить состояние объекта (значения в ячейках массива
       ints[0] = 10;
       ints[0] = 100;
       ints[1] = -15;



    }

    public static void main(String[] args) {

    }

    public int getX() {
        return x;
    }

    public int[] getInts() {
        return ints;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double[] getDoubles() {
        return doubles;
    }

    public void setDoubles(double[] doubles) {
        this.doubles = doubles;
    }
}
