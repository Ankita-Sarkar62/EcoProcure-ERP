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
@Table(name="purchase_request")
public class PurchaseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "request_id")
    private Integer requestId;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "reason")
    private String reason;
    @Column(name = "status")
    private String status; 
    @ManyToOne
    @JoinColumn(name = "selected_vendor_id")
    private Vendor selectedVendor;


    public PurchaseRequest(){

    }
    public PurchaseRequest(Integer requestId, Employee employee, Integer productId,
        Integer quantity, String reason, String status,
        Vendor selectedVendor){
            this.requestId=requestId;
            this.employee = employee;
            this.productId = productId;
            this.quantity = quantity;
            this.reason = reason;
            this.status = status;
            this.selectedVendor = selectedVendor;
        }
    public Integer getRequestId() {
        return requestId;
    }
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }
    public Employee getEmployee() {
    return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Vendor getSelectedVendor() {
        return selectedVendor;
    }
    public void setSelectedVendor(Vendor selectedVendor) {
        this.selectedVendor = selectedVendor;
    }



    @Override
    public String toString() {
        return "PurchaseRequest [requestId=" + requestId + ", employee=" + employee + ", productId=" + productId + ", quantity="
                + quantity + ", reason=" + reason + ", status=" + status + ", selectedVendor=" + selectedVendor + "]";
    }

}
