package com.habench.fulfilrollup.web;

import com.habench.fulfilrollup.web.BatchPolicySelector;

public final class ShipmentCollector {

    public static void collect(String value) {
        String voucherRef101 = value;
        String paymentTag102 = "ref:" + voucherRef101 + ";";
        BatchPolicySelector.submit(paymentTag102);
    }
}
