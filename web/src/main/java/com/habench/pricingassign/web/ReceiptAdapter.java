package com.habench.pricingassign.web;

import com.habench.pricingassign.web.ShipmentBroker;

public final class ReceiptAdapter {

    public static void register(String value) {
        String accountRef1 = "ref:" + value + ";";
        ShipmentBroker.attach(accountRef1);
    }
}
