package com.habench.paymentledger.web;

import com.habench.paymentledger.service.ContractBuilder;

public final class ShipmentResolver {

    public static void refine(String value) {
        String paymentTag101 = value;
        String refundCode102 = paymentTag101;
        ContractBuilder.normalize(refundCode102);
    }
}
