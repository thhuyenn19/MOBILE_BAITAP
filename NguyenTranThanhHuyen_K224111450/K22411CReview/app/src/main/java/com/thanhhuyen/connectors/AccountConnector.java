package com.thanhhuyen.connectors;

import com.thanhhuyen.models.Account;
import com.thanhhuyen.models.ListAccount;

import java.util.ArrayList;

public class AccountConnector {
    private ListAccount listAccount;

    public AccountConnector() {
        listAccount = new ListAccount(); // Danh sách có sẵn 10 account trong constructor
    }

    public ArrayList<Account> getAllAccounts() {
        return listAccount.getAccounts();
    }

    public boolean isExist(Account a) {
        return listAccount.isExist(a);
    }

    public void addAccount(Account a) {
        listAccount.addAccount(a);
    }

    public Account login(String username, String password) {
        return listAccount.login(username, password);
    }
}
