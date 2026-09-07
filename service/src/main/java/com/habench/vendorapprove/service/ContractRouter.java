package com.habench.vendorapprove.service;

import com.habench.vendorapprove.service.OrderBroker;

public final class ContractRouter {

    public static void stage(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        OrderBroker.enrich(shipmentCode201);
    }
}
