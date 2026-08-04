package com.ecoprocure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoprocure.entity.Dashboard;
import com.ecoprocure.repository.EmployeeRepository;
import com.ecoprocure.repository.ProductRepository;
import com.ecoprocure.repository.PurchaseRequestRepository;
import com.ecoprocure.repository.VendorRepository;

@Service
public class DashboardService {
    @Autowired
    private EmployeeRepository empR;
    public long totalEmployees(){
        return empR.count();
    }

    @Autowired
    private VendorRepository vendR;
    public long totalVendors(){
        return vendR.count();
    }

    @Autowired
    private ProductRepository prodR;
    public long totalProducts() {
    return prodR.count();
    }

    @Autowired
    private PurchaseRequestRepository prR;
    public long totalPurchaseRequests() {
    return prR.count();
    }

    public long pendingRequest(){
        return prR.countByStatus("Pending");
    }

    public long approveRequest(){
        return prR.countByStatus("Approved");
    }

    public long rejectRequest(){
        return prR.countByStatus("Rejected");
    }

    public Dashboard getDashboard(){
        Dashboard db= new Dashboard();//create an empty dashboard  object
        db.setTotalEmployees(empR.count());
        db.setTotalVendors(vendR.count());
        db.setTotalProducts(prodR.count());
        db.setTotalPurchaseRequests(prR.count());
        db.setPendingRequests(prR.countByStatus("Pending"));
        db.setApprovedRequests(prR.countByStatus("Approved"));
        db.setRejectedRequests(prR.countByStatus("Rejected"));

        return db;
    }
}
