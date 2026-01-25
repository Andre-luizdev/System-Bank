package application;

import entities.Account;
import entities.Client;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("TaxId: ");
        int taxId = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("WithdrawLimit: ");
        double withdrawLimit = sc.nextDouble();

        Client client = new Client(holder, taxId, email);
        Account acc = new Account(number, client, balance, withdrawLimit);

        System.out.println();

        char resp = 'y';

        while (resp == 'y'){
            System.out.print("Choose option: deposit(D) or withdrawal(W) or status(S): ");
            char option = sc.next().charAt(0);
            if (option=='D' || option == 'd'){
                System.out.print("Enter amount for deposit: ");
                double amount = sc.nextDouble();
                try {
                    acc.deposit(amount);
                    System.out.println("Account Owner Data: " + client.toString());
                    System.out.printf("New balance: %.2f%n", acc.getBalance());
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else if (option == 'W' || option == 'w'){
                System.out.print("Enter amount for withdraw: ");
                double amount = sc.nextDouble();

                try {
                    acc.withdraw(amount);
                    System.out.println("Account Owner Data: " + client.toString());
                    System.out.printf("New balance: %.2f%n", acc.getBalance());
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }else if (option == 's' || option=='S'){
                System.out.println("\n--- ACCOUNT STATUS ---");
                System.out.println(client.toString());
                System.out.printf("Current Balance: $%.2f%n", acc.getBalance());
                System.out.printf("Withdraw Limit: $%.2f%n", acc.getWithdrawLimit());
            }else {
                System.out.println("Invalid option!");
            }
            System.out.println();
            System.out.print("Do you want to perform another operation? (y/n): ");
            resp = sc.next().charAt(0);
        }

        System.out.println("Thank you for using our bank!");

    }
}