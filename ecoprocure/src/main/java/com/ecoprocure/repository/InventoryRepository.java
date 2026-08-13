package com.ecoprocure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecoprocure.entity.Inventory;

@Repository
public interface InventoryRepository  extends JpaRepository<Inventory, Integer>{
    Optional<Inventory> findByProductName(String prodName);
}
