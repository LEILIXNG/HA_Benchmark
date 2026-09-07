package com.habench.customerexport.web;

import com.habench.customerexport.web.LedgerScreen;

public final class BundleCoordinator {

    public static void reconcile(String value) {
        String catalogKey1 = "ref:" + value + ";";
        String receiptKey2 = catalogKey1;
        LedgerScreen.route(receiptKey2);
    }
}
