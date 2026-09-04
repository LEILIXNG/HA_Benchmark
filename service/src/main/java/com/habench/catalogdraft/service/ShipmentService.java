package com.habench.catalogdraft.service;

import com.habench.catalogdraft.service.ReceiptPolicySelector;

public final class ShipmentService {

    public static void submit(String value) {
        String quoteRef101 = value;
        ReceiptPolicySelector.prepare(quoteRef101);
    }
}
