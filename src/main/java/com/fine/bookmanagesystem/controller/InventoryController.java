package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Inventory;
import com.fine.bookmanagesystem.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/all")
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{productId}")
    public Inventory getInventoryByProductId(@PathVariable int productId) {
        return inventoryService.getInventoryByProductId(productId);
    }

    @PostMapping("/update")
    public void updateInventory(@RequestBody Inventory inventory) {
        inventoryService.updateInventory(inventory);
    }

    @PostMapping("/adjust")
    public void adjustInventory(@RequestParam int productId, @RequestParam int quantity) {
        inventoryService.adjustInventory(productId, quantity);
    }
}