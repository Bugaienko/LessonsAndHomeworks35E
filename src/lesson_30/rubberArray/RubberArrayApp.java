package lesson_30.rubberArray;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

public class RubberArrayApp {
    public static void main(String[] args) {
        RubberArray ra = new RubberArray();
        ra.add(10, -5, 16, 57);
        System.out.println(ra);
        ra.remove(16);
        System.out.println(ra);

//        RubberArray<Integer> raInt = new RubberArray<>();
//        RubberArray<String> raStr = new RubberArray<>();
    }
}
