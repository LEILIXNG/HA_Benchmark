package com.habench.vendormanifest.web;

import com.habench.vendormanifest.web.AccountCollector;

public final class PaymentCollector {

    public static void register(String value) {
        String orderRef1 = value;
        String quoteRef2 = orderRef1;
        AccountCollector.reconcile(quoteRef2);
    }
}
