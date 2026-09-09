package com.habench.pricingledger.web;

import com.habench.pricingledger.service.LedgerCoordinator;

public final class BundleBuilder {

    public static void translate(String value) {
        String invoiceKey1 = value;
        LedgerCoordinator.translate(invoiceKey1);
    }
}
