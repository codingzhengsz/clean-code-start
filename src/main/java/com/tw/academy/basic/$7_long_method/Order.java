package com.tw.academy.basic.$7_long_method;

import java.util.List;
import java.util.stream.Collectors;

import static com.tw.academy.basic.$7_long_method.Constant.*;

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

    String generateLineItemMsg() {
        return getLineItems().stream().map(LineItem::toString).collect(Collectors.joining());
    }

    String generateTotalAmount() {
        return TOTAL_AMOUNT + TAB + getTotalAmount();
    }

    String generateStateTax() {
        return SALES_TAX + TAB + getTotalSalesTax();
    }
}
