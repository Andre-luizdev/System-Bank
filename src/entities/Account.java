package entities;

public class Account {

    private int number;
    private Client holder;
    private double balance;
    private double withdrawLimit;

    public Account(){

    }

    public Account(int number, Client holder, double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Client getHolder() {
        return holder;
    }

    public void setHolder(Client holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        if (amount <= 0) {
            throw new RuntimeException("Deposit error: Amount must be positive.");
        }
        balance += amount;
    }

    public void withdraw(double amount){
        if(amount>withdrawLimit){
            throw new RuntimeException("Withdrawal error: The amount exceeds the withdrawal limit.");
        }
        if (amount>balance){
            throw new RuntimeException("Withdrawal error: Insufficient balance.");
        }
        balance -= amount;

    }


}
