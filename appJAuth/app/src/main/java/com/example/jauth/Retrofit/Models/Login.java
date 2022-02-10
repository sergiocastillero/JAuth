package com.example.jauth.Retrofit.Models;

public class Login {
    private String user;
    private String result;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Login{" +
                "user='" + user + '\'' +
                ", result=" + result +
                '}';
    }
}
