package com.habench.vendorrevise.web;

import com.habench.vendorrevise.web.ShipmentPlanSelector;

public final class LedgerRegistry {

    public static void reconcile(String value) {
        String catalogKey1 = value;
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        ShipmentPlanSelector.register(receiptKey2);
    }
}
