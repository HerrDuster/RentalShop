package com.systemnet.shop.entity;

public class Account extends AbstractEntity<Integer> {

    private String name;
    private String mail;
    private int phone;

    public Account(String name, String mail, int phone) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
