package lesson_68.threads.generator;
/*
@date 19.12.2023
@author Sergey Bugaienko
*/

import java.util.concurrent.atomic.AtomicInteger;

public class GeneratorAtomic {
    private final AtomicInteger value = new AtomicInteger();
    private static final int DELTA = 2;

    public int generate() {
        return this.value.getAndAdd(DELTA); // атомарно прибавляет дельту и возвращает старое значение
    }

    public int getValue() {
        return this.value.intValue(); // возвращает целочисленное значение
    }
}
