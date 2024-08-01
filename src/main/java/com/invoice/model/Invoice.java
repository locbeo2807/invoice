package com.invoice.model;

import java.time.LocalDate;

public class Invoice {
    private String customerId;
    private LocalDate invoiceDate;
    private int quantity;
    private double unitPrice;
    private double total;

    public Invoice() {
    }

    public Invoice(String customerId, LocalDate invoiceDate, int quantity, double unitPrice, double total) {
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customerId='" + customerId + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                '}';
    }
}
