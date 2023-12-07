package com.fine.bookmanagesystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private int id;  // Assuming each cart item has a unique ID
    private int userId;
    private int bookId;
    private int quantity;

    private String bookTitle;
    private double bookPrice;
}
