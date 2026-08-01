package com.ecoprocure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecoprocure.entity.PurchaseRequest;

@Repository
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Integer>{
    
}
