package com.habench.shippingexport.web;

import com.habench.shippingexport.service.ReceiptCoordinator;

public final class OrderBuilder {

    public static void resolve(String value) {
        String orderRef101 = value;
        String quoteRef102 = "ref:" + orderRef101 + ";";
        ReceiptCoordinator.stage(quoteRef102);
    }
}
