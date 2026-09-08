package com.habench.orderrelease.service;

import com.habench.orderrelease.dao.ShipmentCoordinator;

public final class ContractRegistry {

    public static void enrich(String value) {
        String paymentTag201 = "ref:" + value + ";";
        ShipmentCoordinator.refine(paymentTag201);
    }
}
