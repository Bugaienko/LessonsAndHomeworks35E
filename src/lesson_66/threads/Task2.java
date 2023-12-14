package lesson_66.threads;
/*
@date 14.12.2023
@author Sergey Bugaienko
*/

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        thread1.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        thread1.stopWorking();
        System.out.println("Hello from Main");
    }
}

class MyThread1 extends Thread {
    private volatile boolean isRun = true;
    @Override
    public void run() {
        while (isRun) {
            System.out.println("Hello");
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stopWorking() {
        isRun = false;
    }
}
