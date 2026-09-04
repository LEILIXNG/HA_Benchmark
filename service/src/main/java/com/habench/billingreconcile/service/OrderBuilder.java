package com.habench.billingreconcile.service;

import com.habench.billingreconcile.service.BundleTranslator;

public final class OrderBuilder {

    public static void attach(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        BundleTranslator.publish(shipmentCode101);
    }
}
