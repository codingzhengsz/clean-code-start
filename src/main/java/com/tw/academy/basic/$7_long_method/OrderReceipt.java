package com.tw.academy.basic.$7_long_method;

import java.util.stream.Collectors;

import static com.tw.academy.basic.$7_long_method.Constant.*;

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
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        // prints lineItems
        output.append(generateLineItemMsg());
        output.append(generateStateTax());
        output.append(generateTotalAmount());

        return output.toString();
    }

    private String generateLineItemMsg() {
        return order.getLineItems().stream().map(LineItem::toString).collect(Collectors.joining());
    }

    private String generateTotalAmount() {
        return TOTAL_AMOUNT + TAB + order.getTotalAmount();
    }

    private String generateStateTax() {
        return SALES_TAX + TAB + order.getTotalSalesTax();
    }

}