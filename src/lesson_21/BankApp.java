package lesson_21;
/*
@date 04.10.2023
@author Sergey Bugaienko
*/

public class BankApp {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(4856810939019L, "USD", "Ivan Petrov", "SwedBank");

        System.out.println(bankAccount.toString());
        System.out.println(bankAccount.info());

        BankAccount bankAccount1 = new BankAccount(4856845639019L, "EUR", "Ivan Petrov", "SwedBank");

        System.out.println(bankAccount1.toString());

        BankAccount bankAccount2 = new BankAccount(4856878939019L, "USD", "John Smith", "SwedBank");
        System.out.println(bankAccount2.toString());
    }
}
