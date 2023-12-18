package lesson_67.multithreading;
/*
@date 18.12.2023
@author Sergey Bugaienko
*/

import java.util.Scanner;

public class WaitAndNotify {

    public void producer() {
        synchronized (this) {
            System.out.println("Producer thread started");
            try {
                this.wait();
                // Текущий поток освобождает блокировку объекта (освобождает монитор) и переход в состояние ожидания
                // до тех пор
                //1. Другой поток вызовет на этом объекте метод notify()
                //2. Другой поток вызовет на этом объекте метод notifyAll()
                // Когда поток выходит из состояния ожидания, он пытается снова захватить монитор и продолжить выполнение

                System.out.println("Producer was resumed");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
               // this.notify();

            }

        }
    }

    public void waiter() {
        System.out.println("Waiter Start!");
        synchronized (this) {
            try {
                this.wait();
                System.out.println("Waiter was resumed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //this.notify();
            }


        }
    }

    public void consumer() {
        Scanner scanner = new Scanner(System.in);
        try {
            Thread.sleep(2000); // чтобы поток producer гарантированно первым получил процессорное время
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            try {
                System.out.println("Waiting for Enter pressed");
                scanner.nextLine();
                // обращение к БД
                // добавление в какой-то список. И если здесь Exception, то до строки 65 с notify мы не дойдем.
                // и потоки зависнуть в состоянии wait. Поэтому notify надо вызывать в блоке finally
               // this.notifyAll();

            } finally {
//                this.notify(); // Дает разрешение / сигнал, (пробуждает) что только один из ожидающих потоков может продолжить работу. Выбор потока происходит произвольно
                 this.notifyAll(); // Пробуждает абсолютно все потоки
            }

            try {
                Thread.sleep(2000);
                System.out.println("Consumer was ended");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitAndNotify.producer();
            }
        });

        Thread thread2 = new Thread(waitAndNotify::consumer);

        Thread thread3 = new Thread(waitAndNotify::waiter);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


