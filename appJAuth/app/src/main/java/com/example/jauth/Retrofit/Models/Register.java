package com.example.jauth.Retrofit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register {
    @SerializedName("user_id")
    @Expose
    private String user_id;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

    public Register(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Register{" +
                "Result='" + result + '\'' +
                '}';
    }
}