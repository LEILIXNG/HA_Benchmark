package com.habench.vendorverify.web;

import com.habench.vendorverify.service.ShipmentEnricher;

public final class OrderRouter {

    public static void compose(String value) {
        String invoiceKey101 = "ref:" + value + ";";
        ShipmentEnricher.forward(invoiceKey101);
    }
}
