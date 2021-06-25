package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
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
        double totalSalesTax = 0d;
        double total = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem);

            // calculate sales tax @ rate of 10%
            totalSalesTax += lineItem.getSalesTax();

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            total += lineItem.getTotalCost();
        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalSalesTax);

        // print total amount
        output.append("Total Amount").append('\t').append(total);
        return output.toString();
    }

}