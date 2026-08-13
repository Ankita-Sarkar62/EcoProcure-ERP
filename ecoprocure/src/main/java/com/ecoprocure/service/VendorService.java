package com.ecoprocure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecoprocure.entity.Vendor;
import com.ecoprocure.exception.ResourceNotFoundException;
import com.ecoprocure.repository.VendorRepository;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vr;

    public List<Vendor> getAllVendors(){
        return vr.findAll();
    }

    public Vendor saveVendors(Vendor vnr){
        return vr.save(vnr);
    }

    public Vendor getVendorByid(Integer id){
        return vr.findById(id).orElseThrow(() ->new ResourceNotFoundException("Vendor not found with ID: " + id));
    }

    public void deleteVendor(Integer id){
        Vendor ven= vr.findById(id).orElseThrow(() ->new ResourceNotFoundException("Vendor not found with ID: " + id));
        vr.delete(ven);
    }

    public Vendor updateVendor(Integer id, Vendor vnr){
        vr.findById(id).orElseThrow(() ->new ResourceNotFoundException("Vendor not found with ID: " + id));
        vnr.setVendorid(id);
        return vr.save(vnr);
    }
}
