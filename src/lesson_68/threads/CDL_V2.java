package lesson_68.threads;
/*
@date 19.12.2023
@author Sergey Bugaienko
*/

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class CDL_V2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor2(countDownLatch));
        }
        executorService.shutdown();

        for (int i = 0; i < 3; i++) {
            int sleepTime = ThreadLocalRandom.current().nextInt(1000, 2500); // генерация случайного числа от 1000 до 2499
            Thread.sleep(sleepTime);
            System.out.println(i);
            countDownLatch.countDown(); // уменьшает счетчик на 1.
        }

        System.out.println("Main finished");
    }
}

class Processor2 implements Runnable {
    private final CountDownLatch latch;

    Processor2(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread "  + Thread.currentThread().getName() + " was started");
            latch.await(); // поток остановится, и будет ждать, пока счетчик защелки будет равен 0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " processed!");
    }
}
