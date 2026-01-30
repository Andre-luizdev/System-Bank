package services;

import entities.Account;
import entities.Client;

import java.util.Scanner;

public class RegisterService {

    public static Account createAccount(Scanner sc){

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
        double withdrawLimit = balance;

        Client client = new Client(holder,taxId, email);
        Account account = new Account(number, client, balance, withdrawLimit);
        return account;
    }


}
