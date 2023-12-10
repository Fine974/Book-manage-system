package com.fine.bookmanagesystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String title;
    private String author;
    private Double price;
    private String picture;
    private String publisher;
    private int page;
    private String isbn;
}

