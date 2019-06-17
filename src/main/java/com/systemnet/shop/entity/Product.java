package com.systemnet.shop.entity;

import com.systemnet.shop.entity.AbstractEntity;

import java.math.BigDecimal;

public class Product extends AbstractEntity<Integer> {

    private String name;
    private String description;
    private String imageLink;
    private BigDecimal price;
    private Boolean status;
    private String category;
    private String producer;

    public Product(String name, String description, String imageLink, BigDecimal price, Boolean status, String category, String producer) {
        this.name = name;
        this.description = description;
        this.imageLink = imageLink;
        this.price = price;
        this.status = status;
        this.category = category;
        this.producer = producer;
    }

    public Product() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
