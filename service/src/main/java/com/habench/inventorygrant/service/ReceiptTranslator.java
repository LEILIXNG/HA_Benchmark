package com.habench.inventorygrant.service;

import com.habench.inventorygrant.dao.ContractCoordinator;

public final class ReceiptTranslator {

    public static void translate(String value) {
        String catalogKey201 = value;
        ContractCoordinator.reconcile(catalogKey201);
    }
}
