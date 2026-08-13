package com.ecoprocure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecoprocure.service.InventoryService;

import jakarta.validation.Valid;

import com.ecoprocure.entity.Inventory;
@RestController
public class InventoryController {
    @Autowired
    private InventoryService is;

    @GetMapping("/inventory")
    public List<Inventory> getAllInventory(){
        return is.getAllInventory();
    }
    @PostMapping("/inventory")
    public Inventory saveInventory(@Valid @RequestBody Inventory inv){
        return is.saveInventory(inv);
    }
    @GetMapping("/inventory/{id}")
    public Inventory getInventoryById(@PathVariable Integer id){
        return is.getInventoryById(id);
    }
    @DeleteMapping("/inventory/{id}")
    public String deleteInventory(@PathVariable Integer id){
        is.deleteInventory(id);
        return "inventory Deleted Successfully!!!";
    }
    @PutMapping("/inventory/{id}")
    public Inventory updateInventory(@PathVariable Integer id, @Valid @RequestBody Inventory inv){
        return is.updateInventory(id, inv);
    }
    @GetMapping("/inventory/{id}/status")
    public String checkStockStatus(@PathVariable Integer id){
        return is.checkStockStatus(id);
    }
}
