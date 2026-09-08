package com.habench.paymentrelease.service;

import com.habench.paymentrelease.service.OrderBroker;

public final class ContractRouter {

    public static void stage(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        OrderBroker.enrich(shipmentCode201);
    }
}
