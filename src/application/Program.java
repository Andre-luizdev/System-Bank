package application;

import entities.Account;
import entities.Bank;
import services.RegisterService;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        Account acc = null;

        int masterOption = 0;

        while (masterOption != 3) {
            System.out.println();
            System.out.println("--- GLOBAL BANK SYSTEM ---");
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");
            masterOption = sc.nextInt();
            if (masterOption == 1) {
                acc = RegisterService.createAccount(sc);
                bank.addAccount(acc);
            } else if (masterOption == 2) {
                System.out.print("Enter the account number: ");
                int num = sc.nextInt();
                acc = bank.findAccount(num);
                if (acc == null) {
                    System.out.println("Account not found!");
                }

            } if (masterOption != 3 && acc != null) {
                char resp = 'y';

                while (resp == 'y') {
                    System.out.print("Choose option: deposit(D) or withdrawal(W) or status(S) or transfer(T) ");
                    char option = sc.next().charAt(0);
                    if (option == 'D' || option == 'd') {
                        System.out.print("Enter amount for deposit: ");
                        double amount = sc.nextDouble();
                        try {
                            acc.deposit(amount);
                            System.out.println("Account Owner Data: " + acc.getHolder().toString());
                            System.out.printf("New balance: %.2f%n", acc.getBalance());
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (option == 'W' || option == 'w') {
                        System.out.print("Enter amount for withdraw: ");
                        double amount = sc.nextDouble();

                        try {
                            acc.withdraw(amount);
                            System.out.println("Account Owner Data: " + acc.getHolder().toString());
                            System.out.printf("New balance: %.2f%n", acc.getBalance());
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (option == 's' || option == 'S') {
                        System.out.println("\n--- ACCOUNT STATUS ---");
                        System.out.println(acc.getHolder().toString());
                        System.out.printf("Current Balance: $%.2f%n", acc.getBalance());

                    } else if (option == 'T' || option == 't') {

                        System.out.println();
                        System.out.println("Provide the account to be deposited into");
                        int acc1 = sc.nextInt();
                        Account destinationAccont = bank.findAccount(acc1);
                        System.out.println("Destination account " + destinationAccont.getHolder().getName());
                        if(destinationAccont != null && destinationAccont != acc){
                            try {
                                System.out.print("Enter amount to transfer: ");
                                double amount = sc.nextDouble();
                                acc.withdraw(amount);
                                destinationAccont.deposit(amount);
                                System.out.println("Transfer successful!");
                            }catch (RuntimeException e){
                                System.out.println("Erro na transferência: " + e.getMessage());
                            }
                        }

                    }

                    System.out.println();
                    System.out.print("Do you want to perform another operation? (y/n): ");
                    resp = sc.next().charAt(0);
                }
                acc = null;
            }

        }

        System.out.println("Thank you for using our bank!");
        sc.close();
    }
}


