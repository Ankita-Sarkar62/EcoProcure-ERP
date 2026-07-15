package com.ecoprocure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import com.ecoprocure.entity.Vendor;
import com.ecoprocure.service.VendorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class VendorController {
    @Autowired
    private VendorService vs;

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return vs.getAllVendors();
    }
    @PostMapping("/vendors")
    public Vendor saveVendors(@RequestBody Vendor vnr) {
        return vs.saveVendors(vnr);
    }


    @GetMapping("/vendors/{id}")
    public Vendor getVendorByid(@PathVariable Integer id){
        return vs.getVendorByid(id);
    }

    @DeleteMapping("/vendors/{id}")
    public String deleteVendor(@PathVariable Integer id){
        vs.deleteVendor(id);
        return "Vendor deleted Successfully";
    }



    @PutMapping("/vendors/{id}")
    public Vendor updateVendor(@PathVariable Integer id, @RequestBody Vendor vnr){
        return vs.updateVendor(id, vnr);
    }
    
}
