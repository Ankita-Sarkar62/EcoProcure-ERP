package com.ecoprocure.recommendation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoprocure.entity.Vendor;
import com.ecoprocure.repository.VendorRepository;

@Service
public class RecommendationService {
    @Autowired
    private VendorRepository vr;

    private static class BestValues{
        double minPrice;
        double maxSustainability;
        double maxReliability;
        int minDeliveryTime;
        double minCarbonEmission;
    }
    public Vendor recommendationVendor(String productName){
        List<Vendor> ven= vr.findAll();
        
        BestValues bv=findBestValues(ven);
        Vendor bestVendor=null;
        double bestScore=-1;

        for(Vendor v: ven){
            if(!v.getProductName().equalsIgnoreCase(productName)){
                continue;
            }
            double score=calcualteScore(v,bv);

            if(score>bestScore){
                bestScore=score;
                bestVendor=v;
            }
        }
        return bestVendor;
    }
    /*
     Vendor  Product  Price  Sustainability  Reliability  Delivery Time  Carbon 
     Green   Laptop   50000        9.5          9.0              4       5 
     Eco     Laptop   47000        8.8          9.7              3       7 
     Future  Laptop   52000        9.2          8.5              5       4 

    */
    private BestValues findBestValues(List<Vendor> ven){
        BestValues best=new BestValues();
        best.minPrice=Double.MAX_VALUE;
        best.maxSustainability=Double.MIN_VALUE;
        best.maxReliability=Double.MIN_VALUE;
        best.minDeliveryTime=Integer.MAX_VALUE;
        best.minCarbonEmission=Double.MAX_VALUE;

        for(Vendor v: ven){
            if (v.getPrice() == null ||v.getSustainabilityRating() == null ||v.getReliabilityRating() == null ||v.getDeliveryTime() == null ||v.getCarbonEmission() == null) {
                 continue;   // Skip incomplete vendors
            }

            if(v.getPrice()<best.minPrice){
                best.minPrice=v.getPrice();//4700
            }
            if(v.getSustainabilityRating()>best.maxSustainability){
                best.maxSustainability=v.getSustainabilityRating();//9.5
            }
            if (v.getReliabilityRating() > best.maxReliability){
                best.maxReliability = v.getReliabilityRating();//9.7
            }
            if (v.getDeliveryTime() < best.minDeliveryTime){
                best.minDeliveryTime = v.getDeliveryTime();//3
            }
            if (v.getCarbonEmission() < best.minCarbonEmission){
                best.minCarbonEmission = v.getCarbonEmission();//4
            }
            
        }
        return best;
    }


    public double calcualteScore(Vendor ven, BestValues best){
        double score=0;
        score+=(best.minPrice/ven.getPrice())*20;
        score +=(ven.getSustainabilityRating()/best.maxSustainability)*30;
        score+=(ven.getReliabilityRating()/best.maxReliability)*25;
        score += ((double) best.minDeliveryTime / ven.getDeliveryTime()) * 15;
        score += (best.minCarbonEmission / ven.getCarbonEmission()) * 10;
        return score;
    }
/* 
Calculate a weighted score using:
  - Sustainability (30%)
  - Reliability (25%)
  - Price (20%)
 - Delivery Time (15%)
 - Carbon Emission (10%)
 The vendor with the highest score is recommended
 */
}
