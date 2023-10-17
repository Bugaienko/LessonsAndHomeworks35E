package lesson_30.payments;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

public class ElectronicWallet implements PaymentSystem {
    private double balance;
    private final String currency;
    private String systemTitle;

    private double courseUSD;

    public ElectronicWallet(double balance, String systemTitle) {
        this.balance = balance;
        this.systemTitle = systemTitle;
        this.currency = "BTC";
        this.courseUSD = 30000;
    }


    @Override
    public String toString() {
        return "ElectronicWallet{" +
                "amount=" + balance +
                ", currency='" + currency + '\'' +
                ", systemTitle='" + systemTitle + '\'' +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSystemTitle() {
        return systemTitle;
    }

    public void setSystemTitle(String systemTitle) {
        this.systemTitle = systemTitle;
    }

    public double getCourseUSD() {
        return courseUSD;
    }

    public void setCourseUSD(double courseUSD) {
        this.courseUSD = courseUSD;
    }

    @Override
    public boolean transferMoney(double amount, PaymentSystem recipient) {
        if (amount <= balance) {
            balance -= amount;
            recipient.acceptTransferBTC(amount);
            return true;
        }

        return false;
    }

    @Override
    public boolean withdrawMoney(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public void acceptTransferUSD(double amount) {
        balance += amount / courseUSD;
    }

    @Override
    public void acceptTransferBTC(double amount) {
        balance += amount;
    }
}
