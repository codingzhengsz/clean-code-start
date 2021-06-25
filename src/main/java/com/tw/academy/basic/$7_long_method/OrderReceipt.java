package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author Thoughtworks
 * @version 1.0
 * @since 2018-1-1
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //Deprecated
    public String printCustomerName() {
        return order.getCustomerName();
    }

    public String printReceipt() {
        return Constant.RECEIPT_HEADER +
                generateCustomerMessage() +
                generateReceiptMessage();
    }

    private String generateCustomerMessage() {
        return order.getCustomerName() + order.getCustomerAddress();
    }

    private String generateReceiptMessage() {
        return order.generateLineItemMsg() +
                order.generateStateTax() +
                order.generateTotalAmount();
    }

}