package com.fine.bookmanagesystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private int userId;
    private int productId;
    private int quantity;
    private double totalPrice;
    private Date orderDate;
    private String bookTitle;
    private String userName;
}
