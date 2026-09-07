package com.habench.inventorymanifest.service;

import com.habench.inventorymanifest.service.ContractFacade;

public final class LedgerCoordinator {

    public static void translate(String value) {
        String batchTag101 = value;
        ContractFacade.resolve(batchTag101);
    }
}
