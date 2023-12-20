package lesson_69.deadLocks;
/*
@date 20.12.2023
@author Sergey Bugaienko
*/

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExampleRental {
    public static void main(String[] args) {
        RunnerR runner = new RunnerR();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
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

        //состояние счетов по завершению работы потоков
        runner.finished();

    }
}

class RunnerR {
    private final AccountR account1 = new AccountR();
    private final AccountR account2 = new AccountR();

    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    private void takeLocks(ReentrantLock lock1, ReentrantLock lock2) {
        // tryLock - пытается захватить блокировку. В случае успеха возвращает true. Если не получилось взять - вернет false
        boolean isFirstTaken = false;
        boolean isSecondTaken = false;

        while (true) {
            try {
                isFirstTaken = lock1.tryLock();
                isSecondTaken = lock2.tryLock();
            } finally {
                if (isFirstTaken && isSecondTaken) return;
                // если мы здесь - значит как минимум одна блокировка не взята
                if (isFirstTaken) lock1.unlock();
                if (isSecondTaken) lock2.unlock();
            }

            try {
                Thread.sleep(10); // чтобы дать другим потокам время отдать локи
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock1, lock2);
            try {
                AccountR.transfer(account1, account2, random.nextInt(101));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock2, lock1);
            try {
                AccountR.transfer(account2, account1, random.nextInt(101));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Acc1: " + account1.getBalance());
        System.out.println("Acc2: " + account2.getBalance());
        System.out.println("Total: " + (account1.getBalance() + account2.getBalance()));
    }
}

class AccountR {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    // Перевести деньги с одного счета на другой
    public static void transfer(AccountR account1, AccountR account2, int amount) {
        account1.withdraw(amount);
        account2.deposit(amount);
    }
}



















