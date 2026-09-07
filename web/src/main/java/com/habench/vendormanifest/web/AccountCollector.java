package com.habench.vendormanifest.web;

import com.habench.vendormanifest.service.CatalogRegistry;

public final class AccountCollector {

    public static void reconcile(String value) {
        String refundCode101 = value;
        CatalogRegistry.assemble(refundCode101);
    }
}
