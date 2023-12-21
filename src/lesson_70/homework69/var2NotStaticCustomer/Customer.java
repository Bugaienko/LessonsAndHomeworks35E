package lesson_70.homework69.var2NotStaticCustomer;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer implements Runnable {
    private final int id;
    private final Semaphore tableSemaphore;
    private final Semaphore kitchenSemaphore;
    private final AtomicInteger totalServiceTime;
    private final AtomicInteger totalEatTime;
    private final AtomicInteger totalCustomers;

    public Customer(int id, Semaphore tableSemaphore, Semaphore kitchenSemaphore, AtomicInteger totalServiceTime, AtomicInteger totalEatTime, AtomicInteger totalCustomers) {
        this.id = id;
        this.tableSemaphore = tableSemaphore;
        this.kitchenSemaphore = kitchenSemaphore;
        this.totalServiceTime = totalServiceTime;
        this.totalEatTime = totalEatTime;
        this.totalCustomers = totalCustomers;
    }

    @Override
    public void run() {
        try {
            //if (Thread.currentThread().isInterrupted()) return;
            System.out.println("Посетитель " + id + " зашел в ресторан");
            tableSemaphore.acquire(); // взятие столика
            System.out.println("Посетитель " + id + " сел за столик");

            kitchenSemaphore.acquire();
            int serviceTime = ThreadLocalRandom.current().nextInt(1000, 5001);
            System.out.println("Посетитель " + id + " сделал заказ (" + serviceTime + ")");
            Thread.sleep(serviceTime);

            totalServiceTime.addAndGet(serviceTime); // накапливаем общее время обслуживания
            System.out.println("Заказ для посетителя " + id + " выполнен");
            kitchenSemaphore.release(); // освобождаем место для заказа на кухне

            int eatingTime = ThreadLocalRandom.current().nextInt(1500, 3001);
            Thread.sleep(eatingTime);

            totalEatTime.addAndGet(eatingTime);
            totalCustomers.getAndIncrement();
            System.out.println("Посетитель закончил " + id + " есть и покидает столик");

            tableSemaphore.release();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
            return;
        }
    }
}