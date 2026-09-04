package com.habench.pricingposting.web;

import com.habench.pricingposting.service.InvoiceBroker;

public final class ShipmentRouter {

    public static void attach(String value) {
        String paymentTag101 = value;
        InvoiceBroker.route(paymentTag101);
    }
}
