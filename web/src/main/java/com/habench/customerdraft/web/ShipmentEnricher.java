package com.habench.customerdraft.web;

import com.habench.customerdraft.service.RefundAssembler;

public final class ShipmentEnricher {

    public static void publish(String value) {
        String paymentTag101 = value;
        RefundAssembler.collect(paymentTag101);
    }
}
