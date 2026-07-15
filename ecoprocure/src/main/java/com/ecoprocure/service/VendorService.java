package com.ecoprocure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecoprocure.entity.Vendor;
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
        return vr.findById(id).orElse(null);
    }

    public void deleteVendor(Integer id){
        vr.deleteById(id);
    }

    public Vendor updateVendor(Integer id, Vendor vnr){
        vnr.setVendorid(id);
        return vr.save(vnr);
    }
}
