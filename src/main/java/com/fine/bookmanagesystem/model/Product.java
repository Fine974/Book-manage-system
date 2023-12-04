package com.fine.bookmanagesystem.model;

public class Product {
    private Long id;
    private String title;
    private String author;
    private Double price;
    // 其他属性根据需求添加

    // 省略构造方法、getter和setter


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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

