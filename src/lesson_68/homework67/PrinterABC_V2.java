package lesson_68.homework67;
/*
@date 19.12.2023
@author Sergey Bugaienko
*/

public class PrinterABC_V2 {

    private final Object lock = new Object();
    private final Status[] statuses = Status.values();
    private volatile Status status = statuses[0];
    private static final int LETTERS_COUNT = 20;

    public static void main(String[] args) {
        PrinterABC_V2 printer = new PrinterABC_V2();
        Thread threadA = new Thread(() -> printer.print("A"));
        Thread threadB = new Thread(() -> printer.print("B"));
        Thread threadC = new Thread(() -> printer.print("C"));
        Thread threadD = new Thread(() -> printer.print("D"));

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    private void print(String text) {
        System.out.println("Thread with " + text + " was started");
        Status currentStatus;
        try {
            currentStatus = Enum.valueOf(Status.class, text);
        } catch (IllegalArgumentException e) {
//            System.out.print("<Error enum parse " + text + ">");
            return;
        }

        for (int i = 0; i < LETTERS_COUNT; i++) {
            synchronized (lock) {
                while (currentStatus != status) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.print(currentStatus);
                    switchNextStatus(currentStatus);
                } finally {
                    lock.notifyAll();
                }
            }
        }

    }

    private void switchNextStatus(Status currentStatus) {
        // 1 + 1 = (2 % 3) -> 2. 2 + 1 -> (3) % 3 -> 0
        int nextIndex = (currentStatus.ordinal() + 1) % statuses.length;
        status = statuses[nextIndex];
    }
}
