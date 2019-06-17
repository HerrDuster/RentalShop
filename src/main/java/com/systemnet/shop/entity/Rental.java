package com.systemnet.shop.entity;

import java.util.List;

public class Rental extends AbstractEntity<Integer> {
    public Rental(int number, String account, int contract, List<Product> product) {
        this.number = number;
        this.account = account;
        this.contract = contract;
        this.product = product;
    }

    public Rental() {
    }

    private int number;
    private String account;
    private int contract;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getContract() {
        return contract;
    }

    public void setContract(int contract) {
        this.contract = contract;
    }

    private List<Product> product;

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public int getNumber() {
        return number;

    }

    public void setNumber(int number) {
        this.number = number;
    }
}
