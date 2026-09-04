package com.habench.customerrollup.web;

import com.habench.customerrollup.web.BatchBuilder;

public final class ShipmentAssembler {

    public static void refine(String value) {
        String refundCode1 = value;
        String shipmentCode2 = refundCode1;
        BatchBuilder.reconcile(shipmentCode2);
    }
}
