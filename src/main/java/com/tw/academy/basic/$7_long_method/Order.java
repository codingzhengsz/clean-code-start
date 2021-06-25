package com.tw.academy.basic.$7_long_method;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    double getTotalSalesTax() {
        return getLineItems().stream().mapToDouble(LineItem::getSalesTax).sum();
    }

    double getTotalAmount() {
        return getLineItems().stream().mapToDouble(LineItem::getTotalCost).sum();
    }
}
