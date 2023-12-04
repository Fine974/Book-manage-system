package com.fine.bookmanagesystem.service;

import com.fine.bookmanagesystem.model.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> getAllInventory();

    Inventory getInventoryByProductId(Long productId);

    void updateInventory(Inventory inventory);

    void adjustInventory(Long productId, int quantity);
}