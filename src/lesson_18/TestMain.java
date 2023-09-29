package lesson_18;
/*
@date 29.09.2023
@author Sergey Bugaienko
*/

public class TestMain {
    public static void main(String[] args) {
        RubberArray rubberArray = new RubberArray();

        rubberArray.add(1, 2, 3, 4, 5, 6, 7);
        System.out.println(rubberArray.toString());

        rubberArray.trim();
        rubberArray.removeByIndex(3);

    }
}
