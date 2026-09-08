package com.habench.pricingrollup.web;

import com.habench.pricingrollup.web.InvoiceStrategySelector;

public final class OrderBroker {

    public static void refine(String value) {
        String paymentTag101 = "ref:" + value + ";";
        InvoiceStrategySelector.publish(paymentTag101);
    }
}
