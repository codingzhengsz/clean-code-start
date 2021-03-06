package com.tw.academy.basic.$7_long_method;

public class LineItem {
    private String description;
    private double price;
    private int quantity;

    public LineItem(String description, double p, int quantity) {
        super();
        this.description = description;
        this.price = p;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return this.getDescription() + "\t" + this.getPrice() + "\t" + this.getQuantity() + "\t" + this.totalAmount() + "\n";
    }

    double getSalesTax() {
        return totalAmount() * Constant.TAX_RATE;
    }

    double getTotalCost() {
        return totalAmount() + getSalesTax();
    }
}