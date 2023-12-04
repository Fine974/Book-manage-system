package com.fine.bookmanagesystem.service.impl;

import com.fine.bookmanagesystem.mapper.InventoryMapper;
import com.fine.bookmanagesystem.model.Inventory;
import com.fine.bookmanagesystem.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryMapper inventoryMapper;

    @Autowired
    public InventoryServiceImpl(InventoryMapper inventoryMapper) {
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryMapper.getAllInventory();
    }

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        return inventoryMapper.getInventoryByProductId(productId);
    }

    @Override
    public void updateInventory(Inventory inventory) {
        inventoryMapper.updateInventory(inventory);
    }

    @Override
    public void adjustInventory(Long productId, int quantity) {
        inventoryMapper.adjustInventory(productId, quantity);
    }
}