package com.ecoprocure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecoprocure.entity.PurchaseRequest;
import com.ecoprocure.service.PurchaseRequestService;

@RestController
@RequestMapping("/purchase-request")
public class PurchaseRequestController {
    @Autowired    
    private PurchaseRequestService prs;

    @GetMapping
    public List<PurchaseRequest> getAllRequest(){
        return prs.getAllRequest();
    }
    @PostMapping
    public PurchaseRequest savRequest(@RequestBody PurchaseRequest request){
        return prs.saveRequest(request);
    }
    @GetMapping("/{id}")
    public PurchaseRequest getRequestById(@PathVariable Integer id){
        return prs.getRequestById(id);
    }
    @PutMapping("/{id}")
    public PurchaseRequest PurchaseRequest(@PathVariable Integer id, @RequestBody PurchaseRequest request){
        return prs.updateRequest(id,request);
    }
    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Integer id){
        prs.deleteRequest(id);
        return "Purchase Request Deleted Successfully!!";
    }
    @PostMapping("/{id}/approve")
    public PurchaseRequest approveRequest(@PathVariable Integer id){
        return prs.approveRequest(id);
    }
    @PutMapping("/{id}/reject")
    public PurchaseRequest rejectRequest(@PathVariable Integer id){
        return prs.rejectRequest(id);
    }
    @PutMapping("/assignVendor/{requestId}")
    public PurchaseRequest assignVendor(@PathVariable Integer requestId){
        return prs.assignBestVendor(requestId);
    }
}
