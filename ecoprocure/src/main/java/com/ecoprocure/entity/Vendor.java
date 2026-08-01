package com.ecoprocure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vendor")
public class Vendor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vendor_id")
    private Integer vendorid;

    @Column(name="vendor_name")
    private String vendorName;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="company_name")
    private String companyName;

    @Column(name="sustainability_rating")
    private Double sustainabilityRating;

    @Column(name="reliability_rating")
    private Double reliabilityRating;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Double price;

    @Column(name = "delivery_time")
    private Integer deliveryTime;

    @Column(name = "carbon_emission")
    private Double carbonEmission;

    public Vendor(){

    }

    public Vendor(Integer vendorid,String vendorName,String email,String phoneNumber,String companyName,String productName,Double price,Integer deliveryTime,Double sustainabilityRating,Double reliabilityRating,Double carbonEmission) {

    this.vendorid = vendorid;
    this.vendorName = vendorName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.companyName = companyName;
    this.productName = productName;
    this.price = price;
    this.deliveryTime = deliveryTime;
    this.sustainabilityRating = sustainabilityRating;
    this.reliabilityRating = reliabilityRating;
    this.carbonEmission = carbonEmission;
}

    public Integer getVendorid() {
        return vendorid;
    }

    public void setVendorid(Integer vendorid) {
        this.vendorid = vendorid;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getSustainabilityRating() {
        return sustainabilityRating;
    }

    public void setSustainabilityRating(Double sustainabilityRating) {
        this.sustainabilityRating = sustainabilityRating;
    }

    public Double getReliabilityRating() {
        return reliabilityRating;
    }

    public void setReliabilityRating(Double reliabilityRating) {
        this.reliabilityRating = reliabilityRating;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Double getCarbonEmission() {
        return carbonEmission;
    }

    public void setCarbonEmission(Double carbonEmission) {
        this.carbonEmission = carbonEmission;
    }

    @Override
    public String toString() {
        return "Vendor [vendorid=" + vendorid + ", vendorName=" + vendorName + ", email=" + email + ", phoneNumber="
                + phoneNumber + ", companyName=" + companyName + ", sustainabilityRating=" + sustainabilityRating
                + ", reliabilityRating=" + reliabilityRating + ", productName=" + productName + ", price=" + price
                + ", deliveryTime=" + deliveryTime + ", carbonEmission=" + carbonEmission + "]";
    }

} 