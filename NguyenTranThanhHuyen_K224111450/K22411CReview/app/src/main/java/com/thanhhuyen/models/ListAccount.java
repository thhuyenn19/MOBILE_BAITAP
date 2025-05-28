package com.thanhhuyen.models;

import java.io.Serializable;
import java.util.ArrayList;

public class ListAccount implements Serializable {
    private ArrayList<Account> accounts;

    public ListAccount() {
        accounts = new ArrayList<>();

        accounts.add(new Account(1, "user1", "123"));
        accounts.add(new Account(2, "admin", "admin123"));
        accounts.add(new Account(3, "guest", "guest"));
        accounts.add(new Account(4, "huyen", "456"));
        accounts.add(new Account(5, "demo", "demo"));
        accounts.add(new Account(6, "user2", "123"));
        accounts.add(new Account(7, "tester", "test123"));
        accounts.add(new Account(8, "dev", "devpass"));
        accounts.add(new Account(9, "student", "abc123"));
        accounts.add(new Account(10, "member", "member"));
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public boolean isExist(Account a) {
        for (Account acc : accounts) {
            if (acc.getID() == a.getID() ||
                    acc.getUsername().equalsIgnoreCase(a.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public Account login(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUsername().equalsIgnoreCase(username) &&
                    acc.getPassword().equals(password)) {
                return acc;
            }
        }
        return null;
    }
}
