package lesson_68.threads;
/*
@date 19.12.2023
@author Sergey Bugaienko
*/

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {


    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatch));
        }

        try {
            countDownLatch.await(); // заблокировали поток main, до тех пор, пока счетчик CountDownLatch не станет равен 0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        System.out.println("Main was resumed");
    }
}

class Processor implements Runnable {

    private final CountDownLatch latch;

    Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread start");
        try {
            Random random = new Random();
            int timeSleep = 2000 + random.nextInt(1000);
            Thread.sleep(timeSleep);
            latch.countDown(); // С каждым вызовом метода countDown счетчик защелки уменьшается на 1.
            System.out.println(latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
