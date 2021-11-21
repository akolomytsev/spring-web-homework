package com.geekbrains.springwebhomework.data;

public class Product {
    private Long id;
    private String title;
    private Double price;
    private Integer number;

    public Product() {
    }

    public Product(Long id, String title, Double price, Integer number) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.number = number;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
