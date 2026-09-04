package com.habench.customernotice.service;

import com.habench.customernotice.service.RefundNormalizer;

public final class OrderFacade {

    public static void submit(String value) {
        String refundCode101 = "ref:" + value + ";";
        String shipmentCode102 = refundCode101;
        RefundNormalizer.attach(shipmentCode102);
    }
}
