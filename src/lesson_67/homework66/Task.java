package lesson_67.homework66;
/*
@date 18.12.2023
@author Sergey Bugaienko
*/

/*
Напишите программу, в которой запускается одновременно два потока.
Один поток 1000 раз увеличивает переменную counter на 1,
а второй поток 1000 раз уменьшает туже переменную на 1.
По завершении работы обоих потоков выведите в консоль значение переменной counter.
Убедитесь, что оно равно 0
 */
public class Task {
    private int counter;

    private synchronized void increment() {
        counter++;
    }

    private synchronized void decrement() {
        counter--;
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    task.increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    task.decrement();
                }
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

        System.out.println("Final value of counter: " + task.counter);

    }

}
