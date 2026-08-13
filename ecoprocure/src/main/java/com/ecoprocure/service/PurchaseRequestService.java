package com.ecoprocure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoprocure.entity.PurchaseRequest;
import com.ecoprocure.entity.Vendor;
import com.ecoprocure.exception.ResourceNotFoundException;
import com.ecoprocure.recommendation.RecommendationService;
import com.ecoprocure.repository.InventoryRepository;
import com.ecoprocure.repository.ProductRepository;
import com.ecoprocure.repository.PurchaseRequestRepository;
import com.ecoprocure.entity.Inventory;
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
        return prr.findById(id).orElseThrow(() ->new ResourceNotFoundException("Purchase Request not found with ID: " + id));
    }

    public void deleteRequest(Integer id){
        PurchaseRequest request = prr.findById(id).orElseThrow(() ->new ResourceNotFoundException("Purchase Request not found with ID: " + id));
        prr.delete(request);    
    }

    //update request
    public PurchaseRequest updateRequest(Integer id, PurchaseRequest request) {
        prr.findById(id).orElseThrow(() ->new ResourceNotFoundException("Purchase Request not found with ID: " + id));
        request.setRequestId(id);
        return prr.save(request);
    }


    //Approve request
    public PurchaseRequest approveRequest(Integer id){
        PurchaseRequest request = prr.findById(id).orElseThrow(() ->new ResourceNotFoundException("Purchase Request not found with ID: " + id));
        request.setStatus("Approved");
        return prr.save(request);
    }

    //Reject request
    public PurchaseRequest rejectRequest(Integer id){
         PurchaseRequest request = prr.findById(id).orElseThrow(() ->new ResourceNotFoundException("Purchase Request not found with ID: " + id));
        request.setStatus("Rejected");
        return prr.save(request);
    }



    @Autowired
    private RecommendationService rs;
    @Autowired
    private ProductRepository prodRepo;

    public PurchaseRequest assignBestVendor(Integer requestId){
        PurchaseRequest request = prr.findById(requestId).orElseThrow(() ->new ResourceNotFoundException("Purchase Request not found with ID: " + requestId));
        Product prod = prodRepo.findById(request.getProductId()).orElseThrow(() ->new ResourceNotFoundException("Product not found with ID: " + request.getProductId()));
        String productName=prod.getProductName();//get product name
        Vendor bestVendor=rs.recommendationVendor(productName);//find best vendor
        request.setSelectedVendor(bestVendor);//assign the vendor
        return prr.save(request);//save
    }





    //UPDATING INVENTORY WITH DELIVERED REQUESTS
    @Autowired
    private InventoryRepository invRepo;

    public PurchaseRequest markAsDelivered(Integer requestId){
        PurchaseRequest request=prr.findById(requestId).orElseThrow(()-> new ResourceNotFoundException("Purchase request not found with ID" +requestId));
        //getting request id
        if(!"Approved".equals(request.getStatus())){
            throw new IllegalStateException("Only an approved purchase request can be marked as delivered");
        }//request id must be approved

        Product prod=prodRepo.findById(request.getProductId()).orElseThrow(()-> new ResourceNotFoundException("Product not found with ID: "+request.getProductId()));
        //product id from request id

        String productName=prod.getProductName();//productname from productid

        Inventory inv=invRepo.findByProductName(productName).orElseThrow(()-> new ResourceNotFoundException("Inventory not found for product: "+productName));
        //inventory(stock) of that product name
        inv.setQuantity(inv.getQuantity()+request.getQuantity());//adding new delivered product
        invRepo.save(inv);
        request.setStatus("Delivered");//approved -> delivered
        return prr.save(request);
    }
}
