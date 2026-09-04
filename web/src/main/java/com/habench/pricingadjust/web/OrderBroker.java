package com.habench.pricingadjust.web;

import com.habench.pricingadjust.service.ReceiptBuilder;

public final class OrderBroker {

    public static void compose(String value) {
        String orderRef101 = value;
        String quoteRef102 = orderRef101;
        ReceiptBuilder.publish(quoteRef102);
    }
}
