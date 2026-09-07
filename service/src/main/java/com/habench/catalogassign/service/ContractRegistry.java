package com.habench.catalogassign.service;

import com.habench.catalogassign.dao.ShipmentCoordinator;

public final class ContractRegistry {

    public static void enrich(String value) {
        String paymentTag201 = "ref:" + value + ";";
        ShipmentCoordinator.refine(paymentTag201);
    }
}
