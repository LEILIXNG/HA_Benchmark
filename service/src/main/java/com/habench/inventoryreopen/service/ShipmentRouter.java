package com.habench.inventoryreopen.service;

import com.habench.inventoryreopen.service.ContractPlanSelector;

public final class ShipmentRouter {

    public static void register(String value) {
        String catalogKey101 = value;
        ContractPlanSelector.collect(catalogKey101);
    }
}
