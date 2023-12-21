package lesson_70.homework69.var2NotStaticCustomer;
/*
@date 21.12.2023
@author Sergey Bugaienko
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
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
    private final Semaphore tableSemaphore = new Semaphore(TABLES, true);
    private final Semaphore kitchenSemaphore = new Semaphore(KITCHEN_CAPACITY, true);
    private final AtomicInteger totalServiceTime = new AtomicInteger();
    private final AtomicInteger totalEatTime = new AtomicInteger();
    private final AtomicInteger totalCustomers = new AtomicInteger();

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        ExecutorService customerPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < CUSTOMERS_COUNT; i++) {
            customerPool.execute(new Customer(i + 1,
                    restaurant.tableSemaphore, restaurant.kitchenSemaphore,
                    restaurant.totalServiceTime, restaurant.totalEatTime, restaurant.totalCustomers));
        }

        hookInit(restaurant);
        customerPool.shutdown();
    }

    private static void hookInit(Restaurant restaurant) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Общее время загрузки кухни: " +  restaurant.totalServiceTime.get());
            System.out.println("Среднее время выполнения одного заказа: " + restaurant.totalServiceTime.doubleValue() / restaurant.totalCustomers.get());
            System.out.println("Общее время нахождения всех посетителей в ресторане: " + (restaurant.totalServiceTime.get() + restaurant.totalEatTime.get()));
            System.out.println("Общее количество  обслуженных посетителей: " + restaurant.totalCustomers.get());
            System.out.println("Среднее время нахождение одного посетителя в ресторане: " + ((restaurant.totalServiceTime.doubleValue() + restaurant.totalEatTime.get()) / restaurant.totalCustomers.get()));
        }));
    }
}
