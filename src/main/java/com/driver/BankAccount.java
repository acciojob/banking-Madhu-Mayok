package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
    this.name = name;
    this.balance = balance;
    this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (sum > 9 * digits)
            throw new AccountNumberCanNotBeGeneratedException("Account Number can not be generated");

        StringBuilder sb = new StringBuilder();
        for (int i = digits - 1; i >= 0; i--) {
            if (sum >= 9) {
                sb.append('9');
                sum -= 9;
            } else if (sum <= 9 && sum > 1) {
                sb.append(sum - 1);
                sum -= sum - 1;
            } else if (sum == 1 && i != 0) {
                sb.append(0);
            } else sb.append(sum);
        }
        sb.reverse();
        return sb.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance < amount)
            throw new InsufficientBalanceException("Insufficient Balance");
        else
        {
            this.balance -= amount;
        }
    }

}