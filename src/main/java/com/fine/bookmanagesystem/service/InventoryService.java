package com.fine.bookmanagesystem.service;

import com.fine.bookmanagesystem.model.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> getAllInventory();

    Inventory getInventoryByProductId(int productId);

    void updateInventory(Inventory inventory);

    void adjustInventory(int productId, int quantity);
}