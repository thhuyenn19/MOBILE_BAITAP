package com.thanhhuyen.models;

import java.io.Serializable;

public class Account implements Serializable {
    private int ID;
    private String Username;
    private String Password;

    public Account() {
    }

    public Account(int ID, String username, String password) {
        this.ID = ID;
        this.Username = username;
        this.Password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}
