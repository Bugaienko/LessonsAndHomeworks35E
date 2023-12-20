package lesson_69.deadLocks;
/*
@date 20.12.2023
@author Sergey Bugaienko
*/

import java.util.Random;

public class DeadLockExample {
    public static void main(String[] args) {
        Runner runner = new Runner();
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

class Runner {
    private final Account account1 = new Account();
    private final Account account2 = new Account();

    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            synchronized (account1) {
                synchronized (account2) {
                    Account.transfer(account1, account2, random.nextInt(101));
                }
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            synchronized (account1) {
                synchronized (account2) {
                    Account.transfer(account2, account1, random.nextInt(101));
                }
            }
        }
    }

    public void finished() {
        System.out.println("Acc1: " + account1.getBalance());
        System.out.println("Acc2: " + account2.getBalance());
        System.out.println("Total: " + (account1.getBalance() + account2.getBalance()));
    }
}


class Account {
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
    public static void transfer(Account account1, Account account2, int amount) {
        account1.withdraw(amount);
        account2.deposit(amount);
    }
}



















