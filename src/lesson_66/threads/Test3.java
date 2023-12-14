package lesson_66.threads;
/*
@date 14.12.2023
@author Sergey Bugaienko
*/

public class Test3 {
    public static void main(String[] args) {
        Synchro3 task = new Synchro3();
        task.doWork();

        System.out.println("Main done");
    }
}
