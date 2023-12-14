package lesson_66.threads;
/*
@date 14.12.2023
@author Sergey Bugaienko
*/

public class Synchro3 {
    private int counter;

//    private synchronized void increment() {
//        counter++;
//    }

    private void increment() {
        synchronized (this) {
            counter++;
        }
    }

    public void doWork() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
//                    counter = counter + 1; // counter++;
                    // 1; 2;
                    // 0 + 1 -> 1; 1 + 1-> 2 // 1 +1 = 2

                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
                //                counter = counter + 1;
                //1
                // 1 + 1 -> 1 //
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

        System.out.println("counter: " + counter);

    }
}
