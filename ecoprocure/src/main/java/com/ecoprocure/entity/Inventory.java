package com.ecoprocure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer inventoryId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "minimum_stock")
    private Integer minimumStock;
    @Column(name = "unite_price")
    private Double unitPrice;
    @Column(name = "carbon_emission")
    private Double carbonEmission;

    //one vendor supplies many inventory items
    @ManyToOne//creates the relationship with Vendor
    @JoinColumn(name = "vendor_id")//@JoinColumn → specifies the foreign key column.
    private Vendor vnd;//this says every thing about the vendor.not only vendor id
    
    
    public Inventory(){

    }
    public Inventory(Integer inventoryId, String productName, Integer quantity, Integer minimumStock, Double unitPrice, Double carbonEmission, Vendor vnd){
        this.inventoryId = inventoryId;
    this.productName = productName;
    this.quantity = quantity;
    this.minimumStock = minimumStock;
    this.unitPrice = unitPrice;
    this.carbonEmission = carbonEmission;
    this.vnd = vnd;
    }




    public Integer getInventoryId() {
        return inventoryId;
    }
    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getMinimumStock() {
        return minimumStock;
    }
    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }
    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Double getCarbonEmission() {
        return carbonEmission;
    }
    public void setCarbonEmission(Double carbonEmission) {
        this.carbonEmission = carbonEmission;
    }
    public Vendor getVnd() {
        return vnd;
    }
    public void setVnd(Vendor vnd) {
        this.vnd = vnd;
    }

    
    @Override
    public String toString() {
        return "Inventory [inventoryId=" + inventoryId + ", productName=" + productName + ", quantity=" + quantity
                + ", minimumStock=" + minimumStock + ", unitPrice=" + unitPrice + ", carbonEmission=" + carbonEmission
                + ", vnd=" + vnd + "]";
    }
}
