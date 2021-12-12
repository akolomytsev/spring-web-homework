package com.geekbrains.springwebhomework.dto;


import com.geekbrains.springwebhomework.data.Product;

import javax.persistence.*;


public class ProductDto {
    private Long id;
    private String title;
    private Integer price;
    private Integer number;



    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.number = product.getNumber();
    }

    public ProductDto() {
    }
}
