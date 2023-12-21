package lesson_70.homework69;
/*
@date 21.12.2023
@author Sergey Bugaienko
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/*
Task 1: Многопоточный Ресторан

Разработать многопоточное приложение, имитирующее работу ресторана.

Основные требования:

Ограниченное Количество Столов:
В ресторане есть ограниченное количество столов (например, 5 столов).

Прием Заказов:
Каждый посетитель (представленный отдельным потоком) приходит в ресторан и, если есть свободный стол, занимает его.
Если свободных столов нет, посетитель ожидает.
Обработка Заказов:

Каждый заказ требует определенного времени для обработки (например, приготовления блюда). Используйте Thread.sleep() для имитации времени обработки.
Количество одновременно обрабатываемых заказов ограничено (например, кухня может готовить до 3 блюд одновременно).
Статистика:

Подсчитайте общее количество обслуженных посетителей и среднее время обслуживания.

Завершение Работы:
После обслуживания определенного количества посетителей (например, 30) ресторан закрывается, и программа завершает свою работу.
Ожидаемый Результат:

Программа должна корректно симулировать работу ресторана с учетом ограниченного количества столов и одновременно обрабатываемых заказов, вести статистику и корректно завершать свою работу после обслуживания заданного числа посетителей.
 */
public class Restaurant {
    private static final int TABLES = 5;
    private static final int KITCHEN_CAPACITY = 3;
    private static final int CUSTOMERS_COUNT = 30;
    private static Semaphore tableSemaphore = new Semaphore(TABLES, true);
    private static Semaphore kitchenSemaphore = new Semaphore(KITCHEN_CAPACITY, true);
    private static AtomicInteger totalServiceTime = new AtomicInteger();
    private static AtomicInteger totalEatTime = new AtomicInteger();

    public static void main(String[] args) {
        ExecutorService customerPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < CUSTOMERS_COUNT; i++) {
            customerPool.execute(new Customer(i + 1));
        }

        customerPool.shutdown();
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Общее время загрузки кухни: " + totalServiceTime.get());
            System.out.println("Среднее время выполнения одного заказа: " + totalServiceTime.doubleValue() / CUSTOMERS_COUNT);
            System.out.println("Общее время нахождения всех посетителей в ресторане: " + (totalServiceTime.get() + totalEatTime.get()));
            System.out.println("Среднее время нахождение одного посетителя в ресторане: " + ((totalServiceTime.doubleValue() + totalEatTime.get()) / CUSTOMERS_COUNT));
        }));
    }


    public static class Customer implements Runnable {
        private final int id;

        public Customer(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
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
                System.out.println("Посетитель закончил " + id + " есть и покидает столик");

                tableSemaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
