package com.thread;

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account();

        Customer customer1 = new Customer(acct,"甲");
        Customer customer2 = new Customer(acct,"乙");

        customer1.start();
        customer2.start();
    }
}

class Customer extends Thread{
    private Account acct;
    public Customer(){

    }
    public Customer(Account acct,String name){
        super(name);
        this.acct = acct;
    }
    public void run(){
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

class Account{
    private double balance;

    public void deposit(double amt){
        synchronized (Account.class){
            if(amt > 0){
                balance += amt;
                System.out.println(Thread.currentThread().getName() + "存钱。账户余额为：" + balance);
            }
        }
    }
}