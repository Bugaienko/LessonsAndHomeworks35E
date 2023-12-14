package lesson_66.threads;
/*
@date 14.12.2023
@author Sergey Bugaienko
*/

public class Test {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread();
            thread.setName("Thread-" + i);
            thread.start(); // непосредственно создает поток и автоматически в этом потоке запускает метод run
//            thread.start(); // Одноразовое использование. Каждый экземпляр Thread можно стартовать только один рах
        }

        System.out.println("Main going to sleep");

        Thread.sleep(4000);

        System.out.println("Hello from main! I am awake");
        System.out.println("currentThreadName: " + Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Запущен поток: " + getName()); //код, который будет выполняться в потоке
    }
}
