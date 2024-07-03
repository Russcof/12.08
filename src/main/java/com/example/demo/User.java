package com.example.demo;

import java.security.Timestamp;
import java.time.LocalDateTime;

public class User {
    String login;

    String password;

    LocalDateTime date;

    public User(String login, String password, LocalDateTime date) {
        this.login = login;
        this.password = password;
        this.date = date;
    }

    public User() {
    }



    @Override
    public String toString() {
        return "User{" +
                "login ='" + login + '\'' +
                ", password ='" + password + '\'' +
                ", date =" + date +
                '}';
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDate(java.sql.Timestamp timestamp) {
    }
}
