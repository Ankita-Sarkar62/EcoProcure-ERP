package com.ecoprocure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecoprocure.entity.Inventory;
import com.ecoprocure.repository.InventoryRepository;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository ir;

    public List<Inventory> getAllInventory(){
        return ir.findAll();
    }
    public Inventory saveInventory(Inventory inv){
        return ir.save(inv);
    }
    public Inventory getInventoryById(Integer id){
        return ir.findById(id).orElse(null);
    }
    public void deleteInventory(Integer id){
        ir.deleteById(id);
    }
    public Inventory updateInventory(Integer id, Inventory inv){
        inv.setInventoryId(id);
        return ir.save(inv);
    }


    public String checkStockStatus(Integer id){
        Inventory inv=ir.findById(id).orElse(null);

        if(inv ==null){
            return "Inventory not found";
        }
        if(inv.getQuantity()<= inv.getMinimumStock()){
            return "Low Stock!!! Time to reorder.";
        }    
        return "Stock Available";
}}

