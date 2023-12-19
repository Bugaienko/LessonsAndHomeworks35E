package lesson_68.threads;
/*
@date 19.12.2023
@author Sergey Bugaienko
*/

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
    //Compare And Set
    //Эффективная неблокирующая альтернатива
    //Позволяет обеспечить потокобезопасность без использования блокировок

    /*
    сигнатура compareAndSet для класса AtomicInteger
     public final boolean compareAndSet(int expect, int update);
    expect - значение, которое ожидается в данный момент времени в переменной
     update - новое значение переменной, которое должно быть установленно
    */

    /*
    atomicInteger.get();  // возвращает текущее значение
    atomicInteger.set(10); // устанавливает новое значение
    atomicInteger.getAndSet(15); // устанавливает новое значение и возвращает старое
    atomicInteger.compareAndSet(15, 25); // сравнивает ожидаемое значение с текущим и при совпадении устанавливает новое
    atomicInteger.getAndIncrement(); // возвращает текущее и увеличивает текущее на 1
    atomicInteger.getAndDecrement(); //  возвращает текущее и уменьшает текущее значение на 1
    atomicInteger.getAndAdd(5); // возвращает текущее и увеличивает текущее на delta
    atomicInteger.incrementAndGet(); //сначала увеличивает на 1, потом возвращает новое значение
    atomicInteger.addAndGet(5); // сначала увеличивает на дельту, потом возвращает новое значение
     */

    /*
    ABA-проблема
     */

    public static void main(String[] args) {

        new TestCas().doWork();
    }

}

class TestCas {
    private int counter;
    private AtomicInteger atomicInteger = new AtomicInteger();


    public void increment() {
//        counter++;
        int oldValue;
        do {
            oldValue = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(oldValue, oldValue + 1));

//        atomicInteger.getAndIncrement();


    }

    public void doWork() {
        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
//        System.out.println("Counter: " + counter);
        System.out.println("Counter: " + atomicInteger.get());
        System.out.println("Duration: " + (end - start));
    }
}
