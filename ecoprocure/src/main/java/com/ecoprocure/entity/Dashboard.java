package com.ecoprocure.entity;

// Dashboard= employee+vendor+product+purchaserequest
public class Dashboard {
    private long totalEmployees;
    private long totalVendors;
    private long totalProducts;
    private long totalPurchaseRequests;
    private long pendingRequests;
    private long approvedRequests;
    private long rejectedRequests;

    public Dashboard(){

    }
    public Dashboard(long totalEmployees,long totalVendors,long totalProducts,long totalPurchaseRequests,long pendingRequests,long approvedRequests,long rejectedRequests) {

        this.totalEmployees = totalEmployees;
        this.totalVendors = totalVendors;
        this.totalProducts = totalProducts;
        this.totalPurchaseRequests = totalPurchaseRequests;
        this.pendingRequests = pendingRequests;
        this.approvedRequests = approvedRequests;
        this.rejectedRequests = rejectedRequests;
    }

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public long getTotalVendors() {
        return totalVendors;
    }

    public void setTotalVendors(long totalVendors) {
        this.totalVendors = totalVendors;
    }

    public long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public long getTotalPurchaseRequests() {
        return totalPurchaseRequests;
    }

    public void setTotalPurchaseRequests(long totalPurchaseRequests) {
        this.totalPurchaseRequests = totalPurchaseRequests;
    }

    public long getPendingRequests() {
        return pendingRequests;
    }

    public void setPendingRequests(long pendingRequests) {
        this.pendingRequests = pendingRequests;
    }

    public long getApprovedRequests() {
        return approvedRequests;
    }

    public void setApprovedRequests(long approvedRequests) {
        this.approvedRequests = approvedRequests;
    }

    public long getRejectedRequests() {
        return rejectedRequests;
    }

    public void setRejectedRequests(long rejectedRequests) {
        this.rejectedRequests = rejectedRequests;
    }
    @Override
    public String toString() {
        return "Dashboard [totalEmployees=" + totalEmployees + ", totalVendors=" + totalVendors + ", totalProducts="
                + totalProducts + ", totalPurchaseRequests=" + totalPurchaseRequests + ", pendingRequests="
                + pendingRequests + ", approvedRequests=" + approvedRequests + ", rejectedRequests=" + rejectedRequests
                + "]";
    }
    
}
