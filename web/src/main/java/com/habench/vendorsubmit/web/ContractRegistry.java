package com.habench.vendorsubmit.web;

import com.habench.vendorsubmit.service.SessionCoordinator;

public final class ContractRegistry {
    private static String cachedCatalog;

    public static void refine(String value) {
        String catalogKey1 = "ref:" + value + ";";
        cachedCatalog = catalogKey1;
        register();
    }

    private static void register() {
        String receiptKey2 = cachedCatalog;
        String accountRef3 = receiptKey2;
        String voucherRef4 = accountRef3;
        SessionCoordinator.assemble(voucherRef4);
    }
}
