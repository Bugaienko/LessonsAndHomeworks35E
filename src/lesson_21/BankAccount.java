package lesson_21;
/*
@date 04.10.2023
@author Sergey Bugaienko
*/

import java.util.Arrays;

public class BankAccount {
    private final int id;
    private final long accountNumber;
    private double amount;

    private String currency;
    private String owner;
    private int bankBranch;
    private String bank;
    static final int BALLANCEACCOUNT = 2600;

    private static int counter; //можно задать начальное значение = 100000;


    public BankAccount(long accountNumber, String currency, String owner, String bank) {
        //TODO генерация номера счета:
        // баллансовый счет + id клиента + номер счета (х символов) + "код валюты")
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.owner = owner;
        this.bank = bank;
        this.bankBranch = 1;
        this.id = counter++;
        generateAccountNumber();
    }

    private String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(BALLANCEACCOUNT);
        //2600
        //00000 - id
       int[] ints = new int[5];
       int temp = id;
        for (int i = ints.length - 1; i >= 0; i--) {
            int digit = temp % 10;
            ints[i] = digit;

            temp /= 10;
        }
        for (int value: ints) {
            sb.append(value);
        }

        // Преобразование числа в строку заданной длины
        // String strNumberToString = String.format("%05d", id);



        System.out.println(sb.toString());
        return sb.toString();

    }

    public String toString() {
        return "{Account id: " + id + "; amount: " + amount + " " + currency +
                "; owner: " + owner + "; bank: " + bank + "}";
    }

    public String info() {
        StringBuilder sb = new StringBuilder();

        sb.append("{Account id: ").append(id).append("; amount: ").append(amount)
                .append(" ").append(currency).append("; owner: ").append(owner)
                .append("; bank: ").append(bank).append("}");


        return sb.toString();

    }

}
