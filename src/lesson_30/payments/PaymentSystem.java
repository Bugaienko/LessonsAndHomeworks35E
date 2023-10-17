package lesson_30.payments;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

public interface PaymentSystem {

    boolean transferMoney(double amount, PaymentSystem recipient);
    boolean withdrawMoney(double amount);
    double checkBalance();
    void acceptTransferUSD(double amount);
    void acceptTransferBTC(double amount);
}
