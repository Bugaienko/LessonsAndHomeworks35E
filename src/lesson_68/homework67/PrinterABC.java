package lesson_68.homework67;
/*
@date 19.12.2023
@author Sergey Bugaienko
*/

/*
Разработать многопоточное приложение, где
три различных потока печатают три разные буквы (например, 'A', 'B', 'C') в строгом порядке ABC по 20 раз.

Создайте три потока - Каждый поток отвечает за печать определенной буквы ('A', 'B' или 'C'). -
Все три потока запускаются одновременно.

Синхронизация печати:
- Необходимо синхронизировать потоки таким образом, чтобы они печатали свои буквы в последовательности ABC.
То есть, сначала печатается 'A', затем 'B', затем 'C', и цикл повторяется. - Последовательность ABC должна повториться 20 раз.
 */
public class PrinterABC {
    private final static int LETTERS_COUNT = 20;
    private volatile int status = 0;

    private final Object lock = new Object();

    public static void main(String[] args) {
        PrinterABC printer = new PrinterABC();

        Thread threadA = new Thread(printer::printA);
        Thread threadB = new Thread(printer::printB);
        Thread threadC = new Thread(printer::printC);

        threadA.start();
        threadB.start();
        threadC.start();


    }

    private void printA() {
        for (int i = 0; i < LETTERS_COUNT; i++) {
            synchronized (lock) {
                while (status != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.print("A");
                    status = 1;
                } finally {
                    lock.notifyAll();
                }
            }
        }
    }

    private void printB() {
        for (int i = 0; i < LETTERS_COUNT; i++) {
            synchronized (lock) {
                while (status != 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.print("B");
                    status = 2;
                } finally {
                    lock.notifyAll();
                }
            }
        }
    }

    private void printC() {
        for (int i = 0; i < LETTERS_COUNT; i++) {
            synchronized (lock) {
                while (status != 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.print("C");
                    status = 0;
                } finally {
                    lock.notifyAll();
                }
            }
        }
    }


}
