package lesson_69.interrupt;
/*
@date 20.12.2023
@author Sergey Bugaienko
*/

import java.util.Random;

public class InterruptExample {
    public static void main(String[] args) {
        /*
        InterruptedException - Это исключение служит сигналом что потоку следует прекратить свою работу (был вызван метод interrupt())
         */

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 2_000_000_000; i++) {
//                    if (Thread.currentThread().isInterrupted()) { // возвращает true, если для этого потока был вызван метод interrupt()
//                        System.out.println("Thread was interrupted!");
//                        break;
//                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted!");
                        break;
                    }

                    Math.sin(random.nextDouble());
                }
            }
        });
        System.out.println("Thread starting");
        thread.start();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Отправляем запрос на прерывание потока");

        thread.interrupt(); // отправляет потоку запрос на прерывание. Устанавливает флаг на прерывание.


        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread has finished");


    }
}
