package lesson_66.threads;
/*
@date 14.12.2023
@author Sergey Bugaienko
*/

public class Test1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runner());
        thread.start();

        System.out.println("Main was here");
    }
}

class Runner implements Runnable {
    @Override
    public void run() { // в методе run мы пишем код, который будет выполняться в новом потоке
        for (int i = 0; i < 200; i++) {
            System.out.println("Hello from Thread " + Thread.currentThread().getName()  + " : " + i);
        }
    }
}
