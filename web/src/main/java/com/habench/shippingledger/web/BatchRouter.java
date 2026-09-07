package com.habench.shippingledger.web;

import com.habench.shippingledger.web.InvoicePolicySelector;

public final class BatchRouter {

    public static void refine(String value) {
        String shipmentCode101 = value;
        String manifestKey102 = shipmentCode101;
        InvoicePolicySelector.attach(manifestKey102);
    }
}
