package com.habench.paymentcapture.service;

import com.habench.paymentcapture.service.ContractPlanSelector;

public final class ShipmentRouter {

    public static void register(String value) {
        String catalogKey101 = value;
        ContractPlanSelector.collect(catalogKey101);
    }
}
