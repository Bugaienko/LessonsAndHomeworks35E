package lesson_67.multithreading;
/*
@date 18.12.2023
@author Sergey Bugaienko
*/

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerWaitNotify {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList<>();
    private final static int LIMIT = 10;
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while (value < 101) {
            synchronized (lock) {
                while (queue.size() == LIMIT) {
                    lock.wait();
                }
                queue.add(value++);
                lock.notify();
            }
            Thread.sleep(100);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.isEmpty()) {
                    lock.wait();
                }
                Integer currentValue = queue.poll(); // взял и освободил 1 место
                System.out.println(currentValue);
                System.out.println("Queue  size: " + queue.size());
                lock.notify();
            }
//            Thread.sleep(200);
        }

    }
}
