package com.ecoprocure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoprocure.entity.PurchaseRequest;
import com.ecoprocure.entity.Vendor;
import com.ecoprocure.recommendation.RecommendationService;
import com.ecoprocure.repository.ProductRepository;
import com.ecoprocure.repository.PurchaseRequestRepository;
import com.ecoprocure.entity.Product;

@Service
public class PurchaseRequestService {
    @Autowired
    private PurchaseRequestRepository prr;

    public List<PurchaseRequest> getAllRequest(){
        return prr.findAll();
    }
    // Create purchase request
    public PurchaseRequest saveRequest(PurchaseRequest request) {
         System.out.println("Employee = " + request.getEmployee());
        request.setStatus("Pending");//by default : pending
        return prr.save(request);
    }

    public PurchaseRequest getRequestById(Integer id) {
        return prr.findById(id).orElse(null);
    }

    public void deleteRequest(Integer id){
        prr.deleteById(id);
    }

    //update request
    public PurchaseRequest updateRequest(Integer id, PurchaseRequest request) {
        request.setRequestId(id);
        return prr.save(request);

    }


    //Approve request
    public PurchaseRequest approveRequest(Integer id){
        PurchaseRequest request=prr.findById(id).orElse(null);
        if(request==null){
            return null;
        }
        request.setStatus("Approved");
        return prr.save(request);
    }

    //Reject request
    public PurchaseRequest rejectRequest(Integer id){
        PurchaseRequest request=prr.findById(id).orElse(null);
        if(request==null){
            return null;
        }
        request.setStatus("Rejected");
        return prr.save(request);
    }



    @Autowired
    private RecommendationService rs;
    @Autowired
    private ProductRepository prodRepo;

    public PurchaseRequest assignBestVendor(Integer requestId){
        PurchaseRequest request=prr.findById(requestId).orElse(null);
        Product prod=prodRepo.findById(request.getProductId()).orElse(null);
        if(request==null){
            return null;
        }
        String productName=prod.getProductName();//get product name
        Vendor bestVendor=rs.recommendationVendor(productName);//find best vendor
        request.setSelectedVendor(bestVendor);//assign the vendor
        return prr.save(request);//save
    }
}
