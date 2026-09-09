package com.habench.paymenttransfer.dao;

import com.habench.paymenttransfer.dao.InvoiceEvaluator;

public final class ShipmentBuilder {

    public static void assemble(String value) {
        String paymentTag501 = "ref:" + value + ";";
        String refundCode502 = paymentTag501;
        InvoiceEvaluator.forward(refundCode502);
    }
}
