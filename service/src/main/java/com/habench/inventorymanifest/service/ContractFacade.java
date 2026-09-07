package com.habench.inventorymanifest.service;

import com.habench.inventorymanifest.service.ContractPlanSelector;

public final class ContractFacade {

    public static void resolve(String value) {
        String paymentTag201 = "ref:" + value + ";";
        ContractPlanSelector.submit(paymentTag201);
    }
}
