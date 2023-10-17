package lesson_30.payments;
/*
@date 17.10.2023
@author Sergey Bugaienko
*/

public class BankAccount implements PaymentSystem {
    private double balance;
    private String bankName;
    private final String accountNumber;
    private final String currency;
    private double courseBTC;

    public BankAccount(double balance, String bankName, String accountNumber) {
        this.balance = balance;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.currency = "USD";
        this.courseBTC = 30000;
    }



    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", bankName='" + bankName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public double getCourseBTC() {
        return courseBTC;
    }

    public void setCourseBTC(double courseBTC) {
        this.courseBTC = courseBTC;
    }

    @Override
    public boolean transferMoney(double amount, PaymentSystem recipient) {
        if (amount <= balance) {
            balance -= amount;
            recipient.acceptTransferUSD(amount);
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
        balance += amount;
    }

    @Override
    public void acceptTransferBTC(double amount) {
        balance += amount * courseBTC;
    }
}
