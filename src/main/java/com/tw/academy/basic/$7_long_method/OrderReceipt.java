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

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append(Constant.RECEIPT_HEADER);

        // print date, bill no, customer name
        output.append(generateCustomerMessage());

        // prints lineItems
        output.append(generateReceiptMessage());

        return output.toString();
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