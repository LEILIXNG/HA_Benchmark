package com.habench.inventoryassign.service;

import com.habench.inventoryassign.service.ManifestExecutor;

public final class AccountEnricher {

    public static void collect(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        ManifestExecutor.reconcile(shipmentCode201);
    }
}
