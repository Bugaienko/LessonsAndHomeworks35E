package lesson_68.threads;
/*
@date 19.12.2023
@author Sergey Bugaienko
*/

import java.util.concurrent.locks.ReentrantLock;

public class RentalLockExample {
    private ReentrantLock lock = new ReentrantLock();

    private int counter;

    private void increment() {
        counter++;
    }


    public void firstThread() {
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            try {
                counter++;
//            increment();
            } finally {
                lock.unlock();
            }

        }
    }

    public void secondThread() {
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            try {
                counter++;
//                increment();
            } finally {
                lock.unlock();
            }

        }
    }

    public void showCounter() {
        System.out.println("counter: " + counter);
    }

    public static void main(String[] args) {
        RentalLockExample tasks = new RentalLockExample();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                tasks.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                tasks.secondThread();
            }
        });

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tasks.showCounter();
    }
}
