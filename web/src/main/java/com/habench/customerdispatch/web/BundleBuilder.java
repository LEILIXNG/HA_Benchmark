package com.habench.customerdispatch.web;

import com.habench.customerdispatch.service.LedgerCoordinator;

public final class BundleBuilder {

    public static void translate(String value) {
        String invoiceKey1 = value;
        LedgerCoordinator.translate(invoiceKey1);
    }
}
