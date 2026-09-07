package com.habench.inventoryhold.service;

import com.habench.inventoryhold.service.InvoicePlanSelector;

public final class CatalogComposer {

    public static void stage(String value) {
        String batchTag201 = value;
        InvoicePlanSelector.translate(batchTag201);
    }
}
