package lesson_68.threads.generator;
/*
@date 19.12.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;
import java.util.stream.IntStream;

public class TestGenerator {
    public static void main(String[] args) {
        GeneratorAtomic generator = new GeneratorAtomic();

        final int generationByThread = 10000; //генераций в одном потоке

        Runnable generationTaskFor = () -> {
            for (int i = 0; i < generationByThread; i++) {
                int current = generator.generate();
                System.out.print(current + " ");
            }
        };

        Runnable generationTask = () -> IntStream.range(0, generationByThread).forEach(i-> {
            int curValue = generator.generate();
            System.out.print(curValue + " ");
        });

        int amountOfGenerationThreads = 5; // кол-во потоков

//        Thread[] threads = createThreads(generationTaskFor, amountOfGenerationThreads); // метод для создания всех потоков
        Thread[] threads = createThreads(generationTask, amountOfGenerationThreads); // метод для создания всех потоков

        //Метод для запуска всех потоков
        startThreads(threads);

        //Надо чтобы main дождался завершения
        // метод для одного потока + метода для массива
        waitUntilFinish(threads);

        int currentValue = generator.getValue();
        System.out.println("current value: " + currentValue);


    }

    private static void startThreads(final Thread[] threads) {
        Arrays.stream(threads)
                .forEach(Thread::start);
    }

    private static Thread[] createThreads(final Runnable task, int amountThreads) {
        return IntStream.range(0, amountThreads)
                .mapToObj(i -> new Thread(task))
                .toArray(Thread[]::new);
    }

    private static void waitUntilFinish(final Thread[] threads) {
        Arrays.stream(threads).forEach(TestGenerator::waitUntilFinish);
    }

    private static void waitUntilFinish(final Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
