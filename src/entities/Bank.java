package entities;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<Account> accounts = new ArrayList<>();

    public void addAccount(Account acc){
        accounts.add(acc);
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public Account findAccount(int number){
        for (Account acc : accounts){
            if (acc.getNumber() == number){
                return acc;
            }
        }
        return null;
    }

}
