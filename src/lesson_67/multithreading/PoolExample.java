package lesson_67.multithreading;
/*
@date 18.12.2023
@author Sergey Bugaienko
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2); // Создаем Threads pool  с двумя потоками

        for (int i = 0; i < 7; i++) {
            executorService.submit(new Task(i)); // отправляем в пул 7 задач на выполнение; execute - просто отправляет задачу на выполнение
        }

        System.out.println("Main the main");

        executorService.shutdown(); // После вызова этого метода pool перестает принимать новые.\
        System.out.println("All tasks submitted");

        // отправляем еще одну задачу в пул после метода shutdown
       //  executorService.submit(new Task(10)); // получим java.util.concurrent.RejectedExecutionException

        for (int i = 0; i < 2000; i++) {
            System.out.println(i);
        }

        boolean isFinished = false;
        try {
            isFinished = executorService.awaitTermination(1, TimeUnit.DAYS);
            // Поток в котором вызван метод останавливается (в данном случае main).
            // Если все задачи завершены в течении заданного времени - метод вернет true и поток main продолжит выполнение.
            // Если НЕ все задачи завершены по истечении заданного времени - метод вернет false и поток main продолжит выполнение.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks was completed " + isFinished);
    }
}

class Task implements Runnable {
    private final int taskId;

    Task(int threadId) {
        this.taskId = threadId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " was started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " was completed");
    }
}
