package lesson_67.multithreading;
/*
@date 18.12.2023
@author Sergey Bugaienko
*/

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {
    // Producer - производитель
    // Consumer - потребитель


    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10); //FIFO (first-in, first-out)
    // put, take

    private static void producer() {
        Random random = new Random();
        while (true) {
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer() {
        while (true) {
            try {
                Thread.sleep(100);
                System.out.println(queue.take());
                System.out.println("size: " + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });

        Thread consumerThread = new Thread(() -> {
            consumer();
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    } //main

}
