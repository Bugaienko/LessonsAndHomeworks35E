package lesson_69.callableFuture;
/*
@date 20.12.2023
@author Sergey Bugaienko
*/

import java.util.Random;
import java.util.concurrent.*;

public class CallableFuture {
    // Callable, Future классы, которые позволяют возвращать значения из потоков и выбрасывать обрабатываемые исключения из потоков

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Staring");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Finished");
//            }
//        });

//        Future<Integer> future = executorService.submit(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                System.out.println("Staring");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Finished");
//                return 5;
//            }
//        });


        Future<Integer> future = executorService.submit(() -> {
            Random random = new Random();
            int res = random.nextInt(101);
            if (res < 50) throw new Exception("Something bad happened");
            return res;
        });

        executorService.shutdown();

        try {
            int result = future.get();
            System.out.println("result: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }
}
