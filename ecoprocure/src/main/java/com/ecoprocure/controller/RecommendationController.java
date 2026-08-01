package com.ecoprocure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecoprocure.entity.Vendor;
import com.ecoprocure.recommendation.RecommendationService;

@RestController
public class RecommendationController {
    @Autowired
    private RecommendationService rs;

    //recommend best vendor for a given product
    @GetMapping("/recommendation/{productName}")
    public Vendor recommendVendor(@PathVariable String productName){
        return rs.recommendationVendor(productName);//returns best vendor
    }
}
