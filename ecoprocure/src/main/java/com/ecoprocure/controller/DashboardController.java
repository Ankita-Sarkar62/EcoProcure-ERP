package com.ecoprocure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecoprocure.entity.Dashboard;
import com.ecoprocure.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService ds;

    @GetMapping("/employees")
    public long totalEmployees(){
        return ds.totalEmployees();
    }

    @GetMapping("/vendors")
    public long totalVendors(){
        return ds.totalVendors();
    }

    @GetMapping("/products")
    public long totalProducts() {
        return ds.totalProducts();
    }

    
    @GetMapping("/requests")
    public long totalPurchaseRequests() {
        return ds.totalPurchaseRequests();
    }
    @GetMapping("/pending")
    public long pendingRequest() {
        return ds.pendingRequest();
    }

    @GetMapping("/approved")
    public long approveRequest() {
        return ds.approveRequest();
    }

    @GetMapping("/rejected")
    public long rejectRequest() {
        return ds.rejectRequest();
    }

    @GetMapping
    public Dashboard getDashboard(){
        return ds.getDashboard();
    }
}
