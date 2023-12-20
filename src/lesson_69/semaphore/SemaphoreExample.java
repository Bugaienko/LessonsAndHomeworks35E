package lesson_69.semaphore;
/*
@date 20.12.2023
@author Sergey Bugaienko
*/

import java.util.concurrent.*;

public class SemaphoreExample {
    public static void main(String[] args) {
        Connection connection = Connection.getConnection();
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        for (int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    connection.doWork();
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Connection {
    private static final Connection connection = new Connection();
    private volatile int connectionCount;

    private final Semaphore semaphore = new Semaphore(10);

    private Connection() {
        //закрытый конструктор. Не доступен вене класса
    }

    public static Connection getConnection() {
        return connection;
    }

    public void doWork() {
        try {
            semaphore.acquire();
            work();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void work() {
        synchronized (this) {
            System.out.println("Connect " + Thread.currentThread().getName());
            connectionCount++;
            System.out.println(connectionCount);
        }

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 6001)); //эмуляция работы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Disconnect " + Thread.currentThread().getName());
        synchronized (this) {
            connectionCount--;
        }

    }
}
