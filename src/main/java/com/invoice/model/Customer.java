package com.invoice.model;

public class Customer {
    private String customerId;
    private String customerName;
    private String customerType;
    private String quota;
    private String nationality;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String customerType, String quota, String nationality) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerType = customerType;
        this.quota = quota;
        this.nationality = nationality;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerType='" + customerType + '\'' +
                ", quota='" + quota + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
