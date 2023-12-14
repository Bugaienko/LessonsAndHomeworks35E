package lesson_66.threads;
/*
@date 14.12.2023
@author Sergey Bugaienko
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test4 {
    public static void main(String[] args) {
        new Worker().go();
    }
}

class Worker {
    Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    final Object lock1 = new Object();
    final Object lock2 = new Object();

    public void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            list1.add(random.nextInt(100));
        }

    }

    public void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list2.add(random.nextInt(100));
        }

    }

    public void work() {
        for (int i = 0; i < 1250; i++) {
            addToList1();
            addToList2();
        }
    }

    public void go() {
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(() -> work());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - start));
        System.out.println("list1: " + list1.size());
        System.out.println("list2: " + list2.size());
    }

    public void goOld() {
        long start = System.currentTimeMillis();

        work();


        long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - start));
        System.out.println("list1: " + list1.size());
        System.out.println("list2: " + list2.size());
    }


}
