package lesson_30.generics;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

public class GenericsApp {
    public static void main(String[] args) {
        SimpleBox box = new SimpleBox(10);
        System.out.println(box);
        SimpleBox box1 = new SimpleBox(20);

        SimpleBox box2 = new SimpleBox("30");

        int sum = (int)box.getValue() + (int)box1.getValue();
        System.out.println(sum);

        SimpleBox[] boxes = new SimpleBox[3];
        boxes[0] = box;
        boxes[1] = box1;
        boxes[2] = box2;

        int sum1 = 0;
        for (int i = 0; i < boxes.length; i++) {

           // получим java.lang.ClassCastException при невозможности преобразовать Object в int
            sum1 += (int) boxes[i].getValue();
        }

        System.out.println(sum1);
    }
}
